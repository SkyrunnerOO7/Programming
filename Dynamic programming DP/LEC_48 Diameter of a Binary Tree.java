LEETCODE QUESTION LINK : https://leetcode.com/problems/diameter-of-binary-tree/
GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

class Solution {
    
    int res = Integer.MIN_VALUE;
    int solve(TreeNode root)
    {
        //BASE CASE
        if(root == null){return 0;}
        
        //HYPOTHESIS
        //LEFT AND RIGHT TRAVERSAL
        int l = solve(root.left);
        int r = solve(root.right);
        
        //INDUCTION
        int temp = Math.max(l, r)+1;
        int ans = Math.max(temp, l+r+1);
        
        res = Math.max(res, ans);
        
        return temp;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        solve(root);
        return res-1;
    }
}
