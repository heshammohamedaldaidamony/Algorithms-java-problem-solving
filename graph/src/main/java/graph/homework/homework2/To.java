package graph.homework.homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class To {
    String to;
    List<Integer> cost = new ArrayList<>() ;

    public void setCost(int cost){
        this.cost.add(cost);
        for (int i = this.cost.size()-2  ; i >=0 ; i--){
            if(this.cost.get(i)>cost)
                Collections.swap(this.cost,i,i+1);
        }
    }

}
