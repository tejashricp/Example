package Misc;

import java.util.Arrays;

/**
 * Created by TPathrikar on 9/26/2017.
 */
public class PrintPrimeNumbersLessThanN {
    public static void main(String[] args) {
        int n =50;
        printPrimeLessThan(n);
        n=100;
        System.out.println();
        printPrimeLessThan(n);
    }

    private static void printPrimeLessThan(int n) {
        boolean[] temp = new boolean[n];
        Arrays.fill(temp,true);
        temp[0] = false;
        for(int i =3;i<n;i++){
            for(int j=3;i*j<n;j=j+2)
                temp[i*j] = false;
        }

        int i=2;
        while (i<=n){
            if(temp[i])
                System.out.print(i+" ");
            if(i == 2)
                i=i+1;
            else
                i=i+2;
        }
    }
}
