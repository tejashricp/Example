
/**
 Given a string that has set of words and spaces,
 write a program to move all spaces to front of string,
 by traversing the string only once. 
 this is tejashri cp
    thisistejashricp
 */
public class Test{

    public static void main(String[] args) {
        String input = "this is tejashri cp";
        changeString(input);
    }

    private static void changeString(String input) {
        char[] arr = input.toCharArray();
        int i=arr.length-1,j=arr.length-1;
        for(;i>=0&&j>=0;){
            arr[i] = arr[j];
            if(arr[j] == ' ')
                j--;
            else {
                i--;
                j--;
            }
        }
        while (i>=0){
            arr[i] = ' ';
            i--;
        }
        printArr(arr);
    }

    private static void printArr(char[] arr) {
        for (Character c:arr){
            System.out.print(c);
    }


}


}
