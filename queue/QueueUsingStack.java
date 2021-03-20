package queue;


public class QueueUsingStack {
	
	private int stack1[];
	private int top1;
	private int stack2[];
	private int top2;
	private int capacity;
	
	public QueueUsingStack(int size) {
		stack1=new int[size];
		stack2=new int[size];
		capacity=size;
		top1=top2=-1;
					
	}
	
	public void enqueue(int data)
	{
		if(top1==capacity-1)
			System.out.println("Queue is overflowed");
		else {
		top1++;
		stack1[top1]=data;
		}
	}
	
	public void dequeue()
	{
		if(top1==-1)
			System.out.println("Queue is underflow");
		else
		{
			for(int i=top1;i>=0;i--)
			{
				stack2[++top2]=stack1[i];
			}
			top2--;
			top1=-1;
			for(int i=top2;i>=0;i--)
			{
				stack1[++top1]=stack2[i];
			}
			top2=-1;
		}
	}
	
	public void traverse()
	{
		if(top1==-1)
			System.out.println("Queue is Underflow");
		else
		{
			for(int i=0;i<=top1;i++)
			{
				System.out.print(stack1[i]+" ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		QueueUsingStack q=new QueueUsingStack(5);
		
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
		

	}

}
