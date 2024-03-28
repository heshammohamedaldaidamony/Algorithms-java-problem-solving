package problems.homework1;

public class LeetCode_441 {
    //brute force
    // n
    public static int arrangeCoins(int n) {
        int rows=0;
        for(int i=1 ;n>=i ;i++){
            n-=i;
            rows++;
        }
        return rows;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));

    }
}
