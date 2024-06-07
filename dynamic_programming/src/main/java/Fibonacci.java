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
    public long fib_v2(int n){
        if(n<=1)
            return 1;
        if(memory[n] != -1)
            return memory[n];
        return memory[n] = fib_v2(n-1)+fib_v2(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci= new Fibonacci();
        //System.out.println(fibonacci.fib_v1(80));
        fibonacci.fillArray();
        System.out.println(fibonacci.fib_v2(80));
    }

}
