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

    public static void findLongestSubstringWithDistinctCharacter(String s){
        int n = s.length();
        int len = 0;
        int maxLen = 0;
        int l = 0, r = 0;
        int hash[] = new int[256];
        Arrays.fill(hash, -1);
        int startIndex = 0;
        while(r<n){
            char c = s.charAt(r);
            if(hash[c]!=-1 && hash[c]>=l){
                l = hash[c]+1;
            }
            len = r-l+1;
//            maxLen = Math.max(len, maxLen);
            if(len > maxLen){
                maxLen = len;
                startIndex = l;
            }
            hash[c] = r;
            r++;
        }
        String ans = s.substring(startIndex, startIndex+maxLen);
        System.out.println("The substring with distinct characters is " + ans);
        System.out.println("The length of substring with distinct characters is : " + maxLen);
    }

    //Leetcode Word Break 1
    public static boolean wordBreak(String s, String[] dict){
        Set<String> set = new HashSet<>(Arrays.asList(dict));
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        //VERY IMPORTANT STEP
        dp[0] = true;
        //ALSO i MUST Run Till equal to n
        for(int i = 1; i<=n; i++){
            for(int j=0;j<i;j++){
                String temp = s.substring(j, i);
                if(dp[j] && set.contains(temp)){
                    dp[i] = true;
                }
            }
        }
        //THE last value gives the answer whether we can break or not
        return dp[n];
    }

    //Leetcode Word Break 2
    public static List<String> formSentence(String s, String[] dict ){
        Set<String> set = new HashSet<>(Arrays.asList(dict));
        int n = s.length();
        List<String>[] dp = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add("");
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String temp = s.substring(j, i);
                if(dp[j].size() > 0 && set.contains(temp)){
                    for(String sentence : dp[j]){
                        if(sentence.isEmpty()){
                            dp[i].add(temp);
                        }else{
                            dp[i].add(sentence + " " + temp);
                        }
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String args[]){
//        System.out.println(findLongestCommonSubsequence("abcd", "afgbjhc"));
//        System.out.println(printLongestCommonSubsequence("abcd", "afgbjhc"));
//        findLongestCommonSubstring("abcdef", "jbcdkl");
        findLongestSubstringWithDistinctCharacter("abcabcbb");
    }
}
