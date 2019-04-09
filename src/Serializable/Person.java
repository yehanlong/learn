package Serializable;

import java.io.Serializable;

/**
 * @Classname Person
 * @Description null
 * @Created by yhl
 */
public class Person implements Serializable {

    //private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;
    private String address;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
