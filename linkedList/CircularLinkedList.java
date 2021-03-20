package linkedList;

class CLinkedList
{
	LNode head;
	
	void insertFromLast(int data)
	{
		LNode n=new LNode(data);
		if(head==null) {
			head=n;
			n.next=head;
		}
		else
		{
			LNode temp=head;
			do
			{
				temp=temp.next;
			}while(temp.next!=head);
	
			temp.next=n;
			n.next=head;
		}
	}
	
	void insertFromFront(int data)
	{
		LNode n=new LNode(data);
		if(head==null) {
			head=n;
			n.next=head;
		}
		else
		{

			LNode temp=head;
			do
			{
				temp=temp.next;
			}while(temp.next!=head);
	
			temp.next=n;
			n.next=head;
			head=n;
		}
			
	}
	
	void traverse(CLinkedList list)
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			LNode temp=head;

			do
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}while(temp!=head);
		}
		System.out.println();
	}
	
	void insertFromMiddle(int pos,int data)
	{
		LNode n=new LNode(data);
		if(pos==1)
			insertFromFront(data);
		else {
			LNode temp=head;
			for(int i=1;i<pos-1;i++)
			{
				temp=temp.next;
			}
			n.next=temp.next;
			temp.next=n;
		}
	}
	
	void deleteFromFront()
	{
		if(head==null)
			System.out.println("List is empty");
		else if(head.next==head)
			head=null;
		else {
		LNode temp=head;
		do 
		{
			temp=temp.next;
		}while(temp.next!=head);
		head=head.next;
		temp.next=head;
		
		}
	}
	
	void deleteFromLast()
	{
		if(head==null)
			System.out.println("List is empty");
		else if(head.next==head)
			head=null;
		else
		{
			LNode temp=head;
			do {
				temp=temp.next;
			}while(temp.next.next!=head);
			
			temp.next=head;
		}
		
	}
	
	void deleteFromMiddle(int pos)
	{
		if(head==null)
			System.out.println("List is empty");
		else if(head.next==head)
			head=null;
		else
		{
			LNode temp=head;
			for(int i=1;i<pos-1;i++)
			{
				temp=temp.next;
			}
			temp.next=temp.next.next;
		}
	}
}

public class CircularLinkedList {

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
		list.insertFromMiddle(4,5555);
		list.insertFromMiddle(5,6666);
		
		list.traverse(list);
		list.deleteFromFront();
		list.traverse(list);
		list.deleteFromFront();
		list.traverse(list);
		list.deleteFromLast();
		list.traverse(list);
		list.deleteFromLast();
		list.traverse(list);
		list.deleteFromMiddle(2);
		list.traverse(list);
		list.deleteFromMiddle(2);
		list.traverse(list);
		
	}

}
