package problems;

public class LC_1671 {
    int [][] memoryLIS ;
    int [][] memoryLDS ;
    public int minimumMountainRemovals(int[] nums) {
        memoryLIS=new int[nums.length+1][nums.length+1];
        memoryLDS=new int[nums.length+1][nums.length+1];
        for(int i =0 ; i<memoryLIS.length;i++)
            for (int j =0 ; j<memoryLIS[i].length ; j++)
                memoryLIS[i][j]=memoryLDS[i][j]=-1;

        // depends on the mountain constraint . i start form up so why dont search for the start of up
        int i=1 ;
        for (; i<nums.length;i++)
            if(nums[i]>nums[i-1])
                break;
        int lis =LIS(nums,nums.length,0);
        int lds= LDS(nums,nums.length,0);
        System.out.println(lis + " " + lds +" "+ nums.length);
        return nums.length-(lis+lds-1);
    }

    public int LIS(int [] sequence, int previous, int start){
        if ( start==sequence.length)
            return 0;
        if(memoryLIS[start][previous]!=-1)
            return memoryLIS[start][previous];

        int choice1= LIS(sequence,previous,start+1); //leave
        int choice2=0;
        if (previous>=sequence.length || sequence[start] > sequence[previous] )
            choice2 = 1 + LIS(sequence, start,start+1);

        memoryLIS[start][previous]=Math.max(choice1,choice2);
        return memoryLIS[start][previous];
    }
    public int LDS(int [] sequence, int previous, int start){
        if ( start==sequence.length)
            return 0;
        if(memoryLDS[start][previous]!=-1)
            return memoryLDS[start][previous];

        int choice1= LDS(sequence,previous,start+1); //leave
        int choice2=0;
        if (previous>=sequence.length || sequence[start] < sequence[previous] )
            choice2 = 1 + LDS(sequence, start,start+1);

        memoryLDS[start][previous]=Math.max(choice1,choice2);
        return memoryLDS[start][previous];
    }
    
    public static void main(String[] args) {
        int[] nums={2,9,19,45,41,96,72,40,100,37,36,13,7};
        System.out.println(new LC_1671().minimumMountainRemovals(nums));
    }
}
