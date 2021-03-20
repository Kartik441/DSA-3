package graph;

public class DisjointSet {
	
	int [] rank, parent;
	int n;
	
	// Construct
	public DisjointSet(int n)
	{
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}
	
	// create n sets with single items in each
	void makeSet()
	{
		for(int i=0;i<n;i++)
		{
			// all elements are in their own set
			parent[i] = i;
		}
	}
	
	// This method is naive
//	int find(int x)
//	{
//		// if an element is parent of itself than it is the parent of the set
//		if(parent[x] == x)
//		{
//			return x;
//		}
//		else
//		{
//			return find(parent[x]);
//		}
//	}
//	
	// optimized path compression for find operation
	int find(int x)
	{
		if(parent[x] == x)
			return x;
		
		return parent[x] = find(parent[x]);
	}
	// Union by rank
	void union(int x, int y)
	{
		// find representative of two elements 
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot)
			return;
		
		// if x's rank is less than y's rank
		if(rank[xRoot] < rank[yRoot])
			parent[xRoot] = yRoot;
		
		else if(rank[yRoot] <rank[xRoot])
			parent[yRoot] = xRoot;
		// if rank is same
		else
		{
			// than make y under x[doesn't really matter]
			parent[yRoot] = xRoot;
			// increase the rank of result tree's by one
			rank[xRoot] += 1;
		}
	}

	public static void main(String[] args) {
		
		DisjointSet dis = new DisjointSet(5);
		
		dis.union(0, 2);
		dis.union(4, 2);
		dis.union(3, 1);
		
		if(dis.find(4) == dis.find(0))
			System.out.println("Yes, they are friends");
		else
			System.out.println("No");
		

		
		
		

	}

}
