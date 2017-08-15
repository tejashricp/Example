/*
* LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
* */
public class Demo {

    public static void main(String[] args){
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        int out = solutionByRecursion(str1,str2,str1.length(),str2.length());
        System.out.println(out);
        out = solutionByDP(str1,str2);
        System.out.println(out);

    }

    private static int solutionByDP(String str1, String str2) {
        int[][] solnArr = new int[str2.length()+1][str1.length()+1];
        for(int i=1;i<=str2.length();i++){
            for(int j=1;j<=str1.length();j++){
                if(str2.charAt(i-1) == str1.charAt(j-1))
                    solnArr[i][j] = solnArr[i-1][j-1]+1;
                else
                    solnArr[i][j] = Math.max(solnArr[i-1][j],solnArr[i][j-1]);
            }
        }
        return solnArr[str2.length()][str1.length()];
    }

    private static int solutionByRecursion(String str1, String str2, int m, int n) {
        if(m == 0 || n==0)
            return 0;
        if(str1.charAt(m-1) == str2.charAt(n-1))
            return 1 + solutionByRecursion(str1, str2, m - 1, n - 1);
        else
            return Math.max(solutionByRecursion(str1,str2,m,n-1),
                    solutionByRecursion(str1,str2,m-1,n));
    }
}
