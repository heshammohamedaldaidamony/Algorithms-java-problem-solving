import java.util.Arrays;

public class Fibonacci {
    public int fib_v1(int n){
        if(n<=1)
            return 1;
        return fib_v1(n-1)+fib_v1(n-2);
    }

    long[] memory = new long[80+1];
    public void fillArray(){
        Arrays.fill(memory,-1);
    }
    //top dowan
    public long fib_v2(int n){
        if(n<=1)
            return 1;
        if(memory[n] != -1)
            return memory[n];
        return memory[n] = fib_v2(n-1)+fib_v2(n-2);
    }
    //bottom up   o(n) time , memory - more efficient with stack(no auxiliary space)
    public long fib_v3(int n){
        long[] fib = new long[n+1];
        fib[0]=fib[1]=1;  // base case
        for (int i =2 ; i<fib.length ; i++)
            fib[i]=fib[i-1] + fib[i-2];
        return fib[n];
    }
    //bottom up enhanced  o(n) time , o(1)memory - more efficient with stack(no auxiliary space)
    public long fib_v3_improved(int n){
        long a=1;
        long b=1;
        long c=-1;
        for (int i =2 ; i<=n ; i++){
            c= a + b;
            a=b;
            b=c;
        }
        return c;
    }


    public static void main(String[] args) {
        Fibonacci fibonacci= new Fibonacci();
        //System.out.println(fibonacci.fib_v1(80));
        fibonacci.fillArray();
        System.out.println(fibonacci.fib_v2(80));
        System.out.println(fibonacci.fib_v3(80));
        System.out.println(fibonacci.fib_v3_improved(80));
    }

}
