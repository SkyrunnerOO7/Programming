QUESTION LINK : https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
class Solution{

	public int minCoins(int coin[], int n, int w) 
	{ 
	    // Your code goes here
	    int t[][] = new int[n+1][w+1];
	    
	    //INTILIZATION OF 0th ROW AND 0TH COLOUM WITH 0 AND INT_MAX-1
	    //INITILIZING Ist ROW WITH 
	    //1# IF COMPLETELY DIVISIBLE THE DIVISOR
	    //   2%2 = 0 WE WRITE 2/2 = 1
	    //2# IF NOT DIVISIBLE 
	    //   2%3 = 3 WE WRITE INT_MAX-1
	    for(int i =0; i<n+1; i++){
	        for(int j = 0; j<w+1; j++)
	        {
	            //0th row and 0th col initilization 
	            if(j == 0){t[i][j] = 0;}
	            if(i == 0){t[i][j] = Integer.MAX_VALUE-1;}
	            
	            //1st ROW INITILIZTION
	            if(i == 1 && j>0)
	            {
	                if(j%coin[0] == 0)
	                {
	                    t[i][j] = j/coin[0];
	                }else{
	                    t[i][j] = Integer.MAX_VALUE-1;
	                }
	            }
	        }
	    }
	    
	    
	    
	    for(int i =2; i<n+1; i++)
	    {
	        for(int j = 1; j<w+1; j++)
	        {
	            if(coin[i-1] <= j)
	            {
	                t[i][j] = Math.min(1+t[i][j-coin[i-1]],
	                                   t[i-1][j]);
	            }else
	            {
	                t[i][j] = t[i-1][j];
	                
	            }
	        }
	    }
	    
	    
	    if(t[n][w]==Integer.MAX_VALUE-1){return -1;}
	    return t[n][w];
	    
	} 
}
