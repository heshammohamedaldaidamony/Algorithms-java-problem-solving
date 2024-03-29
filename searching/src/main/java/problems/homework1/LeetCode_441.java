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
    // log n - binary search generalization
    public static boolean possible(int n , long rows){
        long sum=(rows*(rows+1))/2;
        return n>=sum;
    }
    public static int arrangeCoins_drSol(int n) {
        int start=0;int end=n;int answer=0;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(possible(n,mid)){
                start=mid+1;
                answer=mid;
            }
            else
                end=mid-1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));

    }
}
