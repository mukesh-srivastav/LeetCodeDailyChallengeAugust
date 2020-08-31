/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class Day20_ReorderList {
    public void reorderList(ListNode head) {
        //If there are no nodes or one node then there is nothing to reorder
        if(head == null || head.next == null){
            return;
        }
        
        //Get middle node and disconnect the list at the middle node
        ListNode p = getAndDisconnectMiddleNode(head);
        //We've split the list into 2 halves
        //Store middle node onwards in a stack
        //effectively reversing it.
        Deque<ListNode> stack = new LinkedList<>();
        while(p!=null){
            stack.push(p);
            ListNode prev = p;
            p = p.next;
            //Remove the links as we add to the stack
            //this avoids cycles in the final list
            prev.next = null;
        }
        
        //Reorder the list by merging first half and
        //reversed second half from stack
        ListNode ptr = head;
        while(!stack.isEmpty() && ptr!=null){
            ListNode rev = stack.pop();
            ListNode next = ptr.next;
            ptr.next = rev;
            rev.next = next;
            ptr = next;
            if(next==null && !stack.isEmpty()){
                 //we've run out of nodes from the first half
                //so add the node from the second half as the last node
                 rev.next = stack.pop();
             }
        }
    }
    
    /**
    ** Get's the middle node while also
    ** disconnecting the list
    **/
    private ListNode getAndDisconnectMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;
        
        while(fast!=null && fast.next!=null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //Break the link between the two portions 
        //of the list (first half and second half)
        //This prevents cycles in the resultant list
        if(slowPrev!=null){
            slowPrev.next = null;
        }
        return slow;
    }
}