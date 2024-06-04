package topological_sort.problems;

import java.util.*;

public class LC_310 {
    List<Integer>[] graph  ;
    List<Integer>[] levelNodes;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result ;
        buildGraph(n,edges);

        int maxLevel=bfs(n);
        System.out.println(maxLevel);
        result=levelNodes[maxLevel/2];
        if(maxLevel%2 ==0){
            for(int i : levelNodes[maxLevel/2-1])
                result.add(i);
        }
        return result;
    }
    public  int bfs(int n) {
        int []visited = new int[n];

        int[] inDegree = new int[graph.length];  // to find the leaf
        for (int i =0  ; i <graph.length ;i++)
            for (int j : graph[i])
                inDegree[j]++;

        Queue<Integer> readyQueue = new LinkedList<>();
        for (int i =0 ; i<inDegree.length ; i++){
            if(inDegree[i]==1){
                readyQueue.add(i);
                visited[i]=1;
                break;
            }
        }
        levelNodes=new ArrayList[n];
        for (int i =0 ; i<n ; i++)
            levelNodes[i]=new ArrayList<>();

        int level =0;
        for (int size = 1; !readyQueue.isEmpty() ; size = readyQueue.size() , level++) {
            while (size != 0) {
                int current = readyQueue.remove();
                if(inDegree[current]!=1)
                    levelNodes[level].add(current);
                for (int i : graph[current])
                    if(visited[i]!=1){
                        readyQueue.add(i);
                        visited[i]=1;
                    }
                size--;
            }
        }
        return level;
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
        int n = 4;
        int [][] edges ={{1,0},{1,2},{1,3}};
        System.out.println(new LC_310().findMinHeightTrees(n,edges));
    }
}
