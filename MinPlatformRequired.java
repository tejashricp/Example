/*
* Given arrival and departure times of all trains that reach a railway station,
* find the minimum number of platforms required
* for the railway station so that no train waits.

* */

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        float arr[]  = {9.00f,  9.40f, 9.50f,  11.00f, 15.00f, 18.00f};
        float dep[]  = {9.10f, 12.00f, 11.20f, 11.30f, 19.00f, 20.00f};
        Arrays.sort(arr);
        Arrays.sort(dep);
        System.out.println(getRequiredNumberOfPlatforms(arr,dep));

    }

    private static int getRequiredNumberOfPlatforms(float[] arr, float[] dep) {
        int i=0,j = 0, pltNo = 0;
        int min = 0 ;
        int arrLen = arr.length;
        while (i<arrLen){
            if(arr[i]<dep[j]) {
                pltNo++;
                i++;
            }
            else {
                if(min < pltNo)
                    min = pltNo;
                pltNo--;
                j++;
            }
        }

        return min;
    }


}
