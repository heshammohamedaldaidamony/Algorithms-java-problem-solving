package problems;

public class SubsetSum {
    public boolean subsetSum(int[] nums , int target){
        return subsetSum2(nums,0,target);
    }
    //for memoization : memo[idx][target]
    public boolean subsetSum2(int[] nums , int idx,int target){
        if (target<0)
            return false;
        if (target==0)
            return true;
        if(idx== nums.length)
            return false;
        if (subsetSum2(nums, idx+1,target))
        return true;
        return  subsetSum2(nums, idx+1,target-nums[idx]);

    }

    public static void main(String[] args) {
        int[] array = { 3, 12, 4, 12, 5, 2 };
        int target=100;
        System.out.println(new SubsetSum().subsetSum(array,target));
    }
}
