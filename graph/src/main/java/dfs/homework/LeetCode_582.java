package dfs.homework;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_582 {
    public static void killProcess(int[] pid , int[]ppid , int kill){
        System.out.print(kill+" ");
        for(int i =0 ; i<ppid.length;i++){
            if(ppid[i]==kill){
                killProcess(pid,ppid, pid[i]);
            }
        }
    }
    public static void main(String[] args) {
        int[] pid= {1,3,10,5};
        int[] ppid = {3,0,5,3};
        int kill=5;

        killProcess(pid,ppid,kill);
        // the issue here if the kill out of range 0:n-1 he will print it which means he killed this node although it doesnt exist

    }
}
