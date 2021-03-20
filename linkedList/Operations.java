package linkedList;

 class LNode{
	int data;
	LNode next;
	LNode(int d)
	{
		data=d;
		next=null;
	}
	LNode()
	{ }
	
}
   class LinkedList
{
	
	LNode head;
	
	public void insertMiddle(int pos,int data)
	{
		if(pos==1)
			insertFromFront(data);
		else {
		LNode n=new LNode(data);
		LNode temp=head;
		for(int i=1;i<pos-1&&temp!=null;i++)   // IF POS is index than only change (i<pos)
		{
			temp=temp.next;
		}
		if(temp==null)
			System.out.println("Invalid position");
		else {
		n.next=temp.next;
		temp.next=n;
		}
		}
		
	}
	
	public void insertFromFront(int data)
	{
		LNode n=new LNode(data);
		if(head==null)
		{
			head=n;
		}
		else {
			n.next=head;
			head=n;
		}
	}
	
	public void insert(int data)        // For inserting at last of the linked list
	{
		LNode n=new LNode(data);
		
		if(head==null) {
			head=n;
		}
		else {
			LNode temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}	
			temp.next=n;
		}
		
		
		
	}
	public static void printList(LNode head)
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			LNode temp=head;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
			    temp=temp.next;
			}
		}
		System.out.println();
	}
	
	void deleteFromFront()
	{
		if(head==null)
			System.out.println("List is empty");

		else {
			head=head.next;
		}
	}
	void deleteFromLast()
	{
		if(head==null)        // If list is empty
			System.out.println("List is empty");
		else if(head.next==null)   // If list contains only one element
			head=null;
		else {
			LNode temp=head;
			while(temp.next.next!=null)    
				temp=temp.next;
			temp.next=null;
		}
	}
	void delete(int data)      // It will delete the node whose data value matches with the arguments
	{
		if(head==null)
			System.out.println("List is empty");
		else if(head.data==data)
			head=head.next;
		else
		{
			LNode temp=head;
			while(temp.next!=null && temp.next.data!=data)
				temp=temp.next;
			
			if(temp.next==null)
				System.out.println("Data is not present in the linked list");
			
			else
				temp.next=temp.next.next;
			
		}
	}
}
public class Operations {

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
		
		
		LinkedList.printList(list.head);
		list.delete(9);
		LinkedList.printList(list.head);
//		list.deleteFromFront();
//		list.printList();
		list.deleteFromLast();
//		list.printList();
//		list.delete(3);
//		list.printList();
//		list.insertMiddle(1,1);
//		list.printList();
//		list.insertMiddle(3,3);
//		list.printList();
//		list.insertMiddle(8,8);
//		list.printList();
//		list.insertMiddle(19,10);
		list.insertMiddle(4,100);
		LinkedList.printList(list.head);
		

	}

}


/////////////////////////////////////////////////////////////////////////////////////
//**********************************************************************************//
////////////////////////////////////////////////////////////////////////////////////

//package linkedList;
//
//class LinkedList
//{
//	static class Node
//	{
//		int data;
//		Node next;
//		Node(int d)
//		{
//			data=d;
//			next=null;
//		}
//	}
//	Node head;
//	
//	public static void insert(LinkedList list,int data)
//	{
//		Node n=new Node(data);
//		n.next=null;
//		if(list.head==null) {
//			list.head=n;
//		}
//		else {
//			Node temp=list.head;
//			while(temp.next!=null)
//			{
//				temp=temp.next;
//			}	
//			temp.next=n;
//		}
//		
//		
//		
//	}
//	public static void printList(LinkedList list)
//	{
//		if(list.head==null)
//			System.out.println("List is empty");
//		else
//		{
//			Node temp=list.head;
//			while(temp!=null)
//			{
//				System.out.print(temp.data+" ");
//			    temp=temp.next;
//			}
//		}
//	}
//	
//}
//public class Operations {
//
//	public static void main(String[] args) {
//		
//		
//		LinkedList list=new LinkedList();
//		
//		list.insert(list, 1);
//		list.insert(list, 2);
//	    list.insert(list, 3);
//		list.insert(list, 4);
//		list.insert(list, 5);
//		list.insert(list, 6);
//		list.insert(list, 7);
//		list.insert(list, 8);
//		
//		
//		list.printList(list);
//		
//
//	}
//
//}

