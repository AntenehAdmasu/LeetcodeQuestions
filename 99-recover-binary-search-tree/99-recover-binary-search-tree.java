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
class Solution{


    public static void recoverTree(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root, arr);
        TreeNode node1 = null;
        TreeNode node2 = null;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            int left = i - 1 >= 0 ? arr.get(i - 1).val : Integer.MIN_VALUE;
            int right = i + 1 < size ? arr.get(i + 1).val : Integer.MAX_VALUE;
            int current = arr.get(i).val;
            // First node
            if (current > left && current > right && left < right) {
                node1 = arr.get(i);
            } else if (current < left && current < right && left < right) {
                node2 = arr.get(i);
            }
        }
        if (node1 != null && node2 != null) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }
    
    
    public static void dfs(TreeNode node, ArrayList<TreeNode> arr) {
        if (node == null){
            return;
        }
        dfs(node.left, arr);
        arr.add(node);
        dfs(node.right, arr);
    }
}

