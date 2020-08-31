/**
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Day24_SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumLeftUtil(root);
        
        return sum;
    }
    
    void sumLeftUtil(TreeNode root) {
        if (root == null)
            return;
        
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        
        sumLeftUtil(root.left);
        sumLeftUtil(root.right);
    }
}