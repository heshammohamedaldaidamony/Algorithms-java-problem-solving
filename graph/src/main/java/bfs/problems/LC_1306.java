package bfs.problems;

import java.util.*;

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
    public static boolean canReach_bfs(int[] arr, int start){
        return bfs2(arr,start);
    }
    public static boolean bfs2(int[] graph, int start) {
        List<Integer> visited = new ArrayList<>(Collections.nCopies(graph.length, 0));
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.set(start, start);

        for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (size != 0) {
                int current = queue.remove();
                if(graph[current]==0)
                    return true;

                int way = current+graph[current];
                if(way<graph.length && visited.get(way) == 0){
                        queue.add(way);
                        visited.set(way, way);
                }
                way = current-graph[current];
                if(way>=0&& visited.get(way) == 0){
                    queue.add(way);
                    visited.set(way, way);
                }
                size--;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {4,2,3,0,3,1,2};
        System.out.println(canReach_bfs(arr,5));

    }
}
