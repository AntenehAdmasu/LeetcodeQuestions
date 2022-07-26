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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        if(root.val == p.val || root.val == q.val) return root;
        TreeNode leftResult = lowestCommonAncestor(leftNode, p,q);
        TreeNode rightResult = lowestCommonAncestor(rightNode, p,q);

        if (leftResult == null){
            return rightResult;            
        } 
        if(rightResult == null){
            return leftResult;
        }
        
        return root;

    }
}