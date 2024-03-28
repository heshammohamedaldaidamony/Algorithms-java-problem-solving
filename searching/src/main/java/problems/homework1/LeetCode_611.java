package problems.homework1;

import java.util.Arrays;

public class LeetCode_611 {
    //brute force - find the first no smaller than sum of first 2 rib (lower) and find the upper
    // ex ; {4,5,6,7,8,10} find nos less than 4+5 are 6,7,8 then 456 , 457 , 458 are valid triangles
    // n^2 log n
    public static int triangleNumber(int[] nums) {
        int count =0;
        Arrays.sort(nums);  // without sorting it will be n^3
        for(int i =0 ; i<nums.length-2 ; i++){
            for (int j = i+1 ; j<nums.length-1 ; j++){
                int start=j+1;int end=nums.length-1;
                int target=nums[i]+nums[j];
                //lower bound
                int lower=-1;
                while (start<=end){
                    int mid=start+(end-start)/2;
                    if(nums[mid]< target){
                        if(mid-1==j){
                            lower=mid;
                            break;
                        }
                        end=mid-1;
                    }
                    else if (nums[mid]>=target)
                    end=mid-1;
                }
                 start=j+1; end=nums.length-1;
                int upper=-1;
                while (start<=end){
                    int mid=start+(end-start)/2;
                    if(nums[mid]<target){
                        if(mid<nums.length-1 && nums[mid+1]<target){
                            start=mid+1;
                            continue;
                        }
                        upper=mid;
                        break;
                    }
                    else if (nums[mid]>=target)
                        end=mid-1;
                }
                System.out.println(upper + " "+ lower);
                if(upper>=0 && lower>=0)
                    count+=(upper-lower+1);
                System.out.println(count);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int [] nums = {55,24,92,3,69,55,85};
        System.out.println(triangleNumber(nums));
    }
}
