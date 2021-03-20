package linkedList;

public class ReverseCLinkedList {
	
	static void reverseCLinkedList(CLinkedList list)
	{
		LNode currNode,prevNode,nextNode;
		currNode=list.head.next;
		prevNode=list.head;
		while(currNode!=list.head)
		{
			nextNode=currNode.next;
			currNode.next=prevNode;
			prevNode=currNode;
			currNode=nextNode;
			
		}
		list.head=prevNode;
		currNode.next=list.head;
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
		list.traverse(list);
		reverseCLinkedList(list);
		list.traverse(list);
		list.insertFromFront(7);
		list.insertFromLast(-1);
		list.insertFromMiddle(3, 500);
		list.traverse(list);
		reverseCLinkedList(list);
		list.traverse(list);
		list.deleteFromFront();
		list.traverse(list);
		list.deleteFromMiddle(7);
		list.traverse(list);
		list.deleteFromLast();
		list.traverse(list);
	}

}
