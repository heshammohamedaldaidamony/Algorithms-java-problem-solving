package problems.homework1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Leetcode_436 {
    //nlogn time , n space
    public static int[] findRightInterval(int[][] intervals) {
        int[] result=new int[intervals.length];

        int[][] sorted = new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++) {  //n
            sorted[i][0]=intervals[i][0];
            sorted[i][1]=intervals[i][1];
            sorted[i][2]=i;

            result[i]=-1;
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0])); //nlogn

        for (int i =0 ;  i<intervals.length;i++){  // nlogn
            int target=intervals[i][1];
            int start=0;int end=sorted.length-1;
            while (start<end){
                int mid=start+(end-start)/2;

                    if(sorted[mid][0]>target)
                        end=mid-1;
                    else if (sorted[mid][0]<target)
                        start=mid+1;
                    else{
                        start=mid;
                        break;
                    }

            }
            if(sorted[start][0]>=target)
                result[i]=sorted[start][2];
            else if(start<sorted.length-1)
                result[i]=sorted[start+1][2];

        }

        return result;
    }

    public static void main(String[] args) {
        int [][]intervals = {{3,4},{2,3},{1,2}};
        int[] result = findRightInterval(intervals);
        for(int i =0 ; i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
