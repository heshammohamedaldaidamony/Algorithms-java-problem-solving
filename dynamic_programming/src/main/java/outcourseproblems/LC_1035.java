package outcourseproblems;

import java.util.Arrays;

public class LC_1035 {
    int[] nums1;
    int[] nums2;
    int[][] memo;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        memo=new int[nums1.length][nums2.length];
        for (int[]arr:memo)
            Arrays.fill(arr,-1);

        return dp(0,0);
    }
    private int dp(int idx1,int idx2){
        if (idx1==nums1.length||idx2==nums2.length)
            return 0;
        if (memo[idx1][idx2]!=-1)
            return memo[idx1][idx2];
        int choice1=0;
        if (nums1[idx1]==nums2[idx2])
            choice1=1+dp(idx1+1,idx2+1);
        int choice2=dp(idx1+1,idx2);
        int choice3=dp(idx1,idx2+1);

        memo[idx1][idx2]=Math.max(choice1,Math.max(choice2,choice3));
        return memo[idx1][idx2] ;
    }

    public static void main(String[] args) {
        int[] nums1={2,5,1,2,5};
        int[] nums2={10,5,2,1,5,2};

        System.out.println(new LC_1035().maxUncrossedLines(nums1,nums2));
    }
}
