/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
public class Day10_ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            res = res * 26 + (int)(s.charAt(i) - 'A' + 1);
            i++;
        }
        
        return res;
    }
}