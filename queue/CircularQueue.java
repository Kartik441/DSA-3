package queue;

public class CircularQueue {
	private int queue[];
	private int front;
	private int rear;
	private int capacity;
	
	public CircularQueue(int size)
	{
		queue=new int[size];
		capacity=size;
		front=rear=-1;
		
	}
	
	public void enqueue(int data)
	{
		if(isFull())
		{
			System.out.println("Queue is overflow");
		}
		else if(isEmpty())
		{
			rear=0;
			front=0;
			queue[rear]=data;
		}
		else
		{
			rear=(rear+1)%capacity;
			queue[rear]=data;
		}
	}

	public void dequeue()
	{
		if(isEmpty())
			System.out.println("Queue is underflow");
		else if(front==rear)        // means only one element is present
		{
			rear=-1;
			front=-1;
		}
		else
		{
			front=(front+1)%capacity;
		}
	}
	public boolean isFull()
	{
		if((rear+1)%capacity==front)
			return true;
		else
			return false;
	}
	
	public boolean isEmpty()
	{
		if(rear==-1&front==-1)
			return true;
		else
			return false;
	}
	
	public void traverse()
	{
		if(isEmpty())
		{
			System.out.println("Queue is underflow");
		}

		int temp=front;
		while(temp!=rear)
		{
			System.out.println(queue[temp]);
			temp=(temp+1)%capacity;
		}
		System.out.println(queue[rear]);
	}
	
	public void peek()
	{
		if(isEmpty())
			System.out.println("Queue is underflow");
		else
		    System.out.println(queue[front]);
	}
	public static void main(String[] args) {
		CircularQueue q=new CircularQueue(5);

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
		q.enqueue(6);
		q.dequeue();
		q.dequeue();
		q.enqueue(100);
		q.traverse();
		q.peek();

	}

}
