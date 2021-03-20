package heap;

public class MergeTwoBinaryMaxHeap {
	// idea is simply to add the element in result array and rebuild heap from scratch
	// TC : O(m+n)
	static int[] mergeHeap( int a[], int b[])
	{
		int merge[] = new int[a.length + b.length];
		int n = a.length;
		int m = b.length;
		
		for(int i=0;i<n;i++)
		{
			merge[i] = a[i];
		}
		for(int i=0;i<m;i++)
		{
			merge[n+i] = b[i];
		}
		int size = n+m;
		// starting from first node that has its child node to 1st node
		for(int i=(size/2) - 1;i>=0;i--)  
		{
			maxHeapify(merge, size, i);
		}
		
		return merge;

	}
	
	// standard maxHeapify function
	static void maxHeapify(int arr[], int n, int i)
	{
		if(i >= n)
			return;
		
		int left = i*2 + 1;
		int right = i*2 + 2;
		
		int max;
		if(left < n && arr[left] > arr[i])
			max = left;
		else
			max = i;
		
		if(right < n && arr[right] > arr[max])
			max = right;
		
		// put max value at the root and recur for the child with maximum value
		if(max != i)
		{
			int temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			
			maxHeapify(arr, n, max);
		}
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	// same approach can be used to convert minheap to maxheap
	// just build maxheap from scratch using input array
	
	static void  minTomax(int a[])
	{
		int size = a.length;
		for(int i=(size/2) - 1; i>=0;i--)
		{
			maxHeapify(a, size, i);
		}
	}

	public static void main(String[] args) {
		int a[] = {10, 5, 6, 2};
		int b[] = {12, 7, 9};
		int heap[] = mergeHeap(a, b);
		for(int i=0;i<heap.length;i++)
		{
			System.out.print(heap[i]+" ");
		}
		System.out.println();
		
		int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
		minTomax(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		
		}

	}


