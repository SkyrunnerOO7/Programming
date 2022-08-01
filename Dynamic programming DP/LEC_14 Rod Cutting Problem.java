QUESTION LINK : https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        
        int w = price.length;
        int wt[] = new int[w];
        for(int i =0; i<n; i++){wt[i] = i+1;}
        int t[][] = new int[n+1][w+1];
        
        for(int i = 0; i<w+1; i++){ t[i][0] = 0;}
        for(int i = 0; i<n+1; i++){ t[0][i] = 0;}
        
        for(int i =1; i<n+1; i++)
        {
            for(int j=1; j<w+1; j++)
            {
                if(wt[i-1] <= j)
                {
                    t[i][j] = Math.max(price[i-1]+t[i][j-wt[i-1]],
                                        t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][w];
    }
}
