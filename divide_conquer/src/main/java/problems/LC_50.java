package problems;

public class LC_50 {
    public double myPow(double x, int n) {
        long N=n;
        if (N<0){
            x=1/x;
            N=-N;   //-MAXINT overflows
        }
        return pow(x,N);
    }
    public double pow(double x , long n){
        if (n==0)
            return 1.0;
        double result = pow(x,n/2);
        result*=result;
        if (n%2 !=0)
            result *= x;
        return result;
    }
}
