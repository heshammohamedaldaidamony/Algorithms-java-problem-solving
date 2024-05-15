package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassifyEdges {
    public static void classifyEdges(List<Integer>[] graph ) {
        int nodes= graph.length;
        List<Integer> started = new ArrayList<>(Collections.nCopies(nodes, -1));
        List<Integer> finished = new ArrayList<>(Collections.nCopies(nodes, -1));
        int time=1;
        for (int i =0 ; i<nodes; i++){
            if(started.get(i)==-1)
                dfs(graph,i,started,finished,time);
        }

    }

    private static void dfs(List<Integer>[] graph, int node, List<Integer> started, List<Integer> finished, int time) {
        started.add(node,time++);
        for (int i : graph[node]){
            if (started.get(i)==-1){
                System.out.println("tree edge : "+node + " "+ i);
                dfs(graph, i, started, finished, time);
            }
            else {
                if(started.get(node)< started.get(i))
                    System.out.println("forward edge : "+node + " "+ i);
                else if(finished.get(i)==-1)
                    System.out.println("back edge : "+node + " "+ i);
                else
                    System.out.println("cross edge : "+node + " "+ i);
            }
        }
        finished.add(node,time++);
    }

    public static void main(String[] args) {
        List<Integer>[] graph = new List[4];
        for(int i =0 ; i<graph.length ; i++)
            graph[i]=new ArrayList<>();

        // Data 1
        graph[3] = Arrays.asList(3);
        graph[0] = Arrays.asList(1, 2);
        graph[2] = Arrays.asList(1);
        classifyEdges(graph);
        System.out.println();


        // Data 2
        graph = new List[4];
        for(int i =0 ; i<graph.length ; i++)
            graph[i]=new ArrayList<>();
        graph[3] = Arrays.asList(3);
        graph[0] = Arrays.asList(1, 2);
        graph[1] = Arrays.asList(2);
        classifyEdges(graph);
        System.out.println();

        // Data 3
        graph = new List[10];
        for(int i =0 ; i<graph.length ; i++)
            graph[i]=new ArrayList<>();
        graph[9] = Arrays.asList(2);
        graph[1] = Arrays.asList(3);
        graph[2] = Arrays.asList(4, 5);
        graph[3] = Arrays.asList(6);
        graph[4] = Arrays.asList(7);
        graph[5] = Arrays.asList(6);
        graph[6] = Arrays.asList(7, 8);
        graph[8] = Arrays.asList(2, 6);
        classifyEdges(graph);
        System.out.println();

        // Data 4
        graph = new List[12];
        for(int i =0 ; i<graph.length ; i++)
            graph[i]=new ArrayList<>();
        graph[7] = Arrays.asList(11);
        graph[0] = Arrays.asList(1, 6);
        graph[1] = Arrays.asList(2, 6);
        graph[2] = Arrays.asList(3, 0);
        graph[3] = Arrays.asList(1, 6);
        graph[4] = Arrays.asList(2, 3, 5);
        classifyEdges(graph);
        System.out.println();

        // Data 5
        graph = new List[10];
        for(int i =0 ; i<graph.length ; i++)
            graph[i]=new ArrayList<>();
        graph[9] = Arrays.asList(2, 6);
        graph[0] = Arrays.asList(1, 2);
        graph[1] = Arrays.asList(3, 4);
        graph[2] = Arrays.asList(5, 6);
        graph[4] = Arrays.asList(7);
        graph[8] = Arrays.asList(2, 6);
        classifyEdges(graph);
        System.out.println();


    }
}
