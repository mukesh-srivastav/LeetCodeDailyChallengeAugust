/**
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:

You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
 

Example 1:

Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
 

Example 2:

Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
 

Example 3:

Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
 */
public class Day27_FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        if(intervals.length == 0)
            return result;
        if(intervals.length == 1)
            return new int[] {-1};
        for(int i=0;i<intervals.length;i++){
            result[i] = intervals[i][1];
            intervals[i][1] = i;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int i=0;i<result.length;i++){
            int l = 0;
            int r = intervals.length - 1;
            int val = -1;
            while(l<=r){
                int mid = (l+r)/2;
                if(intervals[mid][0]>=result[i]){
                    r = mid-1;
                    val = intervals[mid][1];
                }
                else{
                    l = mid+1;
                }
            }
            result[i] = val;
        }
        
        return result;
    }
}