package counting;

public class LC_377 {
    int[] nums;
    int [] memo;
    public int combinationSum4(int[] nums, int target) {
        this.nums=nums;
        this.memo=new int[target+1];
        for (int i=0 ; i<memo.length; i++)
            memo[i]=-1;
        return dp(target);
    }
    public int dp(int target){
        if(target<0)
            return 0;
        if (target==0)
            return 1;
        if (memo[target]!=-1)
            return memo[target];

        memo[target]=0;
        for (int i=0 ; i<nums.length ; i++)
            memo[target]+=dp(target-nums[i]);
        return memo[target];
    }

    public static void main(String[] args) {
        int[] nums={2,1,3};
        System.out.println(new LC_377().combinationSum4(nums,35));
    }
}
