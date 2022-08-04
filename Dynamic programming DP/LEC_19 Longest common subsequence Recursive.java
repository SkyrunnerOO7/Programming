class Solution {
    
    public int lcs(String str1, String str2, int m, int n)
    {
        if(m == 0 || n == 0)
        {
            return 0;
        }
        
        else if(str1.charAt(m-1) == str2.charAt(n-1))
        {
            return 1+lcs(str1, str2, m-1, n-1);
        }else{
            return Integer.max(lcs(str1, str2, m-1, n), lcs(str1, str2, m, n-1));
        }
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
            
        return lcs(text1, text2, text1.length(), text2.length());
    }
}
