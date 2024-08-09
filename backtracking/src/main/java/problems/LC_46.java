package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_46 {
    int[] nums;
    int n;
    HashSet<Integer> visited=new HashSet<>();
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        n=nums.length;
        backtracking(new ArrayList<>());
        return  result;
    }
    public void backtracking(List<Integer> list){
        if (list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        List<Integer> copy=new ArrayList<>(list);
        for (int i =0 ;i<n; i++){
            if (visited.contains(nums[i]))
                continue;
            visited.add(nums[i]);
            copy.add(nums[i]);
            backtracking(copy);
            copy.removeLast();
            visited.remove(nums[i]);
        }
    }
}
