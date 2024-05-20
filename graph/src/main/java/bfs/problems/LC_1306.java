package bfs.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_1306 {
    static HashSet<Integer> visited = new HashSet<>();
    public static boolean canReach(int[] arr, int start) {
        boolean result = false;
        if(visited.contains(start))
            return false;
        if(arr[start]==0)
            return true;

        visited.add(start);

        if(start+arr[start]<arr.length){
            result=  canReach(arr,start+arr[start]);
            if(result)
                return true;
        }

        if(start-arr[start]>=0)
            result=  canReach(arr,start-arr[start]);

        return result;

    }

    public static void main(String[] args) {
        int [] arr = {4,2,3,0,3,1,2};
        System.out.println(canReach(arr,5));

    }
}
