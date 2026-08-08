/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int len=0;
    public int longestUnivaluePath(TreeNode root) {
        solve(root);
        return len;
    }
    public int solve(TreeNode root)
    {
        if(root==null) return 0;
        
         int lh=solve(root.left);
        int rh=solve(root.right);
        if (root.left==null||root.left.val!=root.val) {
            lh = 0;
        }

        if (root.right == null||root.right.val != root.val) {
            rh = 0;
        }
        len=Math.max(len,lh+rh);
           
        

        return 1+Math.max(lh,rh);
        
    }

}