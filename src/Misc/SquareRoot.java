package Misc;

/**
 * Created by TPathrikar on 9/4/2017.
 */

/*
* Given number n find square root of it
* n = 4 then o/p =2
*
* */
public class SquareRoot {

    public static void main(String[] args) {
        int n = 16;
        System.out.println(findSqrt(n));
    }

    private static int findSqrt(int n) {
        int start = 2;
        while(start<=n/2){
            int quotient = n;
            int remainder = -1;
            for(int i=1;i<=2;i++){
                remainder = quotient%start;
                quotient = quotient/start;
                if(remainder != 0)
                    break;
            }
            if(quotient == 1 && remainder == 0)
                return start;
            start++;
        }
        return -1;
    }
}
