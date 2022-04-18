class Solution {
  
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
    public ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> elements) {
        if (node == null){
            return elements;
        }
        
        inorder(node.left, elements);
        elements.add(node.val);
        inorder(node.right, elements);
        return elements;
  }
}