package Array;/*
* In- place rotation of 2D Array by 90 degree clockwise.
* 1   2   3   4
* 5   6   7   8
* 9   10  11  12
* 13  14  15  16
*
*
* o/p(reverse column from bottom to top)
*  4   8  12  16
*  3   7  11  15
*  2   6  10  14
*  1   5   9  13
*
* intermediate answer(make row as column)
*  1  5  9   13
*  2  6  10  14
*  3  7  11  15
*  4  8  12  16
*
*
* */

public class RotateMatrixBy90Degrees {

    public static void main(String[] args) {
        int[][] input = {   { 1,  2 ,  3 , 4 },
                            { 5,  6,   7,  8  },
                            {9,  10,   11, 12},
                            {13, 14,   15, 16}};

        printMatrix(makeRowAsColumn(input));
        System.out.println();
        printMatrix(reverseColumn(input));
    }

    private static int[][] reverseColumn(int[][] input) {
        for(int i=0;i<input[0].length;i++){
            for(int j=0,k=input.length-1;j<k;j++,k--){
                int temp = input[j][i];
                input[j][i] = input[k][i];
                input[k][i] =temp;

            }
        }

        return input;
    }

    private static void printMatrix(int[][] input) {
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static int[][] makeRowAsColumn(int[][] input) {
        int j = 0;
        for(int i=j;i<input.length;i++){
            for(int k=j;k<input[0].length;k++){
                int temp = input[i][k];
                input[i][k] = input[k][i];
                input[k][i] = temp;
            }
            j++;
        }
        return input;

    }

}
