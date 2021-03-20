package linkedList;

import java.util.HashMap;

// make sure to use address as key and not value to avoid duplicate case
class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };

public class CloneListRandomPointer {
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        	return null;
        
        if(head.next == null)
        {
            RandomListNode n = new RandomListNode(head.label);
            n.next = null;
            n.random = head.random;
            return n;
        }
        
        RandomListNode temp = head.next; // pointing to the second node of the linked list
        // now cloning first node of the linked list
        RandomListNode headClone = new RandomListNode(head.label);
        RandomListNode Ctemp = headClone;
        
        HashMap<RandomListNode, RandomListNode> m = new HashMap<>();
        m.put(head, headClone);
        // this loop will start from the second node
        while(temp != null)
        {
            
            RandomListNode n = new RandomListNode(temp.label);
            
            m.put(temp, n);
            
            Ctemp.next = n;
            
            temp = temp.next;
            Ctemp = Ctemp.next;
        }
        // now attaching random pointers
        temp = head;
        Ctemp = headClone;
        while(temp != null)
        {
            Ctemp.random = m.get(temp.random);
            temp = temp.next;
            Ctemp = Ctemp.next;
        }
        
        return headClone;
        
    }

	public static void main(String[] args) {
		

	}

}
