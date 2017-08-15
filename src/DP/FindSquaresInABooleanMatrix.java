package DP;

public class FindSquaresInABooleanMatrix {

    public static void main(String[] args) {
        int[][] input  = {  {0,1,1,0,1},
                            {1,1,0,1,0},
                            {0,1,1,0,0},
                            {1,1,1,1,0},
                            {1,1,1,0,1},
                            {0,0,0,0,0}
                        };

        int[][] maxSquare = findMaxSquares(input);
        System.out.println(findMaxValue(maxSquare));
    }

    private static int findMaxValue(int[][] maxSquare) {
        int temp = 0;
        for(int i=1;i<maxSquare.length;i++) {
            for (int j = 1; j < maxSquare[0].length; j++) {
            if(temp < maxSquare[i][j])
                temp = maxSquare[i][j];
            }
        }
        return temp;
    }

    private static int[][] findMaxSquares(int[][] input) {
        int[][] maxNumberOfSquare = new int[input.length][input[0].length];
        for(int i=1;i<input.length;i++){
            for(int j=1;j<input[0].length;j++){
                int min = findMinimumOf(maxNumberOfSquare,i,j);
                if(min == 0)
                    maxNumberOfSquare[i][j] = input[i][j];
                else
                    maxNumberOfSquare[i][j] =  min+1;
            }
        }

        return maxNumberOfSquare;
    }

    private static int findMinimumOf(int[][] maxNumberOfSquare, int i, int j) {
        int tempMin = Math.min(maxNumberOfSquare[i][j-1],maxNumberOfSquare[i-1][j]);
        return Math.min(tempMin,maxNumberOfSquare[i-1][j-1]);
    }
}
