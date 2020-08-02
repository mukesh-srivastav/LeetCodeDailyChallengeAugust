/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False
 

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Day1_DetectCapital {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        
        if (Character.isUpperCase(word.charAt(0)) && isLowerCase(word.substring(1)))
            return true;
        else if (isLowerCase(word))
            return true;
        else if (isUpperCase(word))
            return true;
        
        return false;
    }
    
    private boolean isLowerCase(String word) {
        
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                continue;
            } else 
                return false;
        }
        
        return true;
    }
    
    private boolean isUpperCase(String word) {
        
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                continue;
            } else 
                return false;
        }
        
        return true;
    }
}