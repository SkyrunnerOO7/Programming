QUESTION LINK: https://leetcode.com/problems/longest-common-subsequence/
class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        //LENGTH OF THE STRINGS 
        int m = text1.length();
        int n = text2.length();
        
        //TOP DOWN
        int t[][] =new int [m+1][n+1];
        
        //INITIALIZING THE 0th ROW AND 0TH COL
        for(int i =0; i<m+1; i++){t[i][0] = 0;}
        for(int i =0; i<n+1; i++){t[0][i] = 0;}
        
        for(int i =1 ; i<m+1; i++)
        {
            for(int j = 1; j<n+1; j++)
            {   
                //IF BOTH THE CHAR MATCHES THEN WE ADD 1 TO INDEX i,j
                /AND STORE THAT IN t[][]
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }
                else{
                    //IF THE CHAR DON'T MATCHES THEN WE CALCULATE THE MAX 
                     //IF CHAR DO NO MATCH ME GO TWO WAYS 
                    //          abcd   ac
                    //             /   \
                    //        abc ac   abcd a
                    //AND STORE THAT IN t[][]
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
                    
            }
        }
        
        return t[m][n];
        
    }
}
