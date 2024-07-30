package outcourseproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_1911 {
    int[] nums;
    HashMap<String,Integer> memo=new HashMap<>();
    public long maxAlternatingSum(int[] nums) {
        this.nums=nums;
        return dp(0,new ArrayList<>());
    }
    public static int alternatingSum(List<Integer> nums) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i % 2 == 0) {
                sum += nums.get(i);
            } else {
                sum -= nums.get(i);
            }
        }
        return sum;
    }
    public int dp(int idx, List<Integer> list){
        if (idx==nums.length)
            return alternatingSum(list);
        String key=String.valueOf(idx)+"|"+String.valueOf(list);

        if (memo.containsKey(key))
            return memo.get(key);

        List<Integer> copy=list;
        copy.add(nums[idx]);
        int pick=dp(idx+1,copy);
        copy.removeLast();
        int leave=dp(idx+1,list);

        memo.put(key,Math.max(pick,leave));
        return memo.get(key);
    }

    public static void main(String[] args) {
        int[] nums={5,6,7,8};
        System.out.println(new LC_1911().maxAlternatingSum(nums));
    }
}
