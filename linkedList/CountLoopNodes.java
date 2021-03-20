package linkedList;

public class CountLoopNodes {
	
	static int countLoopNodes(LNode head)
	{
		LNode fast=head;
		LNode slow=head;
        
		while(fast!=null&&fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				break;
		}

		if(fast!=slow)
			return 0;
		else
		{
			int count=1;
			LNode temp=slow.next;
			while(temp!=slow)
			{
				count++;
				temp=temp.next;
			}
			return count;
		}
	}

	public static void main(String[] args) {
		CLinkedList list=new CLinkedList();
		list.insertFromLast(1);
		list.insertFromLast(2);
		list.insertFromLast(3);
		list.insertFromLast(4);
		list.insertFromLast(5);
		list.insertFromLast(6);
		list.insertFromFront(0);
		list.insertFromFront(100);
		list.insertFromFront(200);
//		LinkedList list=new LinkedList();
//		
//		list.insert(1);
//		list.insert(2);
//	    list.insert(3);
//		list.insert(4);
//		list.insert(5);
//		list.insert(6);
//		list.insert(7);
//		list.insert(8);
//		list.insert(9);
		
		System.out.println(countLoopNodes(list.head));

	}

}
