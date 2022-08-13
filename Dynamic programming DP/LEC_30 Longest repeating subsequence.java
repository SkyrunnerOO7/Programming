GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

 STEPS - 
   
        CALCULATE LCS OF THE STR WITH ITSELF STR
        BUT, WITH A SLIGHT CHANGE IN THE, IF CONDITION
        --JUST ADD (i !=j ) TO THE CONDITION
        
        
class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int n = str.length();
        int m = n;
        
        int t[][] = new int[n+1][m+1];
        
        for(int i =1; i<=n; i++)
        {
            for(int j = 1; j<= m; j++)
            {
                if(str.charAt(i-1) == str.charAt(j-1) && i != j )
                {
                    t[i][j] = 1+t[i-1][j-1];
                }else
                {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[n][m];
    }
}

