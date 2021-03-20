package linkedList;

public class ReverseInSets {
	
// recursive function
	static LNode reverseInSets(LNode head,int k)
	{
		LNode prev,current,next=null;
		prev=null;
		current=head;
		int count=1;
		while(count<=k&&current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		if(next!=null)
			head.next=reverseInSets(next,k);// // we can send current as well as next
		return prev;  
	}
	public static void main(String[] args) {
		
LinkedList list=new LinkedList();
		
		list.insert(1);
		list.insert(2);
	    list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		
		
		LinkedList.printList(list.head);
		
		list.head=reverseInSets(list.head,3);
		LinkedList.printList(list.head);
	}

}
