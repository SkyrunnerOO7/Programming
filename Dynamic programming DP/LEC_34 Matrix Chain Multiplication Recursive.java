GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1



class Solution{
    
    static int solve(int arr[], int i, int j)
    {
        if(i>=j)
        {
            return 0;
        }
        
        int mn = Integer.MAX_VALUE;
        
        for(int k = i; k<j; k++)
        {
            int temp = solve(arr, i, k)+
                       solve(arr, k+1, j)+
                       (arr[i-1]*arr[k]*arr[j]);
                       
            mn = Math.min(temp, mn);
        }
        
        return mn;
    }
    
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        return solve(arr, 1, N-1);
    }
}
