GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

class Solution{
    
    //GLOBAL ARRAY
    static int t[][] =new int[501][501];
    
    static int solve(int arr[], int i, int j)
    {
        //FOR INDEX OUT OF BOUND
        if(i>=j){ return t[i][j] = 0; }
        
        //IF VALUE IS ALLREADY CALCULTED THE RETURN THAT VAL
        if(t[i][j] != -1){ return t[i][j];}
        
        int mn = Integer.MAX_VALUE;
        
        for(int k = i; k<j; k++)
        {
            int temp = solve(arr, i, k)+
                       solve(arr, k+1, j)+
                       (arr[i-1]*arr[k]*arr[j]);
                       
            mn = Math.min(temp, mn);
        }
        
        return t[i][j] = mn;
    }
    
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        //INITILIZATION WITH -1 
        for(int[] row : t)
        {
            Arrays.fill(row, -1);
        }
        
        return solve(arr, 1, N-1);
    }
}
