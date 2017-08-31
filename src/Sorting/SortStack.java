package Sorting;

import java.util.Stack;

/**
 * Created by TPathrikar on 8/31/2017.
 */
public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        int[] ints = {34,3,31,98,92,23};
        for(int i=0;i<ints.length;i++){
            integerStack.push(ints[i]);
        }
        Stack<Integer> tempStack = sortStack(integerStack);
        while (!tempStack.isEmpty()){
            System.out.print(tempStack.pop()+" ");
        }
    }

    private static Stack<Integer> sortStack(Stack<Integer> integerStack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!integerStack.isEmpty()){
            int temp = integerStack.pop();
            if(tempStack.isEmpty())
                tempStack.push(temp);
            else {
                    while (!tempStack.isEmpty() && temp<tempStack.peek()){
                        integerStack.push(tempStack.pop());
                    }
                    tempStack.push(temp);
            }
        }
        return tempStack;
    }
}
