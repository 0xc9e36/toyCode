## 服务端
### Cache-Control    
服务器返回该字段，在缓存有效期内，直接从浏览器缓存里面获取数据。
取值：
  - private
  - public
  - max-agetxxx
  - no-cache
  - no-store
### Last-Modified
服务器在响应请求时，告诉浏览器资源的最后修改时间。
### Etag
服务器响应请求时，告诉浏览器当前资源在服务器的唯一标识（生成规则由服务器决定）。

## 客户端
### If-Modified-Since
服务器根据这个时间判断，如果资源修改过，发送200；未修改返回304。

### If-None-Match
再次请求服务器时，通过此字段通知服务器客户段缓存数据的唯一标识。    
服务端对比唯一资源标识，资源被改动则返回200，未改动返回304。


## 步骤
* 1.是否有缓存(Cache-Control)
* 2.是否有Etag
* 3.是否有Last-Modified
* 4.发起请求









