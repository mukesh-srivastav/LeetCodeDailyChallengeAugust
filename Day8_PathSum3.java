/**
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class Day8_PathSum3 {
    int paths = 0;
	
	private void helper (TreeNode root, int sum) {
		
		if (root != null && root.val == sum) {
			++paths;
		}
		if (root != null) {
			sum -= root.val;
			helper (root.left, sum);
			helper (root.right, sum);
		}
	}
	
	public int pathSum (TreeNode root, int sum) {
		
		if (root == null) {
			return 0;
		}
		helper (root, sum);
		pathSum (root.left, sum);
		pathSum (root.right, sum);
		return paths;
	}
}