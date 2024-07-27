package tabulation;

import java.util.ArrayList;
import java.util.List;

public class LIS {
    int[] memo;
    public int longestIncreasingSubsequence(int[] sequence){
        int[] copySequence=new int[sequence.length+1];
        for (int i =0 ; i<sequence.length ; i++)
            copySequence[i]=sequence[i];
        copySequence[copySequence.length-1]=Integer.MAX_VALUE;  // a trick code to avoid looping on the memo in the end to find the max increasing sequense

        int[] memo=new int[copySequence.length];

        return lis(copySequence);
    }


    public int lis(int[] sequence){
        memo[0]=1;  //base case
        for (int i =1; i<sequence.length ;i++){  //length of the sequence that ends in this number i
            memo[i]=1;   //future validation if i am alone or with a subsequence
            for(int j=i-1 ; j>=0; j--){
                if (memo[j]<memo[i])
                    memo[i]=Math.max(memo[i],1+memo[j]);
            }
        }
        return memo[memo.length-1]-1;  //-1 this one is for the last value (MAX)
    }


    //lis + binary search nlogn n time
    private int bs(List<Integer> list, int v) {
        int l = 0, r = list.size() - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            int cur = list.get(mid);

            if (cur < v) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public int lisBinarySearch(int [] sequence){
        List<Integer> list=new ArrayList<>();
        for (int i =0 ; i<sequence.length ; i++){
            if (list.isEmpty() || sequence[i]>list.get(list.size()-1)){
                list.add(sequence[i]);
            }
            else {
                int idx=bs(list,sequence[i]);
                list.set(idx,sequence[i]);
            }
        }
        return list.size();   //so the longest inc..... is the size of the list 
    }
}
