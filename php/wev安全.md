## SQL注入问题
造成sql注入的原因是因为程序没有过滤用户输入的内容,  本质上是在执行sql时数据和语句混淆绝对不要相信用户输入的任何数据。    
可以利用addslashes()转义, 对单引号, 双引号, NULL, 反斜杠(\)进行转义。    
预防：
* 1 关闭所有错误提示。
* 2 不能使用mysqli或PDO时, 可以临时使用addslashes() 转义, 前提是数据库为utf-8编码, 并且参数位于"内。
* 3 使用mysqli或pdo预编译处理sql, 原理是命令与参数分两次发送到MYSQL, 这样MYSQL就能识别参数与命令。

## XSS攻击
分为反射型，持久型    
防御：    
* 1 在输出时使用htmlspecialchars()过滤
* 2 针对链接类型（如图片、超链等）的输出也可使用htmlspecialchars进行安全过滤，但如果变量是整个URL则应检查这个变量是否以http或https开头，如果不是则自动补齐避免出现伪协议类的XSS攻击。（例子：<a href=”data:text/html;base64,PHNjcmlwdD5hbGVydCgxKTs8L3NjcmlwdD4=”>xss</a>）
* 3 富文本编辑器采用白名单, 再针对可能出现xss的标签进行安全过滤


## CSRF
攻击者伪造请求，a.com 有一个标签<img src=”http://b.com?action=del&id=1″>，  用户请求a.com, 将会产生一个请求 ：http://b.com?action=del&id=1,， 浏览器会以当前用户在b.com上的身份(cookie信息)发起删除操作
防御：
* 1 对于敏感操作使用随机token验证。 token必须足够随机，验证后立即删除，尽量以post提交防止泄露, 原理: 可以在服务端的session里面存一个token, 然后在用户提交的表单中也带一个token, 这个token不存在cookie中, 攻击者无法伪造此token, 也就攻击失败了。 通常做法是在页面加载时遍历整个dom树，在a和form标签后面加上token.
* 2 验证HTTP Referer字段, 该字段记录了http请求来源地址, 但是不能确保万无一失，依赖于第三方浏览器。
* 3 在HTTP头中自定义属性并验证

## 文件上传漏洞
  - 白名单上传， 结合MIME和后缀检查文件类型
  - 使用随机文件名保存上传的文件，避免因终止符造成的文件名中断
  
  
## 跨域
浏览器同源策略限制，不能访问其他域上的资源。
* 1 JSONP：利用<script>标签可以获取外部资源，url参数上写回调函数名，服务器传参执行。
* 2 CORS：自定义HTTP头部字段与服务器通信
