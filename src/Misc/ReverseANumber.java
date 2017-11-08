package Misc;

/**
 * Created by TPathrikar on 9/27/2017.
 *
 *
 */
public class ReverseANumber {

    public static void main(String[] args) {
        int n= 12345;
        int out = reverseNumber(n);
    }

    private static int reverseNumber(int n) {
        if(n>9 && n<99){
            reverse(n,10,100);
        }

        return 0;
    }

    private static void reverse(int n, int smallest, int largest) {
        //if(smallest)
    }
}
