package Array;

/**
 * Created by TPathrikar on 8/29/2017.
 */

/*
* A kid wants to travel up n steps. She can only go 1, 2 or 3 steps at a time.
How many different ways can she get to the nth step?
* */
public class WaysToClimbNSteps {

    public static void main(String[] args) {
        int[] in = {3,5,10};
        int n = 20;

        System.out.println(getWaysToClimbStepsUtil(in,n,0,0,in.length-1));
    }


    public static int ways = 0;
    private static int getWaysToClimbStepsUtil(int[] in, int n, int sum, int current, int startIndex) {
        if(sum >= 1)
            return n;
        if(sum > n)
            return 0;

        return ways;
    }
}
