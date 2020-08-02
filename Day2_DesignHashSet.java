/**
 * Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
 */
public class Day2_DesignHashSet {
    
    class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    int capacity = 100000;
    Node hash[];
    
    /** Initialize your data structure here. */
    public Day2_DesignHashSet() {
        hash = new Node[capacity];
        for (Node n : hash)
            n = null;
    }
    
    public void add(int key) {
        int h = key%capacity;
        Node head = hash[h];
        
        if (head != null) {
            while (head.next != null && head.val != key)
                head = head.next;
            
            if (head.val == key)
                return;
            
            head.next = new Node(key);
        } else {
            head = new Node(key);
            hash[h] = head;
        }  
    }
    
    public void remove(int key) {
        int h = key%capacity;
        Node head = hash[h];
        
        if (head != null) {
            if (head.val == key)
                hash[h] = null;
            
            Node prev = head;
            head = head.next;
            while (head != null) {
                if (head.val == key) {
                    prev.next = head.next;
                }
                prev = head;
                head = head.next;
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = key%capacity;
        Node head = hash[h];
        
        if (head != null) {
            
            while (head != null) {
                if (head.val == key)
                    return true;
                
                head = head.next;
            }
            
            return false;
        }
        
        return false;
    }
       
}