package outcourseproblems;

public class LC_647 {
    private String string;
    private Integer[][] memo;

    public int countSubstrings(String s) {
        string = s;
        int n = s.length();
        memo = new Integer[n][n];

        int count = 0;
        for (int start = 0; start < n; start++)
            for (int end = start; end < n; end++)
                count += isPalindrome(start, end) ? 1 : 0;

        return count;
    }

    private boolean isPalindrome(int start, int end) {
        if (start >= end) return true;

        if (memo[start][end] != null) return memo[start][end] == 1;

        boolean isPalin = string.charAt(start) == string.charAt(end) && isPalindrome(start + 1, end - 1);

        memo[start][end] = isPalin ? 1 : 0;
        return isPalin;
    }

    public static void main(String[] args) {
        LC_647 solution = new LC_647();
        System.out.println(solution.countSubstrings("aaa")); // Expected: 6
        System.out.println(solution.countSubstrings("abc")); // Expected: 3
        System.out.println(solution.countSubstrings("ab"));  // Expected: 2
        System.out.println(solution.countSubstrings("aa"));  // Expected: 3
        System.out.println(solution.countSubstrings("aaaaa")); // Expected: 15
    }
}
