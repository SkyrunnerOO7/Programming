QUESTION LINK :https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
STEPS-
    CALCULATE LCS OF TWO STRINGS X AND Y
    SUBTRACT THAT WITH LEN(X) AND LEN(Y)
          LEN(X) + LEN(Y) - LCS
class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int t[][] = new int[m+1][n+1];
        
        for(int i =0; i<=m; i++)
        {
            for(int j =0; j<=n; j++)
            {
                if(i==0||j==0)
                {
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i =1; i<=m; i++)
        {
            for(int j =1; j<=n; j++)
            {
                if(X.charAt(i-1) == Y.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int lcsLen = t[m][n];
        
        return m+n-lcsLen;
        
    }
}
