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
    ArrayList<String> res= new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return res;
        solve(root,"");
        return res;
        
    }
     public void solve(TreeNode root, String path) {
        if(root==null) return;
        if(path.isEmpty()){
            path=String.valueOf(root.val);
        }
        else{
            path=path+"->"+root.val;
        }
        if(root.left==null&&root.right==null)  res.add(path);
       
        solve(root.left,path);
        solve(root.right,path);

       
    }
}