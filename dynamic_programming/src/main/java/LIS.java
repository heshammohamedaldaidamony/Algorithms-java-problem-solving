import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
    public void print(int[] array){
        for (int i : array)
            System.out.print(i+ " ");
        System.out.println();
    }
    int[] result = new int[6];
    public int lis(int [] sequence,int previousNum , int start){ // 2^n without memoization
        if ( start==result.length){
            int longest=0;
            for (int i : result){
                if(i !=-1)
                    longest++;
            }
            return longest;
        }
        result[start]=-1;
        int choice1=lis(sequence,previousNum,start+1); //leave

        int choice2=0;
        if (sequence[start] >= previousNum ){
            result[start]=sequence[start];  // pick
            choice2=lis(sequence,sequence[start], start+1);
        }
        return Math.max(choice1,choice2);
    }

    public static void main(String[] args) {
        int [] array = {15,2,7,4,6,9};
        System.out.println(new LIS().lis(array,-1,0));


    }

}
