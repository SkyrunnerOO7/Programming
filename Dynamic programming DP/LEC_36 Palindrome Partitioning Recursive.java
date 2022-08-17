GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1

STEPS -
    1/- BASE CASE
            -- IF len(str) IS 0, 1 OR str ISPALINDROME 
                      ---RETURN 0
    2/- CALCULATE CALL SOLVE Fxn FOR
        int temp = 1 + solve(str, i, k) + solve(str, k+1, j);
            -- i TO k
            -- k+1 TO j
            -- ADD 1
    3/- STORE THAT MIN VALUE IN mn 
          mn = Math.min(mn, temp);

class Solution{
    
    static int solve(String str, int i, int j)
    {
        //BASE CASE
        if(i>=j){return 0;}
        if(isPalindrom(str, i, j)){return 0;}
        
        int mn = Integer.MAX_VALUE;
        
        for(int k = i; k<=j-1; k++)
        {
            int temp = 1 + solve(str, i, k) + solve(str, k+1, j);
            
            mn = Math.min(mn, temp);
        }
        
        return mn;
    }
    
    static int palindromicPartition(String str)
    {
        // code here
        return solve(str, 0, str.length()-1);
        
    }
    
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
