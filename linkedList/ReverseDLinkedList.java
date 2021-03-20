package linkedList;

public class ReverseDLinkedList {

	static void reverseDLinkedList(DLinkedList list)
	{
		
		DNode temp=list.head;
		while(temp!=null) {

			DNode swap;
			swap=temp.next;
			temp.next=temp.prev;
			temp.prev=swap;
		
			temp=temp.prev;
		}

		DNode swap=list.head;
		list.head=list.tail;
		list.tail=swap;

	}
	
	
	public static void main(String args[])
	{
		DLinkedList list=new DLinkedList();
		list.insertFromTail(1);
		list.insertFromTail(2);
		list.insertFromTail(3);
		list.insertFromTail(4);
		list.insertFromTail(5);
		list.insertFromHead(6,6);
		list.traverseHead();
		list.traverseTail();
		reverseDLinkedList(list);

		list.traverseHead();
		list.traverseTail();
		
	}
}
