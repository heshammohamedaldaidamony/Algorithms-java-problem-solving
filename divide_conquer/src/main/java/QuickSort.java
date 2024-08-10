

public class QuickSort {
    private int makePivot(int[] nums,int start , int end){
        int mid=start+(end-start) /2;
        int pivot=nums[mid];

        int count=0;
        for (int i =start ; i<=end ; i++){
            if (nums[i]<pivot)
                count++;
        }
        int pivotIdx=start+count;
        swap(nums,pivotIdx,mid);    // the first step is done . the pivot in its right place

        //the next step is to make all prevs of pivot smaller and all nexts bigger
        for (int s=start,e=end ;s<pivotIdx && e>pivotIdx ;s++,e--){
            while (nums[s]<pivot)
                s++;
            while (nums[e]>pivot)
                e--;
            if (s<pivotIdx && e>pivotIdx)  //maybe not matter this condition
                swap(nums,s,e);
        }
        return pivotIdx;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void quickSort(int[] nums,int start , int end){
        if (start>=end)
            return;

        int pivotIdx=makePivot(nums,start,end);
        quickSort(nums,start,pivotIdx-1);
        quickSort(nums,pivotIdx+1,end);
    }
    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }


    public static void main(String[] args) {
        int[] nums ={2,4,5,3,1,8,9,7,8,2,1};
        new QuickSort().quickSort(nums);
        for (int i : nums )
            System.out.print(i+" ");
    }
}
