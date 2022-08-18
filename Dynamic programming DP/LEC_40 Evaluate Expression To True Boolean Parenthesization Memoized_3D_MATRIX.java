GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1

class Solution{
    
    static int t[][][] = new int[2][201][201];
    
    static int solve(String s, int i, int j, boolean isTrue)
    {
        int b = 0;
        if(isTrue){b = 1;}
        
        //BASE CASE #1
        if(i>j){return 0;}
        
        if(t[b][i][j] != -1){return t[b][i][j];}
        
        //BASE CASE #2
        //IF ONLY ONLY ELEMNT IS PRESENT
        if(i==j)
        {
            if(isTrue)
            {
                if(s.charAt(i) == 'T'){ return t[b][i][j] = 1;}
                else{ return t[b][i][j] = 0;}
            }else{
                if(s.charAt(i) == 'F'){return t[b][i][j] = 1;}
                else{ return t[b][i][j] = 0;}
            }
        }
        
        
        //FOR STORING THE ANSWER
        int ans = 0;

        //  String s = "T OR F & T XOR F"
        //            (T OR F) & (T XOR F)
        //               ^     ^        ^
        //               |     |        |
        //           k = i+1   k     k = j-1
        
        for(int k = i+1; k<= j-1; k = k+2)
        {
             //  String s = "T OR F & T XOR F"
            //             ( LEFT ) & ( RIGHT )
            //FOR LEFT
            int lT = solve(s, i, k-1, true);
            int lF = solve(s, i, k-1, false);
            //FOR RIGHT
            int rT = solve(s, k+1, j, true);
            int rF = solve(s, k+1, j, false);
            
            //FOR OPERATORS LIKE AND | OR | XOR 
            //FOR AND '&'
            if(s.charAt(k) == '&')
            {
                if(isTrue == true)
                {
                    ans += lT*rT; 
                }else
                {
                    ans += lF*rT
                          +lT*rF
                          +lF*rF;
                }
            }
            //FOR OR '|'
            else if(s.charAt(k) == '|')
            {
                if(isTrue == true)
                {
                    ans += lT*rT
                          +lT*rF
                          +lF*rT;
                }else
                {
                    ans += lF*rF;
                }
            }
            //FOR XOR '^'
            else if(s.charAt(k) == '^')
            {
                if(isTrue == true)
                {
                    ans += lT*rF
                          +lF*rT;
                }else
                {
                    ans += lT*rT
                          +lF*rF;
                }
            }
        }
        
        
        return t[b][i][j] = ans%1003;
    }
    
    
    static int countWays(int N, String S){
        
        // code here
        for (int[][] row : t) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }
        
        return solve(S, 0, N-1, true);
    }
}
