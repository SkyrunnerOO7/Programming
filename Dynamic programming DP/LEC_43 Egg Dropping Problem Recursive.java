LEETCODE QUESTION LINK : https://leetcode.com/problems/super-egg-drop/
GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1

class Solution {
    public int superEggDrop(int e, int f) {
        
        if(f == 0 || f == 1){return f;}
        if(e == 1){return f;}
        
        int mn = Integer.MAX_VALUE;
        
        for(int k = 1; k <= f; k++)
        {
            int temp = 1+Math.max(superEggDrop(e-1, k-1), superEggDrop(e, f-k));
            
            mn = Math.min(mn, temp);        
        }
        
        return mn;
    }
    
}
