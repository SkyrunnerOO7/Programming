LEETCODE QUESTION LINK : https://leetcode.com/problems/binary-tree-maximum-path-sum/
GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1

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
        //CALCULATES FOR THE OUTER PATH
        int temp = Math.max(Math.max(l,r)+root.val, root.val);
        int ans = Math.max(temp, l+r+root.val); // CAL FOR INNER PATH
        
        res = Math.max(res, ans);
        
        return temp;
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        
        return res;
    }
}
