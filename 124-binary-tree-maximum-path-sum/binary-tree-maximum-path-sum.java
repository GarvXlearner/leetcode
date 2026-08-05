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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxsum;
        
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        int l=Math.max(0,solve(root.left));
        int r=Math.max(0,solve(root.right));
        int currsum=l+r+root.val;
        maxsum=Math.max(maxsum,currsum);
        return root.val+Math.max(r,l);
    }
}