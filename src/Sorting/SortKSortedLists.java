package Sorting;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by tpathrikar on 9/23/2017.
 */
public class SortKSortedLists {
    public static void main(String[] args) {
        int[][] in= { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;
        int[] out = mergeKArrays(in);
        for(int i =0;i<out.length;i++){
            System.out.print(out[i]+" ");
        }
    }

    private static int[] mergeKArrays(int[][] in) {
        PriorityQueue<NumberObject> priorityQueue = new PriorityQueue<>();
        for(int i = 0;i<in.length;i++){
            priorityQueue.add(new NumberObject(in[i][0],i,0));
        }
        int[] out = new int[in.length*in[0].length];
        int i = 0;
        while (!priorityQueue.isEmpty()){
            NumberObject numberObject = priorityQueue.poll();
            out[i] = numberObject.data;
            if(numberObject.columnNum+1<in[0].length)
            priorityQueue.add(new NumberObject(in[numberObject.rowNum][numberObject.columnNum+1],numberObject.rowNum,numberObject.columnNum+1));
            i++;
        }
        return out;
    }
}

class NumberObject implements Comparable{
    int data;
    int rowNum;
    int columnNum;

    public NumberObject(int data, int rowNum, int columnNum) {
        this.data = data;
        this.rowNum = rowNum;
        this.columnNum = columnNum;
    }

    @Override
    public int compareTo(Object o) {
        NumberObject o1 = (NumberObject) o;
        if(this.data == o1.data)
            return 0;
        if(this.data > o1.data)
            return 1;
        else return -1;
    }
}