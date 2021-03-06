/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    class ResultType {
        public int sum;
        public int size;
        public TreeNode node;
        public ResultType (TreeNode node, int sum, int size){
            this.node = node;
            this.sum = sum;
            this.size = size;
        }
    }
    private ResultType result = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if (root == null){
            return null;
        }
        ResultType rootResult = helper(root);
        return result.node;
    }
    
    public ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(null,0,0);
        }
        
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType currResult = new ResultType(root, leftResult.sum + rightResult.sum+ root.val,
        leftResult.size + rightResult.size +1);
        
        if (result == null || currResult.sum *result.size > result.sum * currResult.size){
            result = currResult;
        }
        return currResult;
    }
}
