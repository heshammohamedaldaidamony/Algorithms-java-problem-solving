import java.io.LineNumberInputStream;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.List;

public class Knapsack {
    public void print(int[] array){
        for (int i : array)
            System.out.print(i+ " ");
        System.out.println();
    }
    int[] result = new int[5];
    public void fillArray(){
        Arrays.fill(result,-1);
    }

    public int knapsack(int[] weights,int[]values ,int maxSize , int start){
        if ( start==result.length){
            int sumValues=0;
            int sumSize=0;
            for (int i =0 ; i<result.length ; i++){
                if(result[i]!=-1 ){
                    sumValues+=values[i];
                    sumSize+=weights[i];
                }
                if(sumSize>maxSize)
                    return 0;
            }
            return sumValues;
        }
        result[start]=-1;   // leave
        int choice1=knapsack(weights, values,maxSize, start+1) ;

        result[start]=weights[start];    // pick
        int choice2 = knapsack(weights, values,maxSize, start+1);

        return Math.max(choice1,choice2);
    }
    public int knapsack2(int[] weights,int[]values ,int maxSize , int remainingSize, int start){
        if ( start==result.length){
            int sumValues=0;
            for (int i =0 ; i<result.length ; i++){
                if(result[i]!=-1 )
                    sumValues+=values[i];
            }
            return sumValues;
        }
        result[start]=-1;   // leave
        int choice1=knapsack(weights, values,maxSize, start+1) ;

        int choice2=0;
        if (remainingSize <= weights[start]){
            result[start]=weights[start];    // pick
            choice2= knapsack(weights, values,maxSize, start+1);
        }
        return Math.max(choice1,choice2);
    }


    public static void main(String[] args) {
        int maxSize=12;
        int[] weights={10,4,20,5,7};
        int[]values={10,15,3,1,4} ;
        int currentSize=0;
        int start=0;
        new Knapsack().fillArray();
        System.out.println(new Knapsack().knapsack(weights,values,maxSize,start));
        new Knapsack().fillArray();
        System.out.println(new Knapsack().knapsack2(weights,values,maxSize,maxSize,start));


    }
}
