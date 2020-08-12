/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

Solution: 
nth row of pascal triangle is [NC0, NC1, ......, NCN - 1, NCN]

Also, NCr can we calculated with the help of NCr-1 as NCr = (NCr - 1 * (N - r + 1)) / r where 1 ≤ r ≤ N

						0C0
					1C0    1C1
				2C0    2C1    2C2
			3C0    3C1    3C2    3C3
						.
						.
						.
	NC0    NC1   . . . . . . ..   NCN-1   NCN	
NCr = N! / r! (N-r)! --->1
NCr-1 = N! / (r-1)! (N-r+1)! ---> 2

divide 1 and 2

NCr = NCr-1 * (N-r+1) / r;

 */
public class Day12_PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        long C = 1;
        rowIndex++;
        List <Integer> list = new ArrayList<>();
        for (int i = 1; i<=rowIndex; i++) {
            list.add((int)C);
            C = (long)C * (rowIndex - i) / i;
        }
        
        return list;
    }
}