package linkedList;

class DNode
{
	DNode prev;
	DNode next;
	int data;
	
	DNode(int x)
	{
		data=x;
		prev=null;
		next=null;
	}
	DNode()
	{
		prev=null;
		next=null;
	}
}

class DLinkedList
{
	DNode head;
	DNode tail;
	
	void traverseHead()
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			DNode temp=head;
			while(temp!=null)
			{
			    System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
		System.out.println();
	}
	
	void traverseTail()
	{
		if(tail==null)
			System.out.println("List is empty");
		else
		{
			DNode temp=tail;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.prev;
			}
		}
		System.out.println();
	}
	
	
	void insertFromHead(int pos, int d)
	{
		DNode n=new DNode(d);
		if(pos==1)
			insertFromHead(d);
		else
		{
			DNode temp=head;
			for(int i=1;i<pos-1&&temp!=null;i++)
				temp=temp.next;
			if(temp==null)
				System.out.println("Invalid position");
			else {
			 n.next=temp.next;
			 n.prev=temp;
			 n.next.prev=n;
			 temp.next=n;
			}
		}
	}
	
	void insertFromHead(int d)
	{
		DNode n=new DNode(d);
		if(head==null)
		{
			head=n;
			tail=n;
		}
		else {
			n.next=head;
			head.prev=n;
			head=n;
			
		}
	}
	
	void insertFromTail(int pos,int d)
	{
		DNode n=new DNode(d);
		if(pos==1)
			insertFromTail(d);
		else
		{
			DNode temp=tail;
			for(int i=1;i<pos-1&&temp!=null;i++)
				temp=temp.prev;
			if(temp==null)
				System.out.println("Invalid position");
			else {
			n.next=temp;
			n.prev=temp.prev;
			temp.prev.next=n;
			temp.prev=n;
			}
		}
	}
	
	void insertFromTail(int d)
	{
		DNode n=new DNode(d);
		if(tail==null)
		{
			head=n;
			tail=n;
		}
		else
		{
			n.prev=tail;
			tail.next=n;
			tail=n;
		}
	}
	
	void deleteFromHead()
	{
		if(head==null)
			System.out.println("List is empty");
		else if(head.next==null)
		{
			head=null;
			tail=null;
		}
		else
		{
			head.next.prev=null;
			head=head.next;
		}
	}
	
	void deleteFromHead(int pos)
	{
		if(pos==1)
			deleteFromHead();
		else {
			DNode temp=head;
			for(int i=1;i<pos-1&&temp!=null;i++)
				temp=temp.next;
			if(temp==null)
				System.out.println("Invalid position");
			else {
				temp.next.next.prev=temp;
				temp.next=temp.next.next;
			}
		}
	}
	
	void deleteFromTail()
	{
		if(tail==null)
			System.out.println("List is empty");
		else if(tail.prev==null)
		{
			tail=null;
			head=null;
		}
		else
		{
			tail.prev.next=null;
			tail=tail.prev;
		}
	}
	
	void deleteFromTail(int pos)
	{
		if(pos==1)
			deleteFromTail();
		else {
			DNode temp=tail;
			for(int i=1;i<pos-1&&temp!=null;i++)
				temp=temp.prev;
			if(temp==null)
				System.out.println("Invalid position");
			else {
				temp.prev.prev.next=temp;
				temp.prev=temp.prev.prev;
			}
		}
	}
}

public class DoublyLinkedList {

	public static void main(String[] args) {
		DLinkedList list=new DLinkedList();
		list.insertFromHead(2);
		list.insertFromHead(1);
	
		list.insertFromTail(4);
		list.insertFromTail(5);
		list.insertFromTail(3, 3);
		list.insertFromHead(3,300);
		list.traverseHead();
		list.traverseTail();
		list.deleteFromHead();
		list.traverseHead();
		list.traverseTail();
		list.deleteFromTail(2);
		list.insertFromTail(8, 8);
		
		list.traverseHead();
		list.traverseTail();
		list.insertFromHead(4,4);
		list.traverseHead();
		list.traverseTail();
		list.deleteFromHead();
		list.deleteFromTail();
		list.traverseHead();
		list.traverseTail();
		

	}

}
