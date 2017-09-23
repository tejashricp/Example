package String;

/**
 * Created by TPathrikar on 9/12/2017.
 */
public class KMPSearch {

    public static void main(String[] args) {
        String text = "ababcxabcabcabyababcaby";
        String pat = "abcaby";
        int[] temp = preprocess(pat);
        printMatchingIndex(text,pat,temp);
    }

    private static void printMatchingIndex(String text, String pat, int[] temp) {
        int i = 0,j=0,index=-1;
        while (i<text.length()){
            if(text.charAt(i) == pat.charAt(j)){
                if(j == 0)
                    index = i;
                i++;
                j++;
            }
            else {
                if(j == 0)
                    i++;
                else {
                    index = i-temp[j-1];
                    j = temp[j - 1];
                }
            }
            if(j == temp.length) {
                System.out.println("matched "+index);
                j = temp[temp.length-1];
            }
        }
    }

    private static int[] preprocess(String pat) {
        int i = 0,j = 1,val = 0;
        int[] temp = new int[pat.length()];
        while (j<pat.length()){
            if(pat.charAt(i) == pat.charAt(j)){
                temp[j] =  val+1;
                val = val+1;
                i++;
                j++;
            }
            else {
                if(j == 0)
                    i = temp[j-1];
                else {
                    val = 0;
                    temp[j] = 0;
                    j++;
                }
            }
        }
        return temp;
    }

}
