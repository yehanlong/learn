package Solution;

/**
 * @Classname Fibonacci
 * @Description null
 * @Created by yhl
 */
public class Fibonacci {

    public static int compute(int n){
        if(n == 1 || n ==2){
            return 1;
        }else {
            return  compute(n -1) + compute(n-2);
        }
    }
    public static void main(String[] args){
        int n = 10;
        int Sum = compute(n);
        System.out.println(Sum);
    }
}
