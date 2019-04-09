package test;

/**
 * @Classname HeapTest
 * @Description null
 * @Created by yhl
 */
public class HeapTest {


    private static void swap(int[] array,int left,int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;

    }
    private static void initHeap(int[] array,int index,int end){
        if(array ==null||index>end){
            return;
        }
        for(int i =end ;i>=index;i--){
            int parent = (i-1)/2;
            if(array[parent]<array[i]){
                swap(array,i,parent);
                initHeap(array,index,i);
            }
        }
    }
    private static void print(int[] num) {
        for(int i=0;i<num.length-1;i++){
            System.out.println(num[i]);
        }
    }
    public static void main(String[] args) {

        int[] num = {10, 23, 17, 88, 39, 13, 11, 109, 108, 383, 100, 1, 10, 14};
        initHeap(num,0,num.length-1);
        print(num);
        int newArray[] = new int[num.length+1];
        System.arraycopy(num,0,newArray,0,num.length);
        newArray[num.length-1]=990;
        initHeap(newArray,0,newArray.length-1);
        System.out.println("new Array");
        print(newArray);
    }
}
