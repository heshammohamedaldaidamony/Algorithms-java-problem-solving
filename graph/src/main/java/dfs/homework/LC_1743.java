package dfs.homework;

import java.util.*;

public class LC_1743 {
    static List<Integer>  result;
    static HashMap<Integer, List<Integer>> graph;
    static HashSet<Integer> visited; //use hashset to handle the negative values 

    public static int[] restoreArray(int[][] adjacentPairs) {
        buildGraph(adjacentPairs);
        visited = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                result= new ArrayList<>();
                dfs( entry.getKey());
                break;
            }
        }
        int [] output = new int[result.size()];
        for (int i =0 ; i<output.length ; i++)
            output[i]=result.get(i);
        return output;
    }
    public static void dfs(int node) {
        visited.add(node);
        result.add(node);
        for (int i : graph.get(node)){
            if(!visited.contains(i))
                dfs(i);
        }
    }
    public static void addUndirected(int from , int to ){
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }
    public static void buildGraph(int[][] adjacentPairs){
        graph = new HashMap<>();
        for(int [] pair : adjacentPairs)
            addUndirected(pair[0],pair[1]);
    }

    public static void main(String[] args) {
        int[][] adjacentPairs={{2,1},{3,4},{3,2}};
        int [] result = restoreArray(adjacentPairs);
        for (int i : result)
            System.out.print(i + " ");
    }
}
