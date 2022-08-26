LEETCODE QUESTION LINK : https://leetcode.com/problems/maximum-depth-of-binary-tree/
GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/height-of-binary-tree/0

class Solution {
    
    //RECURSIVE APPROCHE
    public int maxDepth(TreeNode root) {
        
        //RETURN 0 IF THE NODE IS NULL
        if(root == null){return 0;} 
        
        //GIVE THE HIGHT/DEFTH OF THE LEFT AND RIGHT SUB TREE
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        
        //FINDING THE MAX DEPTH OF SUB TREES OF THE MAIN TREE
        //AND ADDING 1 TO IT
        return 1+Math.max(l,r);
        
    }
}
