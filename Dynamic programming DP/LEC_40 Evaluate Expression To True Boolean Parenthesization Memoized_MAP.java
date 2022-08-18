class Solution{

    Map<String, Integer> map = new HashMap<>();

    int solve(String s, int i, int j, boolean isTrue)
    {

        //BASE CASE #1
        if(i>j){return 0;}

        String key = String.valueOf(i)+" "+
                String.valueOf(j)+" "+
                String.valueOf(isTrue);


        if(map.containsKey(key)){return map.get(key);}

        //BASE CASE #2
        //IF ONLY ONLY ELEMNT IS PRESENT
        if(i==j)
        {
            if(isTrue)
            {
                if(s.charAt(i) == 'T'){map.put(key, 1%1003); return 1;}
                else{map.put(key, 0%1003); return 0;}
            }else{
                if(s.charAt(i) == 'F'){map.put(key, 1%1003); return 1;}
                else{map.put(key, 0%1003); return 0;}
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


        map.put(key, ans%1003);

        return ans%1003;
    }


    int countWays(int N, String S){

        // code here
        return solve(S, 0, N-1, true);
    }
}

public class Main
{


    public static void main (String[] args)
    {
        Solution s = new Solution();

        int n = 35;
        String str = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";

        s.countWays(n, str);

        int j = 0;


    }
}
