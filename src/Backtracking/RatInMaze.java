package Backtracking;

public class RatInMaze {
    public static void main(String[] args) {
//        int maze[][] = {{1, 0, 0, 0},
//                {1, 1, 0, 1},
//                {0, 1, 0, 0},
//                {1, 1, 1, 1},};
//        findPath(maze, 0, 0);
//        printSolution(ans);

        int maze1[][] = {{1, 1, 1, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1},};
        findPath(maze1, 0, 0);
        printSolution(ans);

    }

    private static void printSolution(int[][] ans) {
        for(int i=0;i<ans.length;i++){
            for(int j = 0; j < ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] ans = new int[4][4];

    private static boolean findPath(int[][] maze, int i, int j) {
        //reached end of matrix
        if (i == maze.length - 1 && j == maze[0].length - 1) {
            ans[i][j] = 1;
            return true;
        } else if (i > maze[0].length - 1 || j > maze[0].length - 1) // i and j out of arr length
            return false;
        else if (maze[i][j] == 0) // no path exist on this cell
            return false;
        else
            ans[i][j] = 1; // path exist through this cell
        if (findPath(maze, i + 1, j) || findPath(maze, i, j + 1)) // check for horizontal or vertical path
            return true;
        return false;
    }
}
