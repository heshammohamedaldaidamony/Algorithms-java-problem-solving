package problems.homework2;

import java.util.Arrays;

public class LeetCode_1283 {
    //n
    public static int sumAfterDivision(int[] nums , int divisor){
        int sum=0;
        for(int i =0 ; i <nums.length; i++){
            sum += (nums[i] + divisor - 1) / divisor;
        }
        return sum;
    }
    public static int  smallestDivisor(int[] nums, int threshold) {
        int start=1;int end=Arrays.stream(nums).max().getAsInt(); //n
        int answer=0;
        //n log m
        while (start<=end){
            int mid=start+(end-start)/2;
            if(sumAfterDivision(nums,mid)<=threshold){
                end=mid-1;
                answer=mid;
            }
            else
                start=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr={44,22,33,11,1};
        System.out.println(smallestDivisor(arr,5));
    }
}
