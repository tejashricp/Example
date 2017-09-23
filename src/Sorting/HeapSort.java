package Sorting;

import java.util.PriorityQueue;

/**
 * Created by tpathrikar on 9/23/2017.
 */

/*
*                      0
*                 /       \
*                1         2
*             /   \       / \
*            3     4     5   6
*           / \   / \    /
*          7   8 9   10 11
* *
*                   12
*                 /    \
*                11      13
*               /  \     /
*              5    16  7
*
* */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 16, 7};
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        for(int i=(arr.length/2)-1;i>=0;i--){
            heapify(arr,i,arr.length);
        }

        for(int i=arr.length-1;i>=0;i--){
            System.out.println(arr[0]);
            swap(arr,0,i);
            heapify(arr,0,i);
        }

    }

    private static void heapify(int[] arr, int i,int size) {
        int left  = (i*2)+1;
        int right = (i*2)+2;
        int largest = i;
        if(left<size && arr[left]>arr[i])
            largest = left;
        if(right<size && arr[largest]<arr[right])
            largest = right;
        if(largest != i) {
            swap(arr, largest, i);
            heapify(arr,largest,size);
        }
    }

    private static void swap(int[] arr, int largest, int i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}