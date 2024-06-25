package problems;

public class LC_1671 {
    int [] memoryLIS ;
    int [] memoryLDS ;
    int startLIS;
    int startLDS;
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        memoryLIS = new int[n + 1];
        memoryLDS = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memoryLIS[i] = -1;
                memoryLDS[i] = -1;
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
            int lis=LIS(nums,l);
            int lds=LDS(nums,l);

            if(lis==1 || lds ==1)
                continue; // mountain must have 3+ values
            longestDecreasing=Math.max(longestDecreasing,lis+lds-1);
        }
        return nums.length-longestDecreasing;
    }

    public int LIS(int [] sequence, int start){
        if ( start==-1 )
            return 0;
        if(memoryLIS[start]!=-1)
            return memoryLIS[start];

        memoryLIS[start]=0;  // to wont be corrupted with memoryLIS[start]++; if it equals -1
        for (int prev =start-1 ; prev>=0; prev--){
            if(sequence[prev] < sequence[start])
                memoryLIS[start]=Math.max(memoryLIS[start],LIS(sequence,prev));
        }
        memoryLIS[start]++;  // this trick instead of 1+LIS to handle -1
        return memoryLIS[start];
    }
    public int LDS(int [] sequence, int start ){
        if ( start==sequence.length )
            return 0;
        if(memoryLDS[start]!=-1)
            return memoryLDS[start];

        memoryLDS[start]=0;
        for (int next =start+1 ; next<sequence.length ; next++){
            if(sequence[next] < sequence[start])
                memoryLDS[start]=Math.max(memoryLDS[start],LDS(sequence,next));
        }
        memoryLDS[start]++;
        return memoryLDS[start];
    }

    public static void main(String[] args) {
        int[] nums={4,3,2,1,1,2,3,1};
        System.out.println(new LC_1671().minimumMountainRemovals(nums));
    }
}