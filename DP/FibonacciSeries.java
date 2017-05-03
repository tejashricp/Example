/*
*
* fibonacci with recursion and w/o recursion
* */


public class Demo {

    public static void main(String[] args) {
        int n = 9;
        int o = fibonacciByDP(n);
        System.out.println(o);
    }

    //using recursion
    private static int fibonacci(int n,int[] temp) {
        if(n <= 1) {
            temp[n] = n;
            return n;
        }

        int o = (temp[n-1]!=0?temp[n-1]:fibonacci(n-1,temp))+((temp[n-2]!=0?temp[n-2]:fibonacci(n-2,temp)));
        temp[n] = o;
        return o;
    }

    //using DP
    private static int fibonacciByDP(int n) {
        int temp[] = new int[n+1];
        int o = fibonacci(n-1,temp)+fibonacci(n-2,temp);

        return o;
    }



}
