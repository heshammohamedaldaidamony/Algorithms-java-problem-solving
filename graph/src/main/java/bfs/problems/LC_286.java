package bfs.problems;

import bfs.Pair;

import java.util.*;

public class LC_286 {
 // o(v+e) not v*(v+e)
    public void wallsAndGates(int[][] rooms){
        int INF=2147483647;
        int [] dr={-1,1,0,0};
        int [] dc={0,0,1,-1};
        Queue<Pair> queue = new LinkedList<>();
        int [][] visited = new int[rooms.length][rooms[0].length];

        for(int i =0 ; i<rooms.length ; i++){
            for (int j =0 ; j <rooms[i].length ; j++){
                if(rooms[i][j]==0){
                    queue.add(new Pair(i,j));
                    visited[i][j]=1;
                }
            }
        }

        for (int size = queue.size(), level =0  ; !queue.isEmpty() ; size = queue.size() , level++ ) {
            while (size != 0) {
                Pair current =queue.remove();
                for (int i =0 ; i<dc.length ; i++){
                    if(validIndex(rooms,current.first+dr[i],current.second+dc[i])
                            && visited[current.first+dr[i]][current.second+dc[i]]!=1
                            && rooms[current.first+dr[i]][current.second+dc[i]]==INF){
                        rooms[current.first+dr[i]][current.second+dc[i]] = level+1 ;
                        queue.add(new Pair(current.first+dr[i],current.second+dc[i]));
                        visited[current.first+dr[i]][current.second+dc[i]]=1;
                    }
                }
                size--;
            }
        }
    }
    public  boolean validIndex(int[][] graph, int from, int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length ){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int [][] rooms = {{2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
        new LC_286().wallsAndGates(rooms);
        for(int i =0 ; i<rooms.length ; i++){
            for (int j =0 ; j <rooms[i].length ; j++){
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

}
