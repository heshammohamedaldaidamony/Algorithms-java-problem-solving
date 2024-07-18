package range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_1547 {
    List<Integer> cuts=new ArrayList<>();
    private int[][] memo;

    public int minCost(int n, int[] cuts) {
        this.cuts.add(0);
        this.cuts.add(n);
        for (int i : cuts)
            this.cuts.add(i);
        Collections.sort(this.cuts);
        memo=new int[this.cuts.size()][this.cuts.size()];

        return dp(0,this.cuts.size()-1);
    }
    public int dp(int start , int end){
        if(end == start+1)
            return 0;
        if(memo[start][end]!=0)
            return memo[start][end];

        memo[start][end]=Integer.MAX_VALUE;
        int cost= cuts.get(end)-cuts.get(start);
        for (int i =start+1  ; i<end ; i++){  // loop on cuts list
            int left=dp(start,i);
            int right= dp(i,end);
            memo[start][end] = Math.min(memo[start][end] ,cost+left+right);
        }
        return memo[start][end];
    }
    public static void main(String[] args) {
        int [] cus={1,3,4,5};
        System.out.println(new LC_1547().minCost(7,cus));
    }
}
