package linkedList;


public class ReverseLinkedList {
	static void reverse(LinkedList list)
	{
		LNode prevNode,currNode,nextNode;
		prevNode=null;
		currNode=list.head;
		while(currNode!=null)
		{
			nextNode=currNode.next;     // because of this we will not lose next node
			currNode.next=prevNode;     
			prevNode=currNode;
			currNode=nextNode;
			
		}
		list.head=prevNode;
		
	}
	
	static void reverseRec(LinkedList list)
	{
		if(list.head == null)
			return;
		LNode head = list.head;
		reverseRec(head, list);
	
	}
	static LNode reverseRec(LNode node, LinkedList list)
	{
		if(node.next == null)
		{
			// it is the last node and after reversing head is going to point to this
			// so will be needing list to change value of head
			list.head = node;
			return node;
		}
		
		LNode nextNode = reverseRec(node.next, list);
		
		nextNode.next = node;
		node.next = null;
		
		return node;
	}

	public static void main(String []args)
	{
		
		LinkedList list=new LinkedList();
		
		list.insert(1);
		list.insert(2);
	    list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		
		
		LinkedList.printList(list.head);
		
	  // reverse(list);
		reverseRec(list);
	   LinkedList.printList(list.head);
	}
	

}
