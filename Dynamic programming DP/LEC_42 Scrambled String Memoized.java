LEETCODE QUESTION LINK : https://leetcode.com/problems/scramble-string/submissions/

class Solution {
    
    //FOR STORING THE VALUE 
    Map<String, Boolean> map = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        
         String key = s1+" "+s2;
        
        //IF VALUE ALREADY PRESENT THEN RETURN VALUE
        if(map.containsKey(key)){return map.get(key);}
        
        //BASECASE
        if(s1.equals(s2)){return true;}
        if(s1.length() <= 1){return false;}
        
        int n = s1.length();
        
        //        s1     s2
        //      great   eatgr
        
        //CONDITION #1           CHECKS
        //      gr|eat  eat|gr    AND   gr|eat  eat|gr
        //      |___________|               |____|
        
        //CONDITION #2          CHECK
        //      gr|eat  eat|gr    AND   gr|eat  eat|gr
        //      |________|                  |____|
        
        //IF(CONDITON#1 OR CONDITON#2){RETURN TRUE;}
        
        for(int i = 1; i<= n-1; i++)   
        { 
            //IF(CONDITON#1 || CONDITON#2){RETURN TRUE;}
            if( (isScramble(s1.substring(0,i), s2.substring(n-i,n)) && isScramble(s1.substring(i,n), s2.substring(0,n-i)))
                                      ||
                (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i,n), s2.substring(i,n)))
               )
            { 
                map.put(key, true);
                return true;
            }
        }
        
        map.put(key, false);
        return false;
    }
