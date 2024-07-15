package pickorleave.problems;

public class LC_416 {
    // this problem can be solved in 2^n time using hash set .  calculate all the valid sums and store them in the hash and the check if the hash contains totalsum/2
    int totalSum=0;
    Boolean [][] memo ;
    public boolean canPartition(int[] nums) {
        for (int i : nums)
            totalSum+=i;
        if(totalSum%2!=0)  // cant be paritioned
            return false;
        memo=new Boolean[nums.length][totalSum/2 +1];
        return PESS(nums,0,0);
    }
    public boolean PESS(int[] nums , int i , int currentSum){
        if(totalSum==currentSum*2)
            return true;
        if(currentSum>totalSum/2 || i == nums.length )
            return false;

        if(memo[i][currentSum]!=null)
            return memo[i][currentSum];
        boolean pick = PESS(nums,i+1,nums[i]+currentSum);
        boolean leave = PESS(nums,i+1,currentSum);

        memo[i][currentSum]=pick || leave;

        return memo[i][currentSum];
    }
    public static void main(String[] args) {
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};

        System.out.println(new LC_416().canPartition(nums));
    }
}

