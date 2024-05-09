package graph.homework.homework2;

import java.util.ArrayList;
import java.util.List;

public class Chain {
    public static void query(List<Integer>[] graph, int key){
        System.out.print(key+ " ");
        if(graph[key].size()>0)
         query(graph,graph[key].get(0));
    }
    public static void main(String[] args) {
        int size = 6;
        List<Integer>[] graph = new ArrayList[size];
        for (int i =0 ; i < graph.length;i++)
            graph[i]=new ArrayList<>();

        graph[0].add(5);
        graph[1].add(2);
        graph[4].add(1);
        graph[3].add(4);
        graph[5].add(3);

        query(graph,3);

    }
}
