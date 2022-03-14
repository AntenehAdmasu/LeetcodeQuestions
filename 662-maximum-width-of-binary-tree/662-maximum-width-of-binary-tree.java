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
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> widthMin = new HashMap<>();
        HashMap<Integer, Integer> widthMax = new HashMap<>();

        findWidth(root, widthMin, widthMax, 1, 1);
        int maxWidth = 1;
        for(int level: widthMin.keySet()){
            maxWidth = Math.max(Math.abs(widthMax.get(level) - widthMin.get(level)) + 1, maxWidth);
        }
        return maxWidth;
    }
    
    public void findWidth(TreeNode node, HashMap<Integer,Integer> widthMin, HashMap<Integer,Integer> widthMax,int level, int xpos){
        if(node == null){
            return;
        }
        if(!widthMin.containsKey(level)){
            widthMin.put(level, xpos);
        }
        widthMax.put(level, xpos);

        findWidth(node.left, widthMin, widthMax, level + 1, (xpos * 2) - 1);
        findWidth(node.right, widthMin, widthMax, level + 1, (xpos * 2));
        
    }
    
}