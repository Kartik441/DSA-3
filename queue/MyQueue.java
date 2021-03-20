package queue;

public class MyQueue {
	
    private int arr[];
    private int capacity;
    private int rear;
    private int front;
    
    MyQueue(int size)
    {
    	arr=new int[size];
    	capacity=size;
    	front=rear=-1;
    	capacity=size;
    	
    }
    
    public void enqueue(int data)
    {
    	if(isFull())
    		System.out.println("Overflow");
    	else if(isEmpty())
    	{
    		front=0;
    		rear=0;
    		arr[rear]=data;
    		
    	}
    	else
    	{
    		rear++;
    		arr[rear]=data;
    		
    	}
    }
    
    public void dequeue()
    {
    	if(isEmpty())
    		System.out.println("Underflow");
    	else if(front==rear)
    	{
    		front=-1;
    		rear=-1;
    	}
    	else
    	{
    		front++;
    	}
    }
    
    public boolean isFull()
    {
    	if(rear==capacity-1)
    		return true;
    	else 
    		return false;
    }
    
    public boolean isEmpty()
    {
    	if(rear==-1&&front==-1)
    		return true;
    	else
    		return false;
    }
    
    public void traverse()
    {
    	if(isEmpty())
    		System.out.println("Queue is underflow");
    	else
    	{
    		int temp=front;
    		while(temp<=rear)
    		{
    			System.out.print(arr[temp]+" ");
    			temp++;
    			
    		}
    	}
    	System.out.println();
    }
    
    public void peek()
    {
    	if(isEmpty())
    		System.out.println("Queue is  underflow");
 
    	else
    		System.out.println(arr[front]);
    }

	public static void main(String[] args) {
		MyQueue q=new MyQueue(5);

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
		q.traverse();
		q.peek();

	}

}
