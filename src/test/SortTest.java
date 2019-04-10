package test;

/**
 * @Classname SortTest
 * @Description null
 * @Created by yhl
 */
public class SortTest {

    public static void print(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    //冒泡
    public static int[] sort1(int[] array){
        if (array.length == 0){
            return array;
        }
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        print(array);
        return array;
    }

    //选择
    public int[] sort2(int[] array){
        if(array.length==0){
            return array;
        }
        for(int i = 0;i<array.length;i++){
            int minTmp = i;
            for(int j =0;j<array.length-i;j++){
                if(array[j]<array[minTmp]){
                    minTmp = j;
                }
            }
            int tmp = array[minTmp];
            array[minTmp] = array[i];
            array[i] = tmp;
        }
        print(array);
        return array;
    }

    public static void main(String[] args) {
        int[] a ={1,3,6,2,5,4,7,9,8};
        sort1(a);
    }
}
