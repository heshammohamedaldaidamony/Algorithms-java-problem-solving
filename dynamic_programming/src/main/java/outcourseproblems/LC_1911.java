package outcourseproblems;

import java.util.HashMap;
import java.util.Map;

public class LC_1911 {
    int[] nums;
    Map<String, Long> memo = new HashMap<>();

    public long maxAlternatingSum(int[] nums) {
        this.nums = nums;
        return dp(0, true);
    }

    private long dp(int idx, boolean isEven) {
        if (idx == nums.length)
            return 0;

        String key = idx + "|" + isEven;
        if (memo.containsKey(key))
            return memo.get(key);

        long pick = 0;
        if (isEven)
            pick = nums[idx] + dp(idx + 1, false);
        else
            pick = -nums[idx] + dp(idx + 1, true);


        long skip = dp(idx + 1, isEven);

        long result = Math.max(pick, skip);
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {374, 126, 84, 237, 195, 139, 328, 353, 286, 113, 351, 167, 394, 398, 29, 118, 17, 162, 206, 138, 34, 109, 291, 368, 162, 109, 336, 256, 203, 330, 235, 74, 136, 72, 127, 382, 288, 276, 135, 383, 300, 220, 299, 205, 186, 113, 71, 261, 253, 47, 387, 25, 57, 79, 322, 82, 349, 217, 306, 33, 198, 196, 306, 240, 271, 129, 284, 6, 349, 370, 59, 350, 275, 385, 137, 394, 329, 175, 58, 151, 223, 81, 233, 2, 370, 369, 135, 257, 391, 92, 260, 55, 321, 153, 328, 260, 312, 102, 79, 192};
        System.out.println(new LC_1911().maxAlternatingSum(nums));  // Expected output should be the correct maximum alternating sum
    }
}
