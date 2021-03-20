package graph;


import java.util.PriorityQueue;

// given an undirected graph
public class Kruskals {
	
	static class Edge implements Comparable<Edge>
	{
		int u;
		int v; 
		int w;
		
		public Edge(int u, int v, int w)
		{
			this.u = u;
			this.v = v;
			this.w = w;
			
		}

		@Override
		public int compareTo(Edge o) {
			
			return this.w - o.w;
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
	
	static void union(int a, int b, int rank[], int parent[])
	{
		// union by rank
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
	
	static void solve(int g[][])
	{
		int v = g.length;
		//  first create array of edges
		//ArrayList<Edge> list = new ArrayList<>();
		PriorityQueue<Edge> mh = new PriorityQueue<>();
		for(int i=0;i<v;i++)
		{
			for(int j=i;j<v;j++)
			{
				if(g[i][j] != 0)
					mh.add(new Edge(i, j, g[i][j]));
			}
		}
		int parent[] = new int[v];
		int rank[] = new int[v];
		for(int i=0;i<v;i++)
		{
			parent[i] = i;
			rank[i] = 0;
		}
		int mstw = 0;    // weight of mst
		
		int count = 0;
		while(count < v-1 && !mh.isEmpty())
		{
			Edge temp = mh.poll();
			//check if this edge creates a cycle
			if(find_set(temp.u, parent) == find_set(temp.v, parent)) // if they are in the same set
				continue;  // than no need to add edge as it will create a cycle
			
			// add the edge and do union
			System.out.println("Edge betweeen "+temp.u+" and "+temp.v+" of weight "+ temp.w);
			mstw += temp.w;
			count++;
			union(temp.u, temp.v, rank, parent);
			
		}
		if(count != v-1)
		{
			System.out.println("Graph is not connected");
		}
		else
			System.out.println("Total weight "+mstw);
		
		
	}

	public static void main(String[] args) {
		int g[][] = {
				// 0  1  2  3  4  5  6  7  8
		
				{  0, 4, 0, 0, 0, 0, 0, 8, 0},
				{  4, 0, 8, 0, 0, 0, 0, 11,0},
				{  0, 8, 0, 7, 0, 4, 0, 0, 2},
				{  0, 0, 7, 0, 9,14, 0, 0, 0},
				{  0, 0, 0, 9, 0,10, 0, 0, 0},
				{  0, 0, 4,14,10, 0, 2, 0, 0},
				{  0, 0, 0, 0, 0, 2, 0, 1, 6},
				{  8,11, 0, 0, 0, 0, 1, 0, 7},
				{  0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		
		solve(g);

	}

}
