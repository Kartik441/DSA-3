package linkedList;

class Fnode
{
	int data;
	Fnode right, down;
	
	Fnode(int data)
	{
		this.data = data;
		right = null;
		down = null;
	}

}

public class FlattenLinkedList {
	
	
	static Fnode flatten(Fnode root)
	{
		if(root == null || root.right == null)
			return root;
		
		root.right = flatten(root.right);
		
		root = merge(root, root.right);
		
		return root;
	}
	// This iterative version of merge is not working now
	static Fnode mergeIt(Fnode node1, Fnode node2)
	{
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		
		Fnode ans = new Fnode(-1);
		Fnode dummy = ans;
		while(node1 != null && node2!= null)
		{
			if(node1.data < node2.data)
			{
				ans.down = node1;
				node1 = node1.down;
				
			}
			else
			{
				ans.down = node2;
				node2 = node2.down;
				
			}
			ans = ans.down;
		}
		if(node1 != null)
			ans = node1;
		else
			ans = node2;
		
		dummy.down.right = null;     // Very important line
		
		return dummy.down;
	}
	
	static Fnode merge(Fnode root1, Fnode root2)
	{
		if(root1 == null)
			return root2;
		
		if(root2 == null)
			return root1;
		
		Fnode result;
		if(root1.data < root2.data)
		{
			result = root1;
			result.down = merge(root1.down, root2);
		}
		
		else
		{
			result = root2;
			result.down = merge(root1, root2.down);
		}
		
		result.right = null;
		return result;
	}
	
	static void printList(Fnode head)
	{
		while(head!= null)
		{
			System.out.print(head.data + " ");
			head = head.down;
		}
	}

	public static void main(String[] args) {
		Fnode head = new Fnode(5);
		head.right = new Fnode(10);
		head.right.right = new Fnode(19);
		head.right.right.right = new Fnode(28);
		
		
		Fnode l1 = new Fnode(7);
		l1.down = new Fnode(8);
		l1.down.down = new Fnode(30);
		
		Fnode l2 = new Fnode(20);
		
		Fnode l3 = new Fnode(22);
		l3.down = new Fnode(50);
		
		Fnode l4 = new Fnode(35);
		l4.down = new Fnode(40);
		l4.down.down = new Fnode(45);
		
		head.down = l1;
		head.right.down = l2;
		head.right.right.down = l3;
		head.right.right.right.down = l4;
		
		flatten(head);
		
		printList(head);

	}

}


