package Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname swap
 * @Description 把一个数组里面的组合全部列出来
 * @Created by yhl
 */
public class swap {

/*
输出所有组合和排列的方法
   public static void StringTest(String[] args)  {
        String[] array = new String[]{"1","2","3","4"};
        listAll(Arrays.asList(array), "");
    }
    public static void listAll(List candidate, String prefix) {
        //if(candidate.isEmpty()){
        System.out.println(prefix);
        //}
        for(int i=0;i<candidate.size();i++) {
            List tmp = new LinkedList(candidate);
            System.out.println("now candidate is: "+candidate);
            listAll(tmp, prefix + tmp.remove(i));//函数中的参数从右边开始解析
        }
    }*/

//输出所有组合的方法
    public static void main(String[] args){
        int[] array=new int[]{1, 2,3,4,5,6};
        permute(array,0);
    }
    public static void permute(int a[],int s){
        if(s==a.length){
            System.out.println(Arrays.toString(a));
        }
        else
            for(int i=s;i<a.length;++i){
                swap(a,s,i);
                permute(a,s+1);


                swap(a,s,i);

            }
    }

    private static void swap(int[] a,int s,int i) {
        int t=a[s];
        a[s]=a[i];
        a[i]=t;

    }
}
