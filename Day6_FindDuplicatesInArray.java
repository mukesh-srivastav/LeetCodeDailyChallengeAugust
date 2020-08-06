/**
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */
public class Day6_FindDuplicatesInArray {
    public List<Integer> findDuplicates (int[] nums) {
		
		List<Integer> ans = new ArrayList <>();
		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs (nums[i]) - 1;
			if (nums[pos] < 0) {
				ans.add (++pos);
			}
			else {
				nums[pos] *= -1;
			}
		}
		
		return ans;
	}
}