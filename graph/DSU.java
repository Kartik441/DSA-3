package graph;

// Disjoint set union
public class DSU {
	int parent[];
	int rank[];
	public DSU(int v)
	{
		parent = new int[v];
		rank = new int[v];     // how many child of Vi(same as height of tree)
		// initialization of parent array
		for(int i=0;i<v;i++)
		{
			parent[i] = i;
		}
		
		
	}
	
	
	// this can be optimized using rank
	static void unionSets(int u, int v, int parent[])
	{
		int setu = find_set(u, parent);
		int setv = find_set(v, parent);
		
		if(setu != setv)     // if not in the same set
		{
			parent[setv] = setu;
		}	
	}
	// union by rank
	// here we take a decision which tree gets attached
	static void union_rank(int a, int b, int rank[], int parent[])
	{
		a = find_set(a, parent);
		b = find_set(b, parent);
		
		if(a != b) // if not in the same set
		{
			if(rank[a] < rank[b])
			{
				parent[a] = b;
			}
			else             
				parent[b] = a;
			// if rank is same than else condition would have worked
			// hence a would be the parent of b and root of the set
			// so increase rank of a 
			if(rank[a] == rank[b])
				rank[a]++;
		}
	}
	
		
	static int find_set(int v, int parent[])
	{
		if(v == parent[v])
			return v;
		// optimization is done by storing the set element directly to reduce the height by creating
		// multiple childs
		// it is called path compression
		// after some queries it will be O(1)
		return parent[v] = find_set(parent[v], parent);
	}
	
	public void union(int a, int b)
	{
		union_rank(a, b, this.rank, this.parent);
	}
	
	public int findSet(int v)
	{
		return find_set(v, this.parent);
	}

	public static void main(String[] args) {
		
		

		
	}

}
