package basic;

/**
 * @Classname finalTest
 * @Description null
 * @Created by yhl
 */
// final 修饰的类不能被继承，常用于修饰工具类，不允许第三方修改使用
final class tools {
    String tool;
}

class A {
    final boolean name = false; // final 修饰的变量变成常量，只能被赋值一次(基本类型)
    final int age;
    {
        age = 21; // final 修饰的变量可在构造方法或构造代码块内初始化
    }

    final void method() { // final 修饰的方法不能被重写，但可以重载
        System.out.println("final method");
    }
}

class B extends A {

    String gender;

    // 错误写法，重写父类中的方法
    // public void method() {
    //
    // }

    public void method(String gender) { // 允许重载被final修饰的方法
        this.gender = gender;
    }
}
class C {
    int v;
    public C(int v) {
        this.v = v;
    }
    public void finalFunc(final int i, final C value) {
        // i = 5; 不能改变i的值
        // v = new C(); 不能改变v的值
        value.v = 5; // 可以改变引用对象的值
    }
}

class Demo1 {

    public static void main(String[] args) {
        final B b = new B(); // final 修饰引用类型，地址值仅赋值一次且不能改变，但对象属性值可以改变
        // b = new B(); error
        b.gender = "男";
        System.out.println(b.gender);
        C c = new C(4);
        c.finalFunc(3,c);
        System.out.println(c.v);
    }
}