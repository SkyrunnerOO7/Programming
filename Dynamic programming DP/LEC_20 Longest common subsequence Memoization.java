QUESTION LINK:https://leetcode.com/problems/longest-common-subsequence/
  class Solution {
    
    //FOR MEMOIZATION 
    static int t[][] = new int[1001][1001];
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        //FILLING THE t[][] WITH -1
        for(int[] row: t)
        { Arrays.fill(row, -1);}
        
        
        return lcs(text1, text2, text1.length(), text2.length());
    }
    
    
    public int lcs(String str1, String str2, int m, int n)
    {
        //BASE CASE
        if(m == 0 || n == 0)
        {
            return 0;
        }
        
        //IF THE VALUE IS ALREADY CALCULATED AND PRESENT IN THE t[][]
        //RETURN THAT VALUE 
        if(t[m][n] != -1){ return t[m][n];}
        
        //IF BOTH THE CHAR IS SAME N-1 & M-1
        //AND STORE THAT IN t[][]
        else if(str1.charAt(m-1) == str2.charAt(n-1))
        {
            return t[m][n] = 1+lcs(str1, str2, m-1, n-1);
        }else{
            //IF CHAR DO NO MATCH ME GO TWO WAYS 
            //          abcd   ac
            //             /   \
            //        abc ac   abcd a
            //AND STORE THAT IN t[][]
            return t[m][n] = Integer.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
        }
    }
}
