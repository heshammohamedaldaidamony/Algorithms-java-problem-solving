package bfs.problems;

import java.util.*;
// for each node u do 3*n edges where n nums lenght and 3 is no of operations so 1001*3*n O(N)
public class LC_2059 {
    static HashSet<Integer> visited = new HashSet<>();
    public static int minimumOperations(int[] nums, int start, int goal) {
        return bfs2(nums,start,goal);
    }
    public static int bfs2(int[] graph, int start , int goal) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        for (int size = 1 , level =0 ; !queue.isEmpty() ; size = queue.size() , level++) {
            while (size != 0) {
                int current = queue.remove();
                for(int i : graph){
                    if(process(graph,current+i,goal,queue) || process(graph,current-i,goal,queue)
                    || process(graph,current^i,goal,queue))
                        return level+1;
                }
                size--;
            }
        }
        return -1;
    }
    public static boolean process(int[] nums, int start , int goal,Queue<Integer> queue) {
        if(start==goal)
            return true;
        if(start>=0 && start<=1000 && !visited.contains(start)){
            queue.add(start);
            visited.add(start);
        }
        return false;
    }

    public static void main(String[] args) {
        int nums [] ={2,8,16};
        System.out.println(minimumOperations(nums,0,1));
    }
}
