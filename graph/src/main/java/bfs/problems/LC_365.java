package bfs.problems;

import java.util.*;

public class LC_365 {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y < target)
            return false;

        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(new int[]{0,0});     //trick instead of pair

        //for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (!queue.isEmpty() ) {
                int [] current = queue.remove();
                int currentCap1=current[0];
                int currentCap2=current[1];
                if(currentCap1==target || currentCap2==target || currentCap1+currentCap2==target)
                    return true;

                String state = currentCap1+","+currentCap2;   //trick instead of pair
                if(visited.contains(state))    // check the visiting here becouse if this state is visited means the all the childrens exist . so not matter to go in this way again
                    continue;                   // this will affect the size loop . throw an exception . it will try to remove element while the queue is empty . and this happens becouse u skip some size--
                visited.add(state);

                queue.add(new int[]{0,currentCap2}); //empty
                queue.add(new int[]{currentCap1,0});
                queue.add(new int[]{x,currentCap2}); // fill
                int amountPour1To2 = Math.min(currentCap1, y - currentCap2); //pour
                queue.add(new int[]{currentCap1-amountPour1To2,currentCap2+amountPour1To2});
                int amountPour2To1 = Math.min(currentCap2, x - currentCap1);
                queue.add(new int[]{currentCap2-amountPour2To1,currentCap1+amountPour2To1});

                //size--;
            }
        //}
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LC_365().canMeasureWater(2,6,5));
    }
}
