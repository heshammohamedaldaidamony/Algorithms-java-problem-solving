package pickorleave.problems;

public class LC_198 {
    int [][] memo;
    public int rob(int[] nums) {
        memo=new int[nums.length][nums.length];
        for (int i = 0 ; i<memo.length; i++)
            for (int  j =0 ; j<memo[i].length;j++)
                memo[i][j]=-1;
        return dp(nums,0,-1);
    }
    public int dp(int [] nums , int idx, int prev){
        if(idx==nums.length)
            return 0;
        if(prev!=-1 && memo[idx][prev]!=-1)
            return memo[idx][prev];
        int choice1=dp(nums,idx+1,prev);
        int choice2=0;
        if(prev==-1 || idx-prev>1)
        choice2=nums[idx]+dp(nums,idx+1,idx);

        if(prev!=-1)
            memo[idx][prev]=Math.max(choice1,choice2);
        return Math.max(choice1,choice2);
    }
}
