GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1

//  String s = "T OR F & T XOR F"
//            ( LEFT ) & ( RIGHT )

SETPS - 
  1/- IF LENGHT OF STR == 0 
        -RETURN 0
  
  2/- IF ONLY 1 ONE ELEMENT IS PRESENT
  ---------------FOR TRUE------------------------------------
        - IF isTrue == true (That mean we have to find true)
        - if s.charAt(i) == 'T'
              -- return 1
          else -- return 0
  ---------------FOR FALSE------------------------------------
       - IF isTrue == false (That mean we have to find false)
       - if s.charAt(i) == 'F'
              -- return 1
          else -- return 0
            
  3/- THEN FIND lT, lF, rT, rF 
         -true and false  FOR LEFT AND RIGHT PORTION
         
        //  String s = "T OR F & T XOR F"
        //            (T OR F) & (T XOR F)
        //               ^     ^        ^
        //               |     |        |
        //           k = i+1   k     k = j-1
        
  4/- IF THE MIDDLE PORTITION OR VALUE OF K IS 
         -EQUALS TO ORERATORS LIKE (AND-'&' , OR-'|', XOR-'^')
         -THEN CALCULATE ACCORDING TO THE RESPECTED OPERATOR'S TRUTH TABLE TO FIND true

class Solution{
    
    static int solve(String s, int i, int j, boolean isTrue)
    {
        //BASE CASE #1
        if(i>j){return 0;}
        
        //BASE CASE #2
        //IF ONLY ONLY ELEMNT IS PRESENT
        if(i==j)
        {
            if(isTrue)
            {
                if(s.charAt(i) == 'T'){return 1;}
                else{ return 0;}
            }else{
                if(s.charAt(i) == 'F'){return 1;}
                else{ return 0;}
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
        
        return ans;
    }
    
    
    static int countWays(int N, String S){
        // code here
        return solve(S, 0, N-1, true);
    }
}
