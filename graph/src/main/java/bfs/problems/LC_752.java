package bfs.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC_752 {
    public  int openLock(String[] deadends, String target) {
        for (String s : deadends)
            visited.add(s);
        return bfs2(deadends,target);
    }
     HashSet<String> visited = new HashSet<>();

    public String converter(String current, int index, int convertTo) {
        char[] chars = current.toCharArray();
        if (convertTo > 0) {
            chars[index] = (char) ((chars[index] - '0' + 1) % 10 + '0');
        } else {
            chars[index] = (char) ((chars[index] - '0' - 1 + 10) % 10 + '0');
        }
        return new String(chars);
    }
    public  int bfs2(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        String start = "0000";

        if(visited.contains(start))
            return -1;
        queue.add(start);
        visited.add(start);


        for (int size = 1 , level =0 ; !queue.isEmpty() ; size = queue.size() , level++) {
            while (size != 0) {
                String current = queue.remove();
                for(int i = 0 ; i<current.length() ; i++){
                        if(process(converter(current,i,1),target,queue)
                                || process(converter(current,i,-1),target,queue))
                            return level+1;
                }
                size--;
            }
        }
        return -1;
    }
    public  boolean process(String start , String target,Queue<String> queue) {
        if(start.equals(target))
            return true;
        if(!visited.contains(start)){
            queue.add(start);
            visited.add(start);
        }
        return false;
    }

    public static void main(String[] args) {
        String deadEnds [] ={"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target ="8888";
        System.out.println(new LC_752().openLock(deadEnds,target));
    }
}
