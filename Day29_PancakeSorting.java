/**
 * Given an array of integers A, We need to sort the array performing a series of pancake flips.

In one pancake flip we do the following steps:

Choose an integer k where 0 <= k < A.length.
Reverse the sub-array A[0...k].
For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2, we reverse the sub-array [3,2,1], so A = [1,2,3,4] after the pancake flip at k = 2.

Return an array of the k-values of the pancake flips that should be performed in order to sort A. Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

 

Example 1:

Input: A = [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k = 4): A = [1, 4, 2, 3]
After 2nd flip (k = 2): A = [4, 1, 2, 3]
After 3rd flip (k = 4): A = [3, 2, 1, 4]
After 4th flip (k = 3): A = [1, 2, 3, 4], which is sorted.
Notice that we return an array of the chosen k values of the pancake flips.
Example 2:

Input: A = [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
 

Constraints:

1 <= A.length <= 100
1 <= A[i] <= A.length
All integers in A are unique (i.e. A is a permutation of the integers from 1 to A.length).
 */
public class Day29_PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        // 1. Look up max element
        // 2. Bring it to 0'th index
        // 3. Move it to last index (last non-fixed index)
        // 4. This max element is fixed, try next max element
        // 5. Time - O(n) space complexity O(n)
        List<Integer> flips = new ArrayList<>();

        if(A==null || A.length==0)
            return flips;

        int fixedElements = 0;
        //keep elements in max heap to avoid traversal every time you need to place max element at its right place.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> b-a); // Time - O(1) // space complexity O(n)

        for(int num : A) {  // Time - O(n)
            maxHeap.offer(num);
        }

        while(fixedElements < A.length) {

            int maxElementIndex = getMaxElementIndex( A, maxHeap.poll() ); // Time - O(n)
            //Element is at its right place, no need to sort
            if(maxElementIndex == (A.length-1-fixedElements)) {
                fixedElements++;
                continue;
            }

            //if not at 0'thn index, flip with zero index
            if(maxElementIndex != 0) {
                reverseArray(A, 0, maxElementIndex);  // Time - O(n)
                flips.add(maxElementIndex+1);
            }


            //flip with last index
            if(A.length-1-fixedElements!= 0) {
                reverseArray(A, 0, A.length-1-fixedElements); // Time - O(n)
                flips.add(A.length-fixedElements);
            }

            //track the fixed index now
            fixedElements++;
        }
        return flips;
     }

     private int getMaxElementIndex(int[] A, int target) {
        for(int i=0; i<=A.length-1; i++) {
            if(A[i] == target)
                return i;
        }
         return -1;
     }

     private void reverseArray(int[] A, int i, int j) {

         while( i< j) {
             int temp = A[i];
             A[i] =  A[j];
             A[j] = temp;
             i++;
             j--;
         }
    } 
}