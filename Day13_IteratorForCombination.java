/**
 * Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
 */
public class Day13_IteratorForCombination {
    ArrayList<String> comb;
    int pointer, cLen;
    public Day13_IteratorForCombination(String characters, int combinationLength) {
        this.comb = new ArrayList<>();
        this.pointer = 0;
        this.cLen = combinationLength;
        this.combinations(characters, 0, "");
    }
    public void combinations(String s, int index, String com){
        if(com.length() == this.cLen){
            this.comb.add(com);
            return ;
        }
        if(index >= s.length()) return ;
        for(int i = index; i < s.length(); i++)
            combinations(s, i + 1, com + String.valueOf(s.charAt(i)));
    }
    public String next() {
        return this.comb.get(this.pointer++);
    }
    
    public boolean hasNext() {
        return this.pointer < this.comb.size();
    }
}


/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */