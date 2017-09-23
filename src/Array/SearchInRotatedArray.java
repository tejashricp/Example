package Array;

/**
 * Created by TPathrikar on 9/15/2017.
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] input = {18,21,32,54,9,11,12};
        int[] input1 = {18,21,32,54,9,11,12,13,15};
        int[] input2 = {32,54,9,11,12,18,21,25};
        int[] input3 = {18,21,32,54,56,74,9,11,12};
        System.out.println(findPivot(input,0,input.length-1));
        System.out.println(findPivot(input1,0,input1.length-1));
        System.out.println(findPivot(input2,0,input2.length-1));
        System.out.println(findPivot(input3,0,input3.length-1));
    }

    private static int findPivot(int[] input, int start, int end) {
        if(start == end)
            return start;
        if (start>end)
            return -1;
        int mid = (start+end)/2;

        if(mid<end && input[mid]>input[mid+1])
            return input[mid];
        if(mid>start && input[mid]<input[mid-1])
            return input[mid-1];

        if(input[start]>input[mid])
            return findPivot(input,start,mid-1);
        return findPivot(input,mid+1,end);
    }
}
