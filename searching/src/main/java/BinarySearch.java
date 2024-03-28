public class BinarySearch {
    // log n
    public static int binarySearch(int [] array, int target){
        int start=0;int end=array.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(array[mid]==target)
                return mid;
            if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
