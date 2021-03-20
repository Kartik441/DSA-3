package linkedList;

public class MergeLL {
	
	static LNode merge(LNode l1, LNode l2)
	{
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		LNode ans = new LNode(-1);
		LNode head = ans;
		
		while(l1 != null && l2 != null)
		{
			
			if(l1.data < l2.data)
			{
				ans.next = l1;
				l1 = l1.next;
			}
			else
			{
				ans.next = l2;
				l2 = l2.next;
			}
			
			ans = ans.next;
			 if(ans == ans.next)
			    {
			    	System.out.println(ans.data);
			    	break;
			    }
		}
		System.out.println("Broke Out");
	
		if(l1!=null )
		{
			ans.next = l1;
		}
		else
		{
			ans.next = l2;
		}
		
		return head.next;
	}
	
	public static void printList(LNode head)
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			LNode temp=head;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
			    temp=temp.next;
			    if(temp == temp.next)
			    {
			    	System.out.println(temp.data);
			    	break;
			    }
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
LinkedList list1=new LinkedList();
		
		list1.insert(3);
		list1.insert(5);
	    list1.insert(6);
		
LinkedList list2=new LinkedList();
		
		list2.insert(2);
		list2.insert(4);
	    list2.insert(8);
		
		LNode head1=new LNode(3);
		head1.next=new LNode(6);
		head1.next.next=new LNode(9);
		head1.next.next.next=new LNode(15);
		head1.next.next.next.next=new LNode(30);
		
		
		LNode head2=new LNode(10);
		head2.next=head1.next.next.next;
		head2.next.next=head1.next.next.next.next;
	    
	    printList(merge(list1.head, list2.head));
	   // printList(merge(head1, head2));

	}

}
