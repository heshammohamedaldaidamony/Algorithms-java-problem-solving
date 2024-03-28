package problems.homework1;

public class LeetCode_34 {
    //34
    //log n
    public static int[] searchRange(int[] array, int target) {
        int[] result={-1,-1};
        if(array.length==0)
            return result ;
        //search lower bound
        double beforeValue=target-.5;
        int start=0;int end=array.length-1;
        while (start<end){
            int mid=start+(end-start)/2;

            if(array[mid]>beforeValue)
                end=mid-1;
            else
                start=mid+1;
        }
            if(array[start]==target)
                result[0]=start;
            else if(start<array.length-1 && array[start+1]==target)
                result[0]=start+1;

        //search upper bound
         start=0; end=array.length-1;
        double afterValue=target+.5;
        while (start<end){
            int mid=start+(end-start)/2;

            if(array[mid]>afterValue)
                end=mid-1;
            else
                start=mid+1;
        }
            if(array[start]==target)
                result[1]=start;
            else if(end>0 && array[start-1]==target)
                result[1]=start-1;

        return result;
    }
    public static int[] searchRange2(int[] array, int target){
        int[] result={-1,-1};
        //search lower
        int start=0;int end=array.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(array[mid]==target){
                if (mid>0 && array[mid-1]==target){
                    end=mid-1;
                    continue;
                }
                else{
                    result[0]=mid;
                    break;
                }

            }
            if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        //search upper
        start=0;end=array.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(array[mid]==target){
                 if(mid<array.length-1 && array[mid+1]==target){
                     start=mid+1;
                     continue;
                 }
                 else{
                     result[1]=mid;
                     break;
                 }
            }
            if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return result;
    }
    public static int[] searchRange_drWay(int[] array, int target){
        int[] result={-1,-1};
        //search lower
        int position=-1;
        int start=0;int end=array.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(target==array[mid]){
                position=mid;
                if(mid>0 && array[mid-1]!=target) // the algorithm can be enhanced with this condintion so , i i(mid) the start of the sequence of the target so doesnt matter to search before me
                    break;
                end=mid-1;
                continue;  // enhanced
            }
            else if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        result[0]=position;
        //search upper
         start=0; end=array.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if( target==array[mid]){
                position=mid;
                if(mid < array.length-1 &&array[mid+1]!=target)
                    break;
                start=mid+1;
                continue;
            }
            else if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        result[1]=position;

        return result;
    }

    public static void main(String[] args) {
        int []nums ={7,7};
        nums=searchRange_drWay(nums,7);
        for(int i =0 ; i <nums.length; i++){
            System.out.print(nums[i]+  " ");
        }
    }
}
