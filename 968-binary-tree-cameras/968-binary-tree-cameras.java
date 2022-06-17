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
    public int minCameraCover(TreeNode root) {
        int[] result = evaluate(root);
        if(result[0] == 0) result[1]++;
        System.out.println(Arrays.toString(result));
        return result[1];
    }
    
    // returns array of two values,
    // The first for status and  the second for number of cameras
    // Status 0 - needs camera,  1 - no need for camera 2 - is a camera
    public int[] evaluate(TreeNode node){
        if(node == null){
            return new int[]{1, 0};
        }
        
        int[] left = evaluate(node.left);
        int[] right = evaluate(node.right);
        int status = 0;
        int cameras = 0;
        // If one of the children need camera
        if(left[0] == 0 || right[0] == 0){
            status = 2;
            cameras += 1;
        // If both of the children are not cameras
        }else if(left[0] < 2 && right[0] < 2){
            status = 0;
        // If one of the children are cameras
        }else if(left[0] == 2 || right[0] == 2){
            status = 1;
        }
        cameras += left[1] + right[1];
        return new int[]{status, cameras};
    }
    
}