package range;

public class LC_312 {
    int[] nums;
    int[][] memo;
    public int maxCoins(int[] nums) {
        this.nums=nums;
        this.memo=new int[nums.length][nums.length];
        for (int i =0 ; i<memo.length ; i++)
            for (int j=0 ; j<memo.length; j++)
                memo[i][j]=-1;
        return dp();
    }
    public int countValidCoins(int idx ){
        int coins=1*nums[idx];
        for (int i =idx-1 ; i>=0 ; i--){
            if(nums[i]!=-1){
                coins*=nums[i];
                break;
            }
        }
        for (int i =idx+1 ; i<nums.length ; i++){
            if(nums[i]!=-1){
                coins*=nums[i];
                break;
            }
        }
        return coins;
    }
    public int dp(){
        int maxCoins=0;
        for (int i =0 ; i<nums.length ; i++){
            if(nums[i]==-1)
                continue;
            int myCoins=countValidCoins(i);   //handle the business logic
            int current=nums[i];
            nums[i]=-1;   // remark the ballon as bursted
            maxCoins=Math.max(maxCoins,myCoins + dp());
            nums[i]=current;
            
        }
        return maxCoins;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(new LC_312().maxCoins(nums));
    }
}
