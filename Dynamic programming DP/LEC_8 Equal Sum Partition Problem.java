//QUESTION LINK : https://leetcode.com/problems/partition-equal-subset-sum/submissions/

class Solution {
    public boolean canPartition(int[] nums) {
        
        //FOR CHECKING IF THE SUM OF THE ARRAY IS 
        //ODD OR EVEN 
        int sum = 0;
        for(int i =0; i<nums.length; i++)
        {
            sum += nums[i];
        }
        
        //IF THE SUM IS ODD 
        //THE EQUAL PARTITON IS NOT POSSIBLE 
        //SO WE RETURN FALSE
        if(sum%2 != 0){ return false; }
        
         //IF THE SUM IF EVEN 
        
        //HERE WE GIVE THIS SUM HALF w TO
        //THE ---SUBSET SUM PROBLE--- AND TRY TO FIND SUBSET 
		//WITH THE SUM w
        int w = sum/2;
        int n = nums.length;
        
        //TOP DOWN APPROACH 
        boolean t[][] = new boolean[n+1][w+1];
        
        //INITILIZATION OF THE ARRAY
        for(int i=0; i<w+1; i++)
        {
            t[0][i] = false;
        }
        for(int i=0; i<n+1; i++)
        {
            t[i][0] = true;
        }
        
        //HERE WE ARE TAKING ONE ELEMENT OF THE ARRAY 
        //AND NOT TAKING THE ELEMENT AND STORING IT IN 2D ARRAY t[][]
        for(int i =1; i<n+1; i++)
        {
            for(int j = 1; j<w+1; j++)
            {
                //TWO CONDITIONS 
                //IF ELEMENT OF THE ARRAY IS SMALLER WE TRY TO ADD THAT
                //IF NOT SMALLER WE SKIP THAT ELEMENT
                if(nums[i-1] <= j)
                {
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j]; 
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][w];
        
    }
}
