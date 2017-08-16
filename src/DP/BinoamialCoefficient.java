package DP;

/**
 * Created by TPathrikar on 8/16/2017.
 */

/*
*
* Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k).
* For example,
* your function should return 6 for n = 4 and k = 2,
* and it should return 10 for n = 5 and k = 2.
*
* The value of C(n, k) can be recursively calculated using following standard formula for Binomial Coefficients.

   C(n, k) = C(n-1, k-1) + C(n-1, k)
   C(n, 0) = C(n, n) = 1
*
* */
public class BinoamialCoefficient {

    public static void main(String[] args) {
        int n= 4;
        int k = 2;
        int[][] temp = new int[k+1][n+1];
        int out  = getBinomialCoefficient(n,k,temp);
        System.out.println(out);
    }

    private static int getBinomialCoefficient(int n, int k,int[][] temp) {
        if(k == 0|| n == k) {
            temp[k][n] = 1;
            return 1;
        }
        if(temp[k][n] != 0 )
            return temp[k][n];
        int out  = getBinomialCoefficient(n-1,k-1,temp)+getBinomialCoefficient(n-1,k,temp);
        temp[k][n] = out;
        return out;
    }
}
