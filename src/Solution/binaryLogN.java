package Solution;

/**
 * @Classname binaryLogN
 * @Description null
 * @Created by yhl
 */
public class binaryLogN {

    public int bsearch(int[] a ,int n,int value){
        int low = 0;
        int high = n-1 ;
        while(low <= high){
            int mid = (low + high)/2;
            //int mid = low + (high-low)/2;
            //int mid = low + ((high-low)>>1);
            if (a[mid] == value){
                return mid;
            }else if (a[mid] < value){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }
}
