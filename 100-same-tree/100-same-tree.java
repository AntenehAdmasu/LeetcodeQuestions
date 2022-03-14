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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null & q == null) return true;

        // If one subtree and the other isn't or if the values at the nodes are different
        if((p == null & q != null) || (p != null & q == null) || p.val != q.val) return false;
        
        boolean leftSide = isSameTree(p.left,q.left);
        // No need to call the right subtree if the left is not the same
        if(!leftSide){
            return false;
        }
        boolean rightSide = isSameTree(p.right, q.right);

        return leftSide && rightSide;

    }
}