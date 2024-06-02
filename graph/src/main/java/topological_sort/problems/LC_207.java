package topological_sort.problems;

import java.util.*;

public class LC_207 {
    List<Integer> [] graph  ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses,prerequisites);
        return topoSort();
    }
    public boolean topoSort(List<Integer>[] graph){
        int[] inDegree = new int[graph.length];
        for (int i =0  ; i <graph.length ;i++)
            for (int j : graph[i])
                inDegree[j]++;

        Queue<Integer> readyQueue = new LinkedList<>();
        for (int i =0 ; i<inDegree.length ; i++)
            if(inDegree[i]==0)
                readyQueue.add(i);

        List<Integer> result = new ArrayList<>();
        while (!readyQueue.isEmpty()){
            int current = readyQueue.remove();
            result.add(current);
            for (int i : graph[current])
                if(--inDegree[i]==0)
                    readyQueue.add(i);
        }
        if(result.size()!=graph.length)
            return false;
        return true;
    }
    public void buildGraph(int numCourses, int[][] prerequisites){
        graph= new ArrayList[numCourses];
        for (int i =0 ; i<numCourses ; i++)
            graph[i]=new ArrayList<>();
        for (int[] i : prerequisites)
            graph[i[1]].add(i[0]);
    }

    public static void main(String[] args) {
        int numCourses= 2;
        int[][] prerequisites={{1,0},{0,1}};
        System.out.println(new LC_207().canFinish(numCourses,prerequisites));
    }

}
