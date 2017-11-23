package pers.tan.annotation;


/**
 * Main class
 *
 * @author tanwei
 * @date 17-11-17
 */
public class Main {

    public static void main(String[] args) {
        //List heros = new ArrayList();
    }

}

interface Person {
    public String Name();

    @Deprecated
    public void Say();    //过期，但不能删除，可以注解已过期
}


class Man implements Person {

    @Override
    public String Name() {
        return null;
    }


    @Override    //若接口没有该方法，会报错
    public void Say() {
    }
}