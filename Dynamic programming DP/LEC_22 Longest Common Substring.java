Question link: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#
class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int t[][] = new int[n+1][m+1];
        
        int ans = 0;
        for(int i = 1; i<n+1; i++)
        {
            for(int j = 1; j<m+1; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                    ans = Math.max(ans, t[i][j]);
                    
                }
                else{
                    t[i][j] = 0;
                }
            }
        }
        
        return ans;
    }
}
