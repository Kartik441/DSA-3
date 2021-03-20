package queue;

public class Deque {
	
	private int deque[];
	private int front;
	private int rear;
	private int capacity;
	
	Deque(int size)
	{
		capacity=size;
		deque=new int[capacity];
		front=rear=-1;
		
	}
	
	boolean isEmpty()
	{
		if(rear==-1&&front==-1)
			return true;
		else
			return false;
	}
	
	boolean isFull()
	{
		if((rear+1)%capacity==front)
			return true;
		else
			return false;
	}
	
	void enqueueRear(int data)
	{
	    if(isEmpty())
		{
			front=0;
			rear=0;
			deque[rear]=data;
		}
		
		else if(isFull())
		{
			System.out.println("Queue is overflowed");
		}
	    
		else
		{
			rear=(rear+1)%capacity;
			deque[rear]=data;
		}
	}
	
	void dequeueFront()
	{
		if(isEmpty())
			System.out.println("Queue is underflow");
		else if(rear==front)
		{
			rear=-1;
			front=-1;
		}
		else
		{
			front=(front+1)%capacity;
		}
	}
	
	void enqueueFront(int data)
	{
		if(isFull())
			System.out.println("Queue is overflowed");
		else if(isEmpty())
		{
			rear=0;
			front=0;
			deque[front]=data;
		}
		else if(front==0)
		{
			front=capacity-1;
			deque[front]=data;
		}
		else
		{
			front--;
			deque[front]=data;
		}
	}
	
	void dequeueRear()
	{
		if(isEmpty())
		{
			System.out.println("Queue is undersflow");
			
		}
		
		else if(front==rear)
		{
			front=-1;
			rear=-1;
		}
		
		else if(rear==0)
		{
			rear=capacity-1;
		}
		
		else
		{
			rear--;
		}
	}
	
	public void traverse()
	{
		if(isEmpty())
		{
			System.out.println("Queue is underflow");
		}
		else
		{
			int temp=front;
			while(temp!=rear)
			{
				System.out.print(deque[temp]+" ");
				temp=(temp+1)%capacity;
			}
			System.out.println(deque[rear]);
		}
	}

	public static void main(String[] args) {
		
		Deque q=new Deque(5);
		q.enqueueFront(2);
		q.enqueueFront(5);
		q.enqueueRear(-1);
		q.enqueueRear(0);
		q.enqueueFront(7);
		q.enqueueFront(4);
		q.traverse();
		q.dequeueFront();
		q.dequeueRear();
		q.dequeueFront();
		q.traverse();

	}

}
