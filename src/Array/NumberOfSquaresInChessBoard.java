package Array;

/**
 * Created by TPathrikar on 8/31/2017.
 */

/*
Find total number of Squares in a N*N chessboard.
* */
public class NumberOfSquaresInChessBoard {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(printNumberOfSquares(n));
        System.out.println(printNumberOfRectangles(n));
    }

    private static int printNumberOfRectangles(int n) {
        int len = 1;
        int breadth = 1;
        int numberOfRectangles = 0;
        while (breadth<=n) {
            while (len <= n) {
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        if (i + len <= n && j + breadth <= n && i + len != j + breadth)
                            numberOfRectangles = numberOfRectangles + 1;
                    }
                }
                len++;
            }
            len = 1;
            breadth++;
        }

        return numberOfRectangles;
    }

    private static int printNumberOfSquares(int n) {
        int numberOfSqrs = n*n;
        int len = 2;
        while (len<=n) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i + len <= n && j + len <= n)
                        numberOfSqrs = numberOfSqrs + 1;
                }
            }
            len++;
        }
        return numberOfSqrs;
    }
}
