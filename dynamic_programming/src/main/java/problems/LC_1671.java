package problems;

public class LC_1671 {
    int [][] memoryLIS ;
    int [][] memoryLDS ;
    int startLIS;
    int startLDS;
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        memoryLIS = new int[n + 1][n + 1];
        memoryLDS = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memoryLIS[i][j] = -1;
                memoryLDS[i][j] = -1;
            }
        }

//        // an optimization
//        // depends on the mountain constraint . i start form up so why dont search for the start of up
//        int i=1 ;
//        for (; i<nums.length;i++)
//            if(nums[i]>nums[i-1])
//                break;
//        int j=nums.length-1 ;
//        for (; j>0;j--)
//            if(nums[j-1]>nums[j])
//                break;
//        startLIS=i-1;
//        startLDS=j;

        int longestDecreasing=0;
        for (int l =0 ;l<nums.length;l++ ){
            int lis=LIS(nums,nums.length,l);
            int lds=LDS(nums,nums.length,l);
            System.out.println(lis);
            System.out.println(lds);
            System.out.println();
            if(lis==1 || lds ==1)
                continue; // mountain must have 3+ values
            longestDecreasing=Math.max(longestDecreasing,lis+lds-1);
        }
        return nums.length-longestDecreasing;
    }

    public int LIS(int [] sequence, int previous, int start){
        if ( start==sequence.length )
            return 0;
        if(memoryLIS[start][previous]!=-1)
            return memoryLIS[start][previous];

        int choice1= LIS(sequence,previous,start+1); //leave
        int choice2=0;
        if (previous==sequence.length || sequence[start] > sequence[previous] )
            choice2 = 1 + LIS(sequence, start,start+1);

        memoryLIS[start][previous]=Math.max(choice1,choice2);
        return memoryLIS[start][previous];
    }
    public int LDS(int [] sequence, int previous, int start ){
        if ( start==sequence.length )
            return 0;
        if(memoryLDS[start][previous]!=-1)
            return memoryLDS[start][previous];

        int choice1= LDS(sequence,previous,start+1); //leave
        int choice2=0;
        if (previous==sequence.length || sequence[start] < sequence[previous] )
            choice2 = 1 + LDS(sequence, start,start+1);

        memoryLDS[start][previous]=Math.max(choice1,choice2);
        return memoryLDS[start][previous];
    }

    public static void main(String[] args) {
        int[] nums={4,3,2,1,1,2,3,1};
        System.out.println(new LC_1671().minimumMountainRemovals(nums));
    }
}