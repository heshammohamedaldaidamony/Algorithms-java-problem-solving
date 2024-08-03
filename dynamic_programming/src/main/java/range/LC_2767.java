package range;

public class LC_2767 {
    private String string;
    private Integer[] memo;

    public int minimumBeautifulSubstrings(String s) {
        string = s;
        memo=new Integer[s.length()];
        int result = dp(0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static boolean hasLeadingZeros(String s) {
        return s.length() > 1 && s.charAt(0) == '0';
    }
    private static boolean isPowerOfFive(String s) {
        int n = Integer.parseInt(s, 2);
        if (n < 1) return false;
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    private int dp(int idx) {
        if (idx == string.length())
            return 0;
        if (memo[idx]!=null)
            return memo[idx];

        memo[idx] = Integer.MAX_VALUE;
        for (int i = idx + 1; i <= string.length(); i++) {
            String substring = string.substring(idx, i);
            if (hasLeadingZeros(substring))
                continue;
            if (isPowerOfFive(substring)) {
                int nextResult = dp(i);
                if (nextResult != Integer.MAX_VALUE) {
                    memo[idx] = Math.min(memo[idx], 1 + nextResult);
                }
            }
        }
        return memo[idx];
    }

    public static void main(String[] args) {
        System.out.println(new LC_2767().minimumBeautifulSubstrings("1011")); // Expected output: 2
    }
}
