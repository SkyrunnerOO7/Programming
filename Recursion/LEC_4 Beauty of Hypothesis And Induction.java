QUESTION LINK : https://techiedelight.com/practice/?problem=Factorial

/*

Given a non-negative number n, return its factorial n! which is the product of all positive integers less than or equal to n.

Input: n = 5
Output: 120
Explanation: The value of 5! is 120 as 5! = 1 × 2 × 3 × 4 × 5 = 120

Input: n = 0
Output: 1
Explanation: The value of 0! is 1

Constraints: 0 <= n <= 20

*/

class Solution
{
	public static long factorial(int n)
	{
		// Write your code here...
		
		if(n == 0){return 1;}
		
		
		return n*factorial(n-1);
		
	}
}


