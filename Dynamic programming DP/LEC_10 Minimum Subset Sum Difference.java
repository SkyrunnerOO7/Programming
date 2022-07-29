//Question link : https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1
class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
      //STEP 1: CACLULATE THE SUM OF THE ARRAY
      //THEN GIVE THE SUM AS RANGE/W TO THE SUBSET SUM
	    int sum = 0;
	    for(int i =0; i<n; i++){sum += arr[i];}
	    int w = sum;
    
      //==========================SUBSET SUM PART===========================================
	    boolean t[][] = new boolean[n+1][sum+1];
	    for(int i =0; i<w+1; i++){t[0][i] = false;}
	    for(int i =0; i<n+1; i++){t[i][0] = true;}
	    
	    for(int i =1; i<n+1; i++){
	        for(int j =1; j<w+1; j++)
	        {
	            if(arr[i-1] <= j)
	            {
	                t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
	            }else{
	                t[i][j] = t[i-1][j];
	            }
	        }
	    }
	    //=====================================================================
	  
      //SETP 2: TAKE HALF ELEMENTS OF LAST ROW OF T[][] 2D ARRAY
      ArrayList<Integer> list = new ArrayList<>();
	    for(int i =0; i<=sum/2; i++)
	    {
	        if(t[n][i])
	        {
	            list.add(i);
	        }
	    }
	    
      //STEP 3: CLCULATE THE MIN BY (SUM - 2*(LIST.GET(I))
	    int min = Integer.MAX_VALUE;
	    for(int i =0; i<list.size(); i++)
	    {
	        min = Math.min(min, sum- (2*list.get(i)));
	    }
	    
	    return min;
	    
	} 
}
