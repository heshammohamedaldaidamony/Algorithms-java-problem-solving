package dfs.homework;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_323 {


    public static int countComponents(int n , List<Integer>[] edges){ // v
        int maxNode=0;
        for (int i =0 ; i< edges.length; i++){
            if(edges[i].get(0)>maxNode)
                maxNode=edges[i].get(0);
            if (edges[i].get(1)>maxNode)
                maxNode=edges[i].get(1);
        }
        List<Integer>[] graph = new ArrayList[maxNode+1];
        for (int i =0 ; i< edges.length; i++){
            graph[edges[i].get(0)]=new ArrayList<>();
            graph[edges[i].get(0)].add(edges[i].get(1));
        }
        int components=0;
        for(int i=0 ; i<graph.length;i++){
            if(graph[i]==null)
                components++;
        }
        return components;
    }
    public static void main(String[] args) {
        int size = 3;
        List<Integer>[] edges = new ArrayList[size];
        for (int i =0 ; i < edges.length;i++)
            edges[i]=new ArrayList<>();

        edges[0].add(0);
        edges[0].add(1);
        edges[1].add(1);
        edges[1].add(2);
        edges[2].add(3);
        edges[2].add(4);

        System.out.println(countComponents(5,edges));

        // there are a case that cant be handled with this algorithm if 2 nodes has the same parent
         size = 3;
         edges = new ArrayList[size];
        for (int i =0 ; i < edges.length;i++)
            edges[i]=new ArrayList<>();

        edges[0].add(0);
        edges[0].add(1);
        edges[1].add(0);
        edges[1].add(2);
        edges[2].add(3);
        edges[2].add(4);

        System.out.println(countComponents(5,edges));
        //print 3 expected 2 so u need the visited array so dfs
    }
}
