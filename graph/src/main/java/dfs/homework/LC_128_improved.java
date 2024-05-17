package dfs.homework;

import java.util.HashMap;
import java.util.HashSet;

public class LC_128_improved {
    int length =0;
    int count;
    HashSet<Integer> hashSet = new HashSet<>();


    public  int longestConsecutive(int[] nums) {
        for(int i : nums)
            hashSet.add(i);
        for(int i : nums){
            if(hashSet.contains(i)){
                count =0 ;
                dfs(i);
                length=Math.max(length,count);
            }
        }
        return length;
    }
    public void dfs(int node ){
        count++;
        hashSet.remove(node);
        if(hashSet.contains(node-1))
            dfs(node-1);
        if(hashSet.contains(node+1))
            dfs(node+1);
    }

    public static void main(String[] args) {
        LC_128_improved solution = new LC_128_improved();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums)); // Output: 4
    }
}
