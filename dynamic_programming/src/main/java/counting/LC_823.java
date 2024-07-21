package counting;

import java.util.Arrays;
import java.util.Collections;

public class LC_823 {
    int[] array;
    public int numFactoredBinaryTrees(int[] arr) {
        array=new int[arr.length+1];
        array[0]=0;
        for (int i =1 ; i<array.length ; i++)
            array[i]=arr[i-1];
        Arrays.sort(array);
        return dp(array.length-1,array[array.length-1]);

    }
    public int dp(int idx , int target){
        if (target==1)
            return 1;
        if(idx==0 )
            return 0;

        int parent=0;
        for (int i = idx-1 ; i>=1 ; i--)
            if (target%array[i]==0)
                parent=dp(idx ,target/array[i] );
        int leave=dp(idx-1,array[idx-1]);
        return parent+leave;
    }


    public static void main(String[] args) {
        int [] arr={18,3,6,2};
        System.out.println(new LC_823().numFactoredBinaryTrees(arr));
    }
}
