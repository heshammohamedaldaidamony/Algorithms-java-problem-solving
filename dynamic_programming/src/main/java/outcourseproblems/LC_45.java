package outcourseproblems;

import java.util.Arrays;

public class LC_45 {
    int [] nums;
    int [] memo;
    public int jump(int[] nums) {
        this.nums=nums;
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(0);
    }
    public int dp(int idx ){
        if (idx>=nums.length-1)
            return 0;
        if(nums[idx]==0)
            return Integer.MAX_VALUE/2;
        if (memo[idx]!=-1)
            return memo[idx];

        memo[idx]=Integer.MAX_VALUE;
        for (int i=1;i<=nums[idx] ;i++){
            memo[idx]=Math.min(memo[idx],1+dp(idx+i));
        }
        return memo[idx];
    }

    public static void main(String[] args) {
        int [] nums={2,3,0,1,4};
        System.out.println(new LC_45().jump(nums));
    }
}
