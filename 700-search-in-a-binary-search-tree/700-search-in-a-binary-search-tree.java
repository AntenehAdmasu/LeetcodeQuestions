/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode left = null;
        TreeNode right = null;
        if(root == null) return null;

        if(root.val == val){
            return root;
        }else if(root.val < val){
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}