 package linkedList;

public class isPalindrome {
	
	static boolean isListPalindrome(LinkedList list)
	{
		LNode head=list.head;
		LNode fast,slow,prevSlow;
		boolean iseven=true,isPalindrome=true;
		fast=slow=prevSlow=head;
		while(fast!=null&&fast.next!=null)
		{
			//System.out.println(fast.data);
			fast=fast.next.next;
			prevSlow=slow;
			slow=slow.next;
		}
		// if fast.next == null than odd, if fast == null than even
		if(fast==null)
			iseven=true;
		else
			iseven=false;
		// prevSlow is always going to be the end of first linked list
		if(iseven)
		{
			prevSlow.next=null;                      //slow is the head of second list
			
		}
		else
		{
			slow=slow.next;             // neglecting common node because of odd length list 
			prevSlow.next=null;
		}
		
		LinkedList list2=new LinkedList();
		list2.head=slow;
		ReverseLinkedList.reverse(list2);
		LNode temp1=list.head;
		LNode temp2=list2.head;
		
		LinkedList.printList(list.head);
		LinkedList.printList(list2.head);
		while(temp1!=null)
		{
			if(temp1.data!=temp2.data)
			{
				isPalindrome= false;
				break;
			}
			temp1=temp1.next;
			temp2=temp2.next;
		}
		
		return isPalindrome;
		
	}

	public static void main(String[] args) {
LinkedList list=new LinkedList();
		
		list.insert(1);
		list.insert(2);
	    list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		
		
		LinkedList.printList(list.head);
		
		System.out.println(isListPalindrome(list));

	}

}
