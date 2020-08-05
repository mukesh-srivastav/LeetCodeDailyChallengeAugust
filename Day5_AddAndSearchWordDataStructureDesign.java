class Day5_AddAndSearchWordDataStructureDesign {
    class TrieNode {
        boolean isEndOfWord;
        TrieNode children[] = new TrieNode[26];
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Day5_AddAndSearchWordDataStructureDesign() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        
        for (int i=0; i<word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null) {
                temp.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        
        temp.isEndOfWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchUtil(root, word);
    }
    
    private boolean searchUtil(TrieNode root, String word) {
        TrieNode temp = root;
        for (int i = 0; i<word.length(); i++) {
            if (word.charAt(i) != '.' && temp.children[word.charAt(i) - 'a'] == null)
                return false;
            else if (word.charAt(i) == '.') {
                boolean notNull = false;
                for (int ci=0; ci< 26; ci++) {
                    if (temp.children[ci] != null) {
                        notNull = true;
                        if ((i+1 == word.length() && temp.isEndOfWord) || (searchUtil(temp.children[ci], word.substring(i+1, word.length())))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            temp = temp.children[word.charAt(i) - 'a'];
        }
        
        return temp.isEndOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */