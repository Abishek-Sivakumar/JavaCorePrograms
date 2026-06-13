import java.util.*;
public class DSAProblems {

    public static int findLongestCommonSubsequence(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String printLongestCommonSubsequence(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = m, j = n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        return ans.reverse().toString();
    }

    public static void findLongestCommonSubstring(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        int maxLength = 0;
        int endIndex = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    // For only the length just update the maxlength and print it like
                    // maxLength = Math.max(maxLength, dp[i][j]);
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        String ans = s1.substring(endIndex-maxLength, endIndex);
        System.out.println("Common Substring is : " + ans);
        System.out.println("Length is : " + maxLength);
    }

    public static void main(String args[]){
        System.out.println(findLongestCommonSubsequence("abcd", "afgbjhc"));
        System.out.println(printLongestCommonSubsequence("abcd", "afgbjhc"));
        findLongestCommonSubstring("abcdef", "jbcdkl");
    }
}
