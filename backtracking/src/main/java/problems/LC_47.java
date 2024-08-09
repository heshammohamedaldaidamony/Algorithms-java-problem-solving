package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_47 {
    int[] nums;
    int n;
    boolean [] visited;
    HashSet<List<Integer>> hashSet=new HashSet<>();
    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums=nums;
        n=nums.length;
        visited=new boolean[n];

        backtracking(new ArrayList<>());
        for (List<Integer> i : hashSet)
            result.add(i);
        return  result;
    }
    public void backtracking(List<Integer> list){
        if (list.size()==nums.length){
            hashSet.add(new ArrayList<>(list));
            return;
        }
        List<Integer> copy=new ArrayList<>(list);
        for (int i =0 ;i<n; i++){
            if (visited[i])
                continue;
            visited[i]=true;
            copy.add(nums[i]);
            backtracking(copy);
            copy.removeLast();
            visited[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(new LC_47().permuteUnique(nums));
    }
}
