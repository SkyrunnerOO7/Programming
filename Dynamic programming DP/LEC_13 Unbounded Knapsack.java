QUESTION LINK : https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
class Solution{
    static int knapSack(int n, int w, int val[], int wt[])
    {
        // your code here
        int t[][] = new int[n+1][w+1];

        //initilizing the 0th indexes
        for(int i =0; i<w+1; i++){t[0][i] = 0;}
	    for(int i =0; i<n+1; i++){t[i][0] = 0;}

        for(int i =1; i<n+1; i++)
        {
            for(int j = 1; j<w+1; j++)
            {
                if(wt[i-1] <= j)
                {
                    t[i][j] = Math.max(val[i-1]+t[i][j-wt[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][w];
    }
}
