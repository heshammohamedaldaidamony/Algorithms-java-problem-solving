package bfs;

import java.util.*;

public class BFS_v2 {
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

        System.out.println(bfs(graph, 1));

    }

    public static List<Integer> bfs(List<Integer>[] graph, int start) {
        List<Integer> length = new ArrayList<>(Collections.nCopies(graph.length, 0));
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));  // pair of the node and the level
        length.set(start, start);

        for (int size = 1; !queue.isEmpty(); size = queue.size()) {
            while (size != 0) {
                Pair current = queue.remove();
                for (int i : graph[current.first]) {
                    if (length.get(i) == 0) {
                        queue.add(new Pair(i, current.second + 1));
                        length.set(i, i);
                    }
                }
                size--;
            }
        }
        return length;
    }

    public static List<Integer> bfs2(List<Integer>[] graph, int start) {
        List<Integer> length = new ArrayList<>(Collections.nCopies(graph.length, 0));
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        length.set(start, start);

        for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (size != 0) {
                int current = queue.remove();
                for (int i : graph[current]) {
                    if (length.get(i) == 0) {
                        queue.add(i);
                        length.set(i, i);
                    }
                }
                size--;
            }

        }
        return length;
    }
}
