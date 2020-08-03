/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 

Constraints:

s consists only of printable ASCII characters.
 */
public class Day3_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        int n = s.length();
        System.out.println(s);
        if (n==0)
            return true;
        int i =0;
        while (i<=n/2) {
            if (s.charAt(i) != s.charAt(n-i-1))
                return false;
            i++;
        }
        
        return true;
    }
}