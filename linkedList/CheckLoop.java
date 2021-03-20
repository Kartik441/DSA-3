package linkedList;


// how to check without using two pointers??

public class CheckLoop {
	static LNode checkLoop (LNode head)    //for list ,change CLinkedList to LinkedList
	{
		if(head==null)
		return null;
		LNode fast=head;
		LNode slow=head;
		
		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				return fast;	
		}
		return null;       // means no loop is present
		
	}
	
	// function  to find starting point of the loop using floyd algorithm/Tortoise and hare algo
	// remove loop
	static void removeLoop(LNode head)
	{
		LNode p = checkLoop(head);
		LNode q = head;
		while(p.next!= q.next)
		{
			p = p.next;
			q = q.next;
		}
		p.next = null;
	}
	

	public static void main(String[] args) {
LinkedList list=new LinkedList();
		
		list.insert(1);
		list.insert(2);
	    list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		
		
//		CLinkedList list=new CLinkedList();
//		list.insertFromLast(1);
//		list.insertFromLast(2);
//		list.insertFromLast(3);
//		list.insertFromLast(4);
//		list.insertFromLast(5);
//		list.insertFromLast(6);
//		list.insertFromFront(0);
//		list.insertFromFront(100);
//		list.insertFromFront(200);
		
		System.out.println(checkLoop(list.head));
		

	}

}
