package linkedList;

public class Add {
	
// for storing the answer
static LNode head=null;

// For finding length of linked list
static int length(LNode head)
{
	if(head==null)
		return 0;
	else
	{
		LNode temp=head;
		int l=0;
		while(temp!=null)
		{
			temp=temp.next;
			l++;
		}
		return l;
	}
	
}


static LNode add(LNode head1,LNode head2)
{
	
	int l1=length(head1);
	int l2=length(head2);
	// if lengths are equal than add simply by recursion
	if(l1 == l2)
	{
		int carry=addMain(head1,head2);
		if(carry!=0)
			push(carry);
		return head;
	}
	// if lengths are not equal
	else {
		// for preserving head of list1 for future use
		LNode backup = head1;
		int l = l1-l2;
		LNode prev = null;
		if(l>0)
		{
			// means l1 is longer
			for(int i=0;i<l;i++)
			{
				prev = head1;
				head1 = head1.next;
			}
		}
		else
		{
			// means l2 is longer
			 l = l*-1;              // making l positive
			 for(int i=0;i<l;i++)
			{
				prev = head2;
				head2 = head2.next;
			}
		}
		
		int carry = addMain(head1, head2);
		
		// now simply add carry to the list till prev using addCarry function
		if(carry!=0)
		{
			carry = addCarry(backup, carry, prev);
			if(carry!=0)
				push(carry);
			return head;
		}
		return head;
		
			
	}
		
}

    static int addCarry(LNode head1, int carry, LNode lastNode)
    {
    	if(head1 == lastNode)
    	{
    		int sum = lastNode.data + carry; 
    		carry = sum/10;
    		sum = sum%10;
    		push(sum);
    		return carry;
    	}
  
    	carry = addCarry(head1.next, carry, lastNode);
    	int sum = head1.data + carry;
    	carry = sum/10;
		sum = sum%10;
		push(sum);
		return carry;
    	
    }
	
	static int addMain(LNode head1,LNode head2)
	{
		if(head1==null)
			return 0;
		else
		{			
			LNode temp1=head1;
			LNode temp2=head2;
			int carry=addMain(temp1.next,temp2.next);
			int sum=temp1.data+temp2.data+carry;
		    carry=sum/10;
			sum=sum%10;
			push(sum);
			return carry;
		}	
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
			}
		}
		System.out.println();
	}
	// push adds data to front of list
	public static void push(int data)
	{
       
		LNode n=new LNode(data);
		if(head==null)
		{
			head=n;
		}
		else {
			n.next=head;
			head=n;
		}
		
	}

	public static void main(String[] args) {
LinkedList list1=new LinkedList();
		
		list1.insert(5);
		list1.insert(6);
	    list1.insert(3);
		
LinkedList list2=new LinkedList();
		
		list2.insert(8);
		list2.insert(4);
	    list2.insert(2);
	    
	LNode n=add(list1.head,list2.head);
	printList(list1.head);
	printList(list2.head);
	printList(n);
	
	head = null;

	LinkedList list3=new LinkedList();
	
	list3.insert(9);
	list3.insert(9);
    list3.insert(6);
    list3.insert(3);
	
LinkedList list4=new LinkedList();
	
	list4.insert(4);
    list4.insert(2);
    
    printList(list3.head);
	printList(list4.head);
    
    LNode n1=add(list3.head,list4.head);
	
	printList(n1);
	}

}

//2463
// +42
//2505

//2963
// +42
//3006