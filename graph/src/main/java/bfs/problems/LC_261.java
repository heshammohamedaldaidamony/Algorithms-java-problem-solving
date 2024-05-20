package bfs.problems;

import java.util.*;

public class LC_261 {
    static List<Integer> visited;
    static  List<Integer> parent ;
    public static void main(String[] args) {
        List<Integer>[] graph = new List[9];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        graph[1].add(3); // Edge 1-3
        graph[3].add(1); // Edge 3-1

        graph[1].add(5); // Edge 1-5
        graph[5].add(1); // Edge 5-1

        graph[1].add(6); // Edge 1-6
        graph[6].add(1); // Edge 6-1

        graph[5].add(3); // Edge 5-3
        graph[3].add(5); // Edge 3-5

        graph[5].add(4); // Edge 5-4
        graph[4].add(5); // Edge 4-5

        graph[6].add(0); // Edge 6-0
        graph[0].add(6); // Edge 0-6

        graph[4].add(2); // Edge 4-2
        graph[2].add(4); // Edge 2-4

        graph[2].add(8); // Edge 2-8
        graph[8].add(2); // Edge 8-2

        graph[3].add(7); // Edge 3-7
        graph[7].add(3); // Edge 7-3
        System.out.println(validTree(graph.length,graph));


    }
    public static boolean hasCycle(List<Integer>[] graph ){
          visited= new ArrayList<>(Collections.nCopies(graph.length, -1));
           parent = new ArrayList<>(Collections.nCopies(graph.length, -1));
        for (int i =0 ; i<graph.length; i++){
            if(i>0 && visited.get(i)==-1)   // means after the first traverse we find that there are nodes not visited that means it is seperate component 
                return true;
            if (visited.get(i) == -1 && bfs2_cycle(graph,i))
            return true;
        }
        return false;
    }
    public static boolean validTree(int nodes ,List<Integer>[] graph ){
        if(graph.length != nodes-1)
            return false;
        return !hasCycle(graph );
    }
    // what if the graph more than one component and u start from the valid component . the oher components will not be checked so handle this case or remove start and trace the whole graph
    public static boolean bfs2_cycle(List<Integer>[] graph, int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.set(start, start);

        for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (size != 0) {
                int current = queue.remove();
                for (int i : graph[current]) {
                    if (visited.get(i) == parent.get(current)) //fake cycle
                        continue;
                    if (visited.get(i) == -1) {
                        queue.add(i);
                        visited.set(i, i);
                        parent.set(current,i);
                    }
                    else
                        return true;
                }
                size--;
            }

        }
        return false;
    }
}
