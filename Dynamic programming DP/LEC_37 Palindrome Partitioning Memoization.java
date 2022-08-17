GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1

STEPS -
    1/- CREAT A GLOBAL 2D ARRAY T[][] OF THE SIZE OF THE MAX CONSTRANINTS
            --FILL IT WITH -1
    2/- BASE CASE
            -- IF len(str) IS 0, 1 OR str ISPALINDROME 
                      ---RETURN 0
    3/- IF THE CALCULTED VALUE IS ALREADY CALCULTED AND PRESENT IN THE T[][] ARRARY
            -- RETURN THAT T[i][j]
    4/- CALCULATE CALL SOLVE Fxn FOR
        int temp = 1 + solve(str, i, k) + solve(str, k+1, j);
            -- i TO k
            -- k+1 TO j
            -- ADD 1
    5/- STORE THAT MIN VALUE IN mn 
          mn = Math.min(mn, temp);
    6/- RETURN T[i][j] = mn
           
           
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
            int temp = 1 + solve(str, i, k) + solve(str, k+1, j);
            
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
