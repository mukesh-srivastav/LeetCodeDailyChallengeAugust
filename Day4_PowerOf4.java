/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
 */
public class Day4_PowerOf4 {
    /*
    A number n is a power of 4 if following conditions are met.
    a) There is only one bit set in the binary representation of n (or n is a power of 2)
    b) The bits don’t AND(&) any part of the pattern 0xAAAAAAAA

    For example: 16 (10000) is power of 4 because there is only one bit set and 0x10 & 0xAAAAAAAA is zero.
    Why 0xAAAAAAAA ? This is because the bit representation is of powers of 2 that are not of 4. Like 2, 8, 32 so on.
    */
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        return (num != 0) && ((num & (num - 1)) == 0) && ((num & 0xAAAAAAAA) == 0);
    }
}