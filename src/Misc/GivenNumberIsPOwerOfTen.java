package Misc;

/**
 * Created by TPathrikar on 9/4/2017.
 */
public class GivenNumberIsPOwerOfTen {

    public static void main(String[] args) {
        int n = 100;
        System.out.println(isPowerOfTen(n));
    }

    private static boolean isPowerOfTen(int n) {
        return n << 1 == 0 ? true : false;
    }
}
