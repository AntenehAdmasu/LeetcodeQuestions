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

        if(root.val == val) return root;

        if(root.left != null){
            left = searchBST(root.left, val);
        }

        if(root.right != null){
            right = searchBST(root.right, val);
        }

        if(left != null) return left;
        if (right != null) return right;
        return null;

    }
}