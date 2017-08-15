/**
 Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
 1. The amount of petrol that every petrol pump has.
 2. Distance from that petrol pump to the next petrol pump.
 Calculate the first point from where a truck will be able to complete the circle
 (The truck will stop at each petrol pump and it has infinite capacity).
 Expected time complexity is O(n).
 Assume for 1 litre petrol, the truck can go 1 unit of distance.
*
 * input = {4,6},{6,5},{7,3},{4,5}
 * o/p : 1(index of petrol pump to start with)
 *
 * */
public class Test {
    public static void main(String[] args) {
        int[][] petrolArr = {{6,5},
                        {4,6},
                        {7,3},
                        {4,5}};
        int answer = getIndexOfpetrolPump(petrolArr);
        System.out.println(answer);
    }

    private static int getIndexOfpetrolPump(int[][] petrolArr) {
        int start = 0;
        int end = petrolArr.length-1;
        int currPetrol = 0;
        int index= 0;
        int count = 0;
        while(count<petrolArr.length){
            System.out.println("counting ");
            currPetrol = (currPetrol+petrolArr[index][0])-petrolArr[index][1];
            if(currPetrol<0){
                end = start;
                start = start+1;
                currPetrol = 0;
                index = start;
                count = 0;
            }
            else {
                index++;
                if(index == petrolArr.length)
                    index = 0;
                count++;
            }
        }

        return start;
    }

}
