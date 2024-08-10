import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    int[] sortedArray;
    // nlogn
    public void mergeSort(int[] nums){
        sortedArray =new int[nums.length];
        mergeSort(nums,0,nums.length-1);

    }
    //merging is O(logn)
    private void mergeSort(int [] nums , int start, int end){
        if (start==end)
            return;
        int mid=start + (end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        mergeSortedSubArrays(nums,start,mid,end);
    }

    // O(n)
    private void mergeSortedSubArrays(int[] nums, int start,int mid, int end) {
        for (int i=start, j=mid+1 , k=start ; k<=end ; k++ ){

            if (i>mid)  // arr1 ends before arr2
                sortedArray[k]=nums[j++];

            else if (j>end) {   //arr2 ends before arr1
                sortedArray[k]=nums[i];
                i++;
            }
            else if (nums[i]<nums[j]) {
                sortedArray[k]=nums[i];
                i++;
            }
            else{
                sortedArray[k]=nums[j];
                j++;
            }
        }
        for (int i =start ; i<=end ;i++)
            nums[i]=sortedArray[i];
    }

    public static void main(String[] args) {
        int[] nums={5,4,7,8,1,2,3,69,7,1};
        new MergeSort().mergeSort(nums);
        for (int i : nums )
            System.out.print(i+" ");



    }
}
