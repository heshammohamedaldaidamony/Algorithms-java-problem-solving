package topological_sort.problems;

import java.util.*;

public class LC_310 {
    List<Integer>[] graph  ;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        buildGraph(n,edges);
        return bfs(n);
    }
    public  List<Integer> bfs(int n) {
        int[] inDegree = new int[graph.length];  // to find the leaf
        for (int i =0  ; i <graph.length ;i++)
            for (int j : graph[i])
                inDegree[j]++;

        Queue<Integer> readyQueue = new LinkedList<>();
        for (int i =0 ; i<inDegree.length ; i++)
            if(inDegree[i]==1)
                readyQueue.add(i);
        List<Integer> result=new ArrayList<>();
        result.add(0);   //special case n==1
        for (int size = readyQueue.size(); !readyQueue.isEmpty(); size = readyQueue.size()) {
            result =new ArrayList<>();
            while (size != 0) {
                int current = readyQueue.remove();
                result.add(current);
                for (int i : graph[current])
                    if(--inDegree[i]==1)
                        readyQueue.add(i);
                size--;
            }
        }
        return result;
    }
    public void buildGraph(int n, int[][] edges){
        graph= new ArrayList[n];
        for (int i =0 ; i<n ; i++)
            graph[i]=new ArrayList<>();
        //undirected graph
        for (int[] i : edges){
            graph[i[1]].add(i[0]);
            graph[i[0]].add(i[1]);
        }

    }

    public static void main(String[] args) {
        int n = 7;
        int [][] edges ={{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        System.out.println(new LC_310().findMinHeightTrees(n,edges));
    }
}
