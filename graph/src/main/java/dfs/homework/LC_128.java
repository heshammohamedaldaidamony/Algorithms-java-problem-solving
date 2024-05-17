package dfs.homework;

import java.util.Arrays;
import java.util.HashSet;

public class LC_128 {
    static HashSet<Integer> visited = new HashSet<>();
    static int length=0;
    static int count ;

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        for (int i=0 ; i< nums.length ; i++){
            if(!visited.contains(nums[i])){
                count=0;
                dfs(i,nums);
                length=Math.max(length,count);
            }
        }
        return length;
    }
    public static void dfs(int indexNode , int [] nums){
        if(!visited.contains(nums[indexNode]))
            count++;
        visited.add(nums[indexNode]);

        if(indexNode+1<nums.length && nums[indexNode+1]-nums[indexNode]<=1 )
            dfs(indexNode+1,nums);
    }


    public static void main(String[] args) {
        int []  nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));

    }
}
