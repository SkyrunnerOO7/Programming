//QUESTION LINK : https://leetcode.com/problems/target-sum/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for(int x : nums){sum += x;}
        
        //CALCULATE THE VALUE OF w WITH THIS
        int w = (target+sum)/2;
        int n = nums.length;
        
        //correction 
        if(sum < target || (sum + target) % 2 != 0){return 0;}
        w= Math.abs(w);
        //==============
        
        //USE COUNT THE NUMBER OF SUBSET WITH THE GIVEN DIFFERENCE == w
        int t[][] = new int[n+1][w+1];
        
        for(int i =0; i<w+1; i++){t[0][i] = 0;}
        for(int i =0; i<n+1; i++){t[i][0] = 1;}
        
        for(int i= 1; i<n+1; i++)
        {
            for(int j = 0; j<w+1; j++)
            {
                if(nums[i-1] <= j)
                {
                    t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
                }else
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][w];
    }
}
