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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        LinkedList<NodeState> queue = new LinkedList<>();
        if(root == null){
            return answer;
        }
        
        NodeState rootNode = new NodeState(root, 0);
        queue.push(rootNode);
        
        while(!queue.isEmpty()){
            NodeState current = queue.pop();
            List<Integer> valsAtLevel = answer.size() > current.level ? answer.get(current.level) : new ArrayList<>();
            valsAtLevel.add(current.node.val);
            if(answer.size() <= current.level){
                answer.add(valsAtLevel);
            }
            
            if(current.node.left != null){
                NodeState leftNode = new NodeState(current.node.left, current.level + 1);
                queue.add(leftNode);
            }
            
            if(current.node.right != null){
                NodeState rightNode = new NodeState(current.node.right, current.level + 1);
                queue.add(rightNode);
            }
            
        }
        
        return answer;        
        
    }
}

class NodeState{
    int level;
    TreeNode node;
    
    public NodeState(TreeNode root, int level){
        this.level = level;
        this.node = root;
    }
}