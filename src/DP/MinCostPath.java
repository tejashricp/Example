package DP;

/**
 * Created by TPathrikar on 8/16/2017.
 */
/*
* Given a cost matrix cost[][] and a position (m, n) in cost[][],
* write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
* Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n)
* is sum of all the costs on that path (including both source and destination).
* You can only traverse down, right and diagonally
* lower cells from a given cell, i.e., from a given cell (i, j),
* cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
* You may assume that all costs are positive integers.
*
* */

public class MinCostPath {

    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
        int minCOst = findMinCost(cost,2,2);
        System.out.println(minCOst);
        minCOst = findMinCostByDP(cost,2,2,new int[cost.length][cost[0].length]);
        System.out.println(minCOst);
    }

    //recursive solution
    private static int findMinCost(int[][] cost, int row, int column) {
        if(row == 0 && column == 0)
            return cost[row][column];
        if(row<0 || column < 0)
            return Integer.MAX_VALUE;
        return cost[row][column]+Math.min(findMinCost(cost,row-1,column-1),
                Math.min(findMinCost(cost,row-1,column),findMinCost(cost,row,column-1)));
    }

    //by dynamic programming
    private static int findMinCostByDP(int[][] cost, int row, int column,int[][] temp) {
        if(row == 0 && column == 0)
            return cost[row][column];
        if(row<0 || column < 0)
            return Integer.MAX_VALUE;
        if(temp[row][column] != 0)
            return temp[row][column];
        temp[row][column] = cost[row][column]+Math.min(findMinCost(cost,row-1,column-1),
                Math.min(findMinCost(cost,row-1,column),findMinCost(cost,row,column-1)));
        return temp[row][column];
    }

}
