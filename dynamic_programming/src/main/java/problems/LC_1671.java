package problems;

public class LC_1671 {
    final int UP=1;
    final int DOWN=0;
    int start;
    int end;
    int memo[][][];
    public int minimumMountainRemovals(int[] nums) {
        // an optimization
        // depends on the mountain constraint . i start form up so why dont search for the start of up
        int i=1 ;
        for (; i<nums.length;i++)
            if(nums[i]>nums[i-1])
                break;
        int j=nums.length-1 ;
        for (; j>0;j--)
            if(nums[j-1]>nums[j])
                break;
        start =i-1;
        end =j;
        memo=new int[nums.length][nums.length][2];
        for (int r=0 ; r<memo.length;r++)
            for (int c=0 ; c<memo.length;c++)
                memo[r][c][0]=memo[r][c][1]=-1;
        return nums.length-minimumMountainRemovals(nums,start,-1,UP);
    }


    public int minimumMountainRemovals(int[] nums,int idx , int prev,int state) {
        if(idx>end)
            return 0;
        if(prev!=-1 && memo[idx][prev][state]!=-1)
            return memo[idx][prev][state];

        int choice1 = minimumMountainRemovals(nums,idx+1,prev,state); //leave
        int choice2=0;
        int choice3=0;
        if(prev==-1 || (state==UP && nums[idx]>nums[prev]) )// when i down i cant up again so up validation here is must without it . it will go up down up and this is wrong
            choice2=1+minimumMountainRemovals(nums,idx+1,idx,UP);
        else if(nums[idx]<nums[prev])
            choice3=1+minimumMountainRemovals(nums,idx+1,idx,DOWN);
        if(prev!=-1)
            memo[idx][prev][state]=Math.max(choice1,Math.max(choice2,choice3));
        return Math.max(choice1,Math.max(choice2,choice3));
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(new LC_1671().minimumMountainRemovals(nums));
    }
}