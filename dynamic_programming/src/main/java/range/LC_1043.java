package range;

//consecutive problem
public class LC_1043 {
    int [] arr;
    int k;
    int [] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr=arr;
        this.k=k;
        memo=new int[arr.length];
        for (int i =0 ; i<memo.length ; i++)
            memo[i]=-1;
        return dp(0);
    }
    public int dp(int idx){
        if (idx==arr.length)
            return 0;
        if(memo[idx]!=-1)
            return memo[idx];

        int countGroup=0;
        int maxInGroup=0;
        int maxResult=0;
        for (int i =idx ;i<arr.length; i++){
            countGroup++;
            if(countGroup>k)
                break;
            maxInGroup=Math.max(maxInGroup,arr[i]);
            maxResult=countGroup*maxInGroup;

            memo[idx]=Math.max(memo[idx],maxResult+dp(i+1));
        }
        return memo[idx];
    }

    public static void main(String[] args) {
        int [] arr={1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(new LC_1043().maxSumAfterPartitioning(arr,4));
    }
}
