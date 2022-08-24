GFG QUSETION LINK : https://practice.geeksforgeeks.org/problems/print-1-to-n-without-using-loops3621/1

class Solution{
    static void printTillN(int N){
        // code here
        if(N == 1)
        {
            System.out.print(1+" ");
            return;
        }
        
        printTillN(N-1);
        System.out.print(N+" ");
    }
}
