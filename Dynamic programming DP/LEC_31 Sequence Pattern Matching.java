QUESTION LINK: https://leetcode.com/problems/is-subsequence/submissions/

STEP - 
  1/- CALCULATE LCS B/W S1 AND S2
  2/- IF LCS ANSWER (t[n][m]) EQUALS TO LENGTH OF S1 
          -- RETURN TRUE
          -- ELSE FALSE
          
class Solution {
    public boolean isSubsequence(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        if(n == 0){return true;}
        
        int t[][] = new int[n+1][m+1];
        
        for(int i =1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else
                {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        
        if(n == t[n][m]){return true;}
        
        return false;
        
    }
}
