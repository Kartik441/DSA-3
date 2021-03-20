package linkedList;
// a variation could be to move the last m elements to the front of the list
public class NodeFromEnd {
	
	static LNode nodeFromEnd(LinkedList list,int n)
	{
		LNode i ,j;
		i=list.head;
		j=list.head;
		for(int k=0;k<n-1;k++)            // the loop must run (n-1) time
		{
			j=j.next;
		}
		
		while(j.next!=null)
		{
			i=i.next;
			j=j.next;
		}
		System.out.println(i.data);
		return i;
		
	}

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		
		for(int i=1;i<=10;i++)
		{
			list.insert(i);
		}
		
		LinkedList.printList(list.head);
		
		nodeFromEnd(list,3);

	}

}
