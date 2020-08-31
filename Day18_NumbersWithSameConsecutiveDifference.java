/**
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

Note:

1 <= N <= 9
0 <= K <= 9
 */
public class Day18_NumbersWithSameConsecutiveDifference {
    List<Integer> output;
    public int[] numsSameConsecDiff(int N, int K) {
        output = new ArrayList<>();
        int[] output2 = {0,1,2,3,4,5,6,7,8,9};
        if(N == 1) return output2;
        for(int i = 1 ; i < 10 ; i ++)
        {
            dfs(i,N-1,K,i);
        }
        
        int arr[] = new int[output.size()];
        for(int i = 0 ; i < output.size() ; i ++)
        {
            arr[i] = output.get(i);
        }
        
        return arr;
    }
    
    public void dfs(int start, int remaining, int difference,int number)
    {
        if(remaining == 0)
        {
            output.add(number);
            return;
        }
        
        int opt1 = start - difference;
        int opt2 = start + difference;
        
        if(opt1 >= 0 )
        {
            dfs(opt1,remaining - 1,difference,number*10 + opt1);
        }
        
        if(opt2 < 10 && difference > 0)
        {
            dfs(opt2,remaining - 1,difference,number*10 + opt2);
        }
        
    } 
}