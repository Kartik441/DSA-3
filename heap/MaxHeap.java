package heap;

public class MaxHeap {
	
	int [] heap;
	int size;
	int maxSize;
	
	public MaxHeap(int maxSize)
	{
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MAX_VALUE;
	}
	
//	static int parent(int i)
//	{
//		return (i-1)/2;
//	}
	
	static int parent(int pos)
	{
		return pos/2;
	}
	
	
//	static int leftChild(int i)
//	{
//		return (2*i)+1;
//	}
	
	public int leftChild(int pos) { return 2*pos; }
	public int rightChild(int pos) { return 2*pos + 1; }
	
//	static int rightChild(int i)
//	{
//		return (2*i)+2;
//	}
	public boolean isLeaf(int pos)
	{
		if(pos > (size/2) && pos <= size )
		{
			return true;
		}
		return false;
	}
	
	public void swap(int fpos, int spos)
	{
		int temp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = temp;
	}
	
	public void maxHeapify(int pos)
	{
		if(isLeaf(pos))        // base condition of recursion
			return;
		
		// if current element is smaller than the either of it child than swapping needs to be done
		if(heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)])
		{
			// swapping will be done with the larger among two child
			if(heap[leftChild(pos)] > heap[rightChild(pos)])
			{
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else
			{
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}
	
	public void insert(int element)
	{
		heap[++size] = element;
		int current  = size;
		while(heap[current] > heap[parent(current)])
		{
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public int extractMax()
	{
		int popped = heap[1];
		heap[1] = heap[size--];
		maxHeapify(1);
		return popped;
	}
	
	public void print()
	{
		for(int i=1;i<=size/2;i++)
		{
			System.out.println("Parent: "+heap[i] + " Left child: " + heap[2*i] +" Right child: "+heap[2*i+1]);
		}
	}
//	public static void insert(int heap[],int data)
//	{
//		int size=size(heap)-1;
//		heap[++size]=data;
//		
//		int i=size;
//		while(i>=0)
//		{
//			if(heap[parent(i)]<heap[i])
//			{
//				int temp=heap[i];
//				heap[i]=heap[parent(i)];
//				heap[parent(i)]=temp;
//			}
//			else
//				break;
//			
//			i=(i-1)/2;
//		}
//
//		
//	}
	
	static int size(int arr[])
	{
		int size=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)
				size++;
			else
				break;
				
		}
		
		return size;
	}
	
	public static void print(int arr[])
	{
		for(int i:arr)
			System.out.print(i+" ");
		
		System.out.println();
	}
	
//	public static int extractMax(int heap[])
//	{
//		if(heap[0]==0)
//		{
//			System.out.println("Heap is empty");
//			return 0;
//		}
//		int size=size(heap)-1;
//		int max=heap[0];
//		heap[0]=heap[size];
//		heap[size]=0;             // because of personal size function
//		size--;
//		maxHeapify(heap);
//		return max;
//		
//	}
	
//	static void maxHeapify(int []heap)
//	{
//		int size=size(heap)-1;
//		int i=0;
//		while(i<=size)
//		{
//			if(heap[i]<heap[leftChild(i)]||heap[i]<heap[rightChild(i)]){
//
//				int left=heap[leftChild(i)];
//				int right=heap[rightChild(i)];
//				int max;                 //index of max
//				if(left>right)
//				{
//					max=leftChild(i);				
//				}
//				else
//				{
//					max=rightChild(i);
//				}
//				
//				int temp=heap[max];
//				heap[max]=heap[i];
//				heap[i]=temp;
//				
//				i=(i-1)/2;
//			}
//			
//			else
//			{
//				break;
//			}
//		}
//	}

	public static void main(String[] args) {
		
//		int heap[]=new int[7];
//		insert(heap,10);
//		insert(heap,2);
//		insert(heap,3);
//		insert(heap,4);
//		insert(heap,5);
//		insert(heap,6);
//		insert(heap,17);
		
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
//		System.out.println(extractMax(heap));
//		print(heap);
		
		MaxHeap maxheap = new MaxHeap(15);
		
		maxheap.insert(5);
		maxheap.insert(3);
		maxheap.insert(17);
		maxheap.insert(10);
		maxheap.insert(84);
		maxheap.insert(19);
		maxheap.insert(6);
		maxheap.insert(22);
		maxheap.insert(9);
		
		maxheap.print();
		
		System.out.println(maxheap.extractMax());
		
	}

}
