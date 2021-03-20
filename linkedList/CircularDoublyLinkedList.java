package linkedList;

class CDLinkedList
{
	DNode head;
	DNode tail;
	
	void insertFromHead(int data)
	{
		DNode n=new DNode(data);
		if(head==null)
		{
			head=n;
			tail=n;
			n.next=head;
			n.prev=tail;
		}
		else {
			n.next=head;
			n.prev=tail;
			head.prev=n;
			head=n;
			tail.next=head;
		}
			
	}
	
	void insertFromTail(int data)
	{
		DNode n=new DNode(data);
		if(tail==null)
		{
			head=n;
			tail=n;
			n.next=head;
			n.prev=tail;
		}
		
		else {
			n.next=head;
			n.prev=tail;
			tail.next=n;
			tail=n;
			head.prev=tail;
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
			for(int i=1;i<pos-1&&temp!=tail;i++)
				temp=temp.prev;
			if(temp==tail)
				System.out.println("Invalid position");
			else {
			n.next=temp;
			n.prev=temp.prev;
			temp.prev.next=n;
			temp.prev=n;
			}
		}
	}
	
	void insertFromHead(int pos, int d)
	{
		DNode n=new DNode(d);
		if(pos==1)
			insertFromHead(d);
		else
		{
			DNode temp=head;
			for(int i=1;i<pos-1&&temp!=head;i++)
				temp=temp.next;
			if(temp==head)
				System.out.println("Invalid position");
			else {
			 n.next=temp.next;
			 n.prev=temp;
			 n.next.prev=n;
			 temp.next=n;
			}
		}
	}
	
	void deleteFromHead()
	{
		if(head==null)
			System.out.println("List is empty");
		else if(head.next==head)
		{	head=null;
		    tail=null;
		}
		else
		{
			head.next.prev=tail;
			head=head.next;
			tail.next=head;
//			head=head.next;
//			head.prev=tail;
//			tail.next=head;
		}
	}
	
	void deleteFromHead(int pos)
	{
		if(pos==1)
			deleteFromHead();
		else {
			DNode temp=head;
			for(int i=1;i<pos-1&&temp!=head;i++)
				temp=temp.next;
			if(temp==head)
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
		{
			System.out.println("List is empty");
		}
		else if(tail.prev==tail)
		{
			tail=null;
			head=null;
		}
		else {
			tail.prev.next=head;
			tail=tail.prev;
			head.prev=tail;
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
	void traverseHead(CDLinkedList list)
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			DNode temp=head;
			do
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}while(temp!=head);
		}
		
		System.out.println();
	}
	
	void traverseTail(CDLinkedList list)
	{
		if(tail==null)
			System.out.println("List is empty");
		else
		{
			DNode temp=tail;
			do
			{
				System.out.print(temp.data+" ");
				temp=temp.prev;
			}while(temp!=tail);
		}
		
		System.out.println();
	}
}

public class CircularDoublyLinkedList {

	public static void main(String[] args) {
		
		CDLinkedList list=new CDLinkedList();
		list.insertFromHead(3);
		list.insertFromHead(2);
		list.insertFromHead(1);
		list.insertFromTail(4);
		list.insertFromTail(5);
		list.deleteFromHead();
		list.deleteFromHead();
//		list.deleteFromTail();
//		list.deleteFromTail();
//		list.deleteFromTail();
		list.insertFromHead(8, 500);
		list.traverseHead(list);
		list.traverseTail(list);
		
	}

}
