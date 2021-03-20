package linkedList;

public class LLintersection {
	
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
	
	static LNode intersection(LNode head1,LNode head2)
	{
		int l1=length(head1);

		int l2=length(head2);

		int l=Math.abs(l1-l2);

		
		LNode temp1,temp2;
		if(l1>l2)                // conditions to make sure that longer list is in temp1
		{
			temp1=head1;
			temp2=head2;
		}
		else
		{
			temp1=head2;
			temp2=head1;
		}
		for(int i=0;i<l;i++)
		{
			temp1=temp1.next;

		}

		while(temp1!=temp2)
		{
			temp1=temp1.next;
			temp2=temp2.next;
			
		}
		
		return temp1;
	}

	public static void main(String[] args) {
		LNode head1=new LNode(3);
		head1.next=new LNode(6);
		head1.next.next=new LNode(9);
		head1.next.next.next=new LNode(15);
		head1.next.next.next.next=new LNode(30);
		
		
		LNode head2=new LNode(10);
		head2.next=head1.next.next.next;
		head2.next.next=head1.next.next.next.next;
//		head1.next.next.next=new LNode(15);
//		head1.next.next.next.next=new LNode(30);
		
		
		LNode inter=intersection(head1,head2);
		System.out.println(inter.data);

	}

}


//Another Methods:
// 1. Merging two lists and than checking for the loop
//     In this method the intersecting nodes will seem two different nodes, but they are same.
//     So, merging them will create a cycle
//	2. Using Stack
//	3. Using Hashset
//	4. Converting into CLL
//	Many others
//	REFER GFG
