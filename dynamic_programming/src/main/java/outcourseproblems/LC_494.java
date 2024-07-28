package outcourseproblems;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.HashMap;

public class LC_494 {
    int[] nums;
    HashMap<String ,Integer> memo=new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        this.nums=nums;

        return dp(0,target);
    }
    public int dp(int idx , int target){
        if(idx==nums.length && target==0)
            return 1;
        if (idx==nums.length && target!=0)
            return 0;
        String key = String.valueOf(idx) + "|" + String.valueOf(target);
        if (memo.containsKey(key))
            return memo.get(key);

        int positive=dp(idx+1,target-nums[idx]);
        int negative=dp(idx+1,target+nums[idx]);

        memo.put(key,positive+negative);
        return memo.get(key);
    }

}
