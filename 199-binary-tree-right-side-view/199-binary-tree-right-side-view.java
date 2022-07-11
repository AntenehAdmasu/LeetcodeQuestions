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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        traverse(root, answer, 1);
        return answer;
        
    }
    public void traverse(TreeNode node, List<Integer> result, int level){
        if(node == null){
            return;
        }

        if(result.size() < level){
            result.add(node.val);
        }else{
            result.set(level - 1, node.val);
        }
        traverse(node.left, result, level + 1);
        traverse(node.right, result, level + 1);
        
    }
}

