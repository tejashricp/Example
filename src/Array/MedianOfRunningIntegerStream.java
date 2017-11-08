package Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by TPathrikar on 10/31/2017.
 */
public class MedianOfRunningIntegerStream {

    public static void main(String[] args) {
        int[] arr ={12,31,3,56,8,4,2,58};
        printRunningMedian(arr);
    }

    private static void printRunningMedian(int[] arr) {
        Queue<Integer> minHeap = new PriorityQueue();
        Queue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
        maxHeap.add(arr[0]);
        int currentMid = arr[0];
        System.out.println(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(currentMid<=arr[i])
                addTo(minHeap,maxHeap,arr[i]);
            else
                addTo(maxHeap,minHeap,arr[i]);
            if(minHeap.size() == maxHeap.size())
                System.out.println(currentMid = (minHeap.peek()+maxHeap.peek())/2);
            else if(minHeap.size()>maxHeap.size())
                System.out.println(currentMid = minHeap.peek());
            else
                System.out.println(currentMid = maxHeap.peek());
        }
    }

    private static void addTo(Queue<Integer> toHeap, Queue<Integer> fromHeap, int input) {
        if(toHeap.size()<fromHeap.size()+1)
            toHeap.add(input);
        else {
            while (toHeap.size()>=fromHeap.size()+1){
                fromHeap.add(toHeap.poll());
            }
            toHeap.add(input);
        }
    }
}