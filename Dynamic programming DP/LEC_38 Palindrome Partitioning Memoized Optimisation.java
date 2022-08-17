GFG: https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1


class Solution{
    //FOR STORING THE CALCULTED VALUESS
    static int t[][] = new int[501][501];
    
    static int solve(String str, int i, int j)
    {
        //BASE CASE
        if(i>=j){return 0;}
        if(isPalindrom(str, i, j)){return 0;}
        
        //IF ALREADY CALCULATED THEN RETURN THE VALUE
        if(t[i][j] != -1){return t[i][j];}
        
        int mn = Integer.MAX_VALUE;
        
        for(int k = i; k<=j-1; k++)
        {
            int A, B;
            
            //CHECKING IF solve(str, i, k) IS AREADY CALCULTED OR NOT
            if(t[i][k] != -1){ A = t[i][k];}
            else{ A = solve(str, i, k);}
            
            //CHECKING IF solve(str, k+1, J) IS AREADY CALCULTED OR NOT
            if(t[k+1][j] != -1){ B = t[k+1][j];}
            else{ B = solve(str, k+1, j);}
            
            int temp = 1 + A + B;
            
            mn = Math.min(mn, temp);
        }
        
        return t[i][j] = mn;
    }
    
    static int palindromicPartition(String str)
    {
        // code here
        
        for(int[] row: t)
        {
            Arrays.fill(row, -1);
        }
        return solve(str, 0, str.length()-1);
        
    }
    
    //CHECKING IF THE GIVEN STRING IS PALINDROME OR NOT
    static boolean isPalindrom(String str, int i, int j)
    {
        while(i<=j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}
