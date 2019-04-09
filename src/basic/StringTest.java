package basic;

/**
 * @Classname StringTest
 * @Description null
 * @Created by yhl
 */
public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Integer n=3;
        Integer m=3;

        System.out.println(n==m);

        String str = new String("hello");
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1==str2);
//
        str1 = str;
        str2 = str;
        System.out.println(str1==str2);
    }

}
