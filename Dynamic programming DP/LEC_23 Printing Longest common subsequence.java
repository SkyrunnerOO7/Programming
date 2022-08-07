QUESTION LINK : https://techiedelight.com/practice/?problem=LongestCommonSubsequenceII
/*
Given two sequences, return all longest common subsequence (LCS) present in it. The LCS is the longest sequence which can be obtained from the first sequence by deleting some items and from the second sequence by deleting other items.

Input: X = "XMJYAUZ", Y = "MZJAWXU"
Output: "MJAU"

The longest common subsequence is not guaranteed to be unique. If multiple longest common subsequence exists, the solution should return any one of them.

Input: X = "ABCBDAB", Y = "BDCABA"
Output: "BDAB" or "BCAB" or "BCBA"

*/

class Solution
{
	public static String findLCS(String X, String Y)
	{
		// Write your code here...
		int n = X.length();
		int m = Y.length();
		
		int t[][] = new int[n+1][m+1];
		
		for(int i =1; i<n+1; i++)
		{
			for(int j =1; j<m+1; j++)
			{
				if(X.charAt(i-1) == Y.charAt(j-1))
				{
					t[i][j] = 1+t[i-1][j-1];
				}else{
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		
		int i = n;
		int j = m;
		ArrayList<String> list  = new ArrayList<>();
		
		while(i>0 && j > 0)
		{
				if(X.charAt(i-1) == Y.charAt(j-1))
				{
					list.add(String.valueOf(X.charAt(i-1)));
					i--;
					j--;
				}else{
					if(t[i][j-1] > t[i-1][j]){
					
						j--;
					}else{
						i--;
					}
				}
		}
		
		String ans = "";

        for(int l = list.size()-1; l>=0; l--)
        {
            ans += list.get(l);
        }
        return ans;
		
	}
}
