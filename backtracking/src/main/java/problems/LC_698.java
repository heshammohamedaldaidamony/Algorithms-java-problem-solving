package problems;

import java.util.HashMap;
import java.util.HashSet;

public class LC_698 {
    /*
    //the no search for its group

    int[] nums;
    int k ;
    int groupSum;
    int[] groups;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum=0;
        for (int i =0 ;i<nums.length;i++)
            totalSum+=nums[i];
        if (totalSum%k!=0)
            return false;

        groupSum=totalSum/k;
        this.nums=nums;
        this.k=k;
        groups=new int[k];

        return canPartition(0);
    }
    // the state here is the idx and the groups arr . so u cant memoize it
    public boolean canPartition(int idx){
        if (idx== nums.length)
            return true;  // if all numbers are added then we achieve our sol

        for (int i =0 ; i<k ; i++){
            if (nums[idx]+groups[i]>groupSum)
                continue;
            groups[i]+=nums[idx];
            if (canPartition(idx+1))
                return true;
            groups[i]-=nums[idx];
        }
        return false;
    }

    */

    // fill the group of its numbers
    int[] nums;
    int k ;
    int groupSum;
    boolean[] visited;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum=0;
        for (int i =0 ;i<nums.length;i++)
            totalSum+=nums[i];
        if (totalSum%k!=0)
            return false;

        groupSum=totalSum/k;
        this.nums=nums;
        this.k=k;
        visited=new boolean[nums.length];

        return canPartition(0,0,0);
    }

    private boolean canPartition(int groupIdx , int numberIdx , int curSum) {
        if (groupIdx==k)
            return true;
        if (curSum==groupSum)
            return canPartition(groupIdx+1,0,0);
        if (numberIdx==nums.length)
            return false;

        if (!visited[numberIdx] && nums[numberIdx]+curSum<=groupSum){
            visited[numberIdx]=true;
            if (canPartition(groupIdx,numberIdx+1,curSum+nums[numberIdx]))
                return true;
            visited[numberIdx]=false;
        }
        if (canPartition(groupIdx,numberIdx+1,curSum))
            return true;

        return false;
    }
}
