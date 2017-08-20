package DP;

/**
 * Created by TPathrikar on 8/19/2017.
 */
/*
* Not working properly
* */
public class AssemblyLineSchedule {
    public static void main(String[] args) {
        int a[][] = {{4, 5, 3, 2},
                    {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                    {0, 9, 2, 8}};
        int e[] = {10, 12};
        int x[] = {18, 7};
        int time  = findMinTime(a,t,e,x);
        System.out.println(time);
    }

    private static int findMinTime(int[][] a, int[][] t, int[] e, int[] x) {
        int lineNumber = 1;
        int stationNumber = 1;
        int min = Integer.MAX_VALUE;
        for(int i = lineNumber;i<3;i++) {
            int time  = e[lineNumber-1]+a[lineNumber-1][stationNumber-1]+findMinAssemblyTime(a,t,e,x,lineNumber,stationNumber+1);
            if(time<min)
                min = time;
        }
        return min;
    }

    private static int findMinAssemblyTime(int[][] a, int[][] t, int[] e, int[] x, int lineNumber, int stationNumber) {

        int stationNumberIndex = stationNumber-1;

        if(stationNumber > 4)
            return x[lineNumber-1];
        int complementaryLine = lineNumber == 1 ? 2:1;
        int localMin = Math.min(a[lineNumber-1][stationNumberIndex],t[lineNumber-1][stationNumberIndex]+a[complementaryLine-1][stationNumberIndex]);
        lineNumber  = a[lineNumber-1][stationNumberIndex]>t[lineNumber-1][stationNumberIndex]+a[complementaryLine-1][stationNumberIndex]? complementaryLine :lineNumber;
        int nextMin =  findMinAssemblyTime(a,t,e,x,lineNumber,stationNumber+1);
        return localMin+nextMin;
    }

}
