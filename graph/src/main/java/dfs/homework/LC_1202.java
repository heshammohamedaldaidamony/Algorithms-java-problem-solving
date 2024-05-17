package dfs.homework;

import java.util.*;

public class LC_1202 {

    static boolean[] visited ;
    static List<Integer> [] graph;
    static List<Integer> nodes;
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        buildGraph(pairs);
        char[] charArray= s.toCharArray();
        for (int i =0 ; i<graph.length ; i++){
            if(!visited[i]) {
                nodes = new ArrayList<>();
                dfs(i);

                String letters = "";
                for (int l : nodes)
                    letters += s.charAt(l);

                Collections.sort(nodes);
                char[] charLetters= letters.toCharArray();
                Arrays.sort(charLetters);
                letters = new String(charLetters) ;

                for (int n = 0; n < nodes.size(); n++)
                    charArray[nodes.get(n)] = letters.charAt(n);
            }
        }

    return new String(charArray);
    }
    public static void dfs(int node) {
        nodes.add(node);
        visited[node]=true;
       for (int i :graph[node]){
           if(!visited[i])  // it is the same use the condition before the loop  . but it is more unsense load to the stack
               dfs(i);
       }
    }
    public  static void addUndirected(List<Integer> [] graph , int from , int to ){
        graph[from].add(to);
        graph[to].add(from);
    }
    public  static void buildGraph(List<List<Integer>> pairs){
        int graphSize=0;
        for (List<Integer> pair : pairs) {
            graphSize = Math.max(graphSize, Math.max(pair.get(0), pair.get(1)));
        }

        graph = new List[graphSize];
        for (int i =0  ;i<graphSize; i++)
            graph[i]=new ArrayList<>();
        for (List<Integer> pair : pairs)
            addUndirected(graph, pair.get(0), pair.get(1));

        visited = new boolean[graphSize];
    }
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 3),
                Arrays.asList(1, 2),
                Arrays.asList(0, 2)
        ));
        System.out.println(smallestStringWithSwaps(s,pairs));

    }
}
