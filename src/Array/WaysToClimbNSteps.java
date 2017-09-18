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
        int[] in = {1,2,3};
        int n = 3;

        System.out.println(getWaysToClimbStepsUtil(in,n));
    }


    public static int ways = 0;
    private static int getWaysToClimbStepsUtil(int[] in, int n) {
        if(n == 0)
            return ways+1;
        if(n <0 )
            return ways;
        for(int i=0;i<in.length;i++) {
            ways = getWaysToClimbStepsUtil(in,n-in[i]);
        }
        return ways;
    }
}
