package DP;

import javax.naming.ldap.HasControls;
import java.util.HashMap;

/**
 * Created by TPathrikar on 9/1/2017.
 */

/*Suppose that we wish to know which stories in a 100-story building are safe to drop eggs from,
and which will cause the eggs to break on landing.
What strategy should be used to drop eggs such that
total number of drops in worst case is minimized and we find the required floor.
*/

public class EggDrop {
    public static void main(String[] args) {
        int n =2;
        int floor = 100;
        System.out.println(minNumberOfAttempts(n,floor));
        //System.out.println(eggDrop(n,floor));
    }
    public static HashMap<String,Integer> temp = new HashMap<>();
    private static int minNumberOfAttempts(int n, int floor) {
        if(floor == 0 || floor == 1)
            return floor;
        if(n == 1)
            return floor;
        if(temp.containsKey(n+""+floor))
            return temp.get(n+""+floor);
        int min = Integer.MAX_VALUE;

        for(int x = 1;x<=floor;x++){
            int localResult = Math.max(minNumberOfAttempts(n-1,x-1),minNumberOfAttempts(n,floor-x));
            if(localResult<min)
                min = localResult;
        }
        temp.put(n+""+floor,min+1);
        return temp.get(n+""+floor);
    }

    public static int eggDrop(int egg, int floor)
    {
        if (floor == 1 || floor == 0)
            return floor;

        if (egg == 1)
            return floor;

        int min = Integer.MAX_VALUE, x, res;

        for (x = 1; x <= floor; x++)
        {
            res = Math.max(eggDrop(egg-1, x-1), eggDrop(egg, floor-x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }


}
