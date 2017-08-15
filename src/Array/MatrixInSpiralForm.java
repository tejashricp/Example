package Array;/*
* Given a 2D array, print it in spiral form. See the following examples.
* Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output:
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
* */


public class MatrixInSpiralForm {
    public static void main(String[] args) {
    int[][] input  = {  {1,    2,   3,   4},
                        {5,    6,   7,   8},
                        {9,   10,  11,  12},
                        {13,  14,  15,  16}};

    printSpiralArray(input);

    int[][] input1 = {
            {1,   2,   3,   4,  5,   6},
            {7,   8,   9,  10,  11,  12},
            {13,  14,  15, 16,  17,  18}
    };
        System.out.println();
        printSpiralArray(input1);
    }

    private static void printSpiralArray(int[][] input) {
        int imin = 0,jmin=0,imax=input.length-1,jmax = input[0].length-1;
        int i = imin;
        int j = jmin;
        while(true) {

            for (j=jmin; j <= jmax ; ) {
                System.out.print(input[i][j] + " ");
                j++;
            }
            imin++;
            if(imax < imin)
                break;
            j--;
            for (i = imin; i <= imax; ) {
                System.out.print(input[i][j] + " ");
                i++;
            }
            jmax--;
            if(jmax<jmin)
                break;
            i--;
            for (j = jmax; j >= jmin; ) {
                System.out.print(input[i][j] + " ");
                j--;
            }
            imax--;
            if(imax < imin)
                break;
            j++;
            for (i = imax; i >= imin; ) {
                System.out.print(input[i][j] + " ");
                i--;
            }
            jmin++;
            if(jmax<jmin)
                break;
            i++;

        }
    }

}

