package queue;



class LNode{
	int data;
	LNode next;
	LNode(int d)
	{
		data=d;
		next=null;
	}
	LNode()
	{}
	
}
class QueueLL
{
	LNode front;
	LNode rear;
	
	public void enqueue(int data)  //insertion from rear
	{
		LNode n=new LNode(data);
		if(front==null)
		{
			front=n;
			rear=n;
		}
		else
		{
			rear.next=n;
			rear=n;
		}
		
	}
	
	public void dequeue()
	{
		if(front==null)
			System.out.println("Queue is empty");
		else if(front.next==null)
		{
			rear=null;
			front=null;
		}
		else
		{
			front=front.next;
		}
			
	}
	
	public void traverse()
	{
		if(front==null)
			System.out.println("Queue is empty");
		else
		{
			LNode temp=front;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
		System.out.println();
	}
	
	
	
	
}

public class QueueUsingLinkedList {

	public static void main(String[] args) {
		
		QueueLL q=new QueueLL();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();

		q.dequeue();
		q.dequeue();
		q.enqueue(100);
		q.enqueue(200);
		q.traverse();
		

	}

}
