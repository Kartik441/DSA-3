package graph;
// it is a dp approach
// it will not work for a graph with negative weight cycle
// TC: O(e*(v-1))
// For complete graph: O(N*N*(N)
public class BellmanFord {
	
	static void bellman(int g[][], int v, int e, int src) // here g contains edges
	{
		 //graph has edges in the form(U, V, W)  // edge is from u to v with w weight
		int dist[] = new int[v];
		// initializing distance as infinity
		for(int i=0;i<v;i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[src] = 0;
		// relax all edges v-1 times, A simple shortest path from source to any other 
		// vertex can have at most v - 1 edges
		for(int i=0;i<v-1;i++)
		{
			for(int j=0;j<e;j++)
			{
				if(dist[g[j][0]] != Integer.MAX_VALUE && dist[g[j][0]]
						+ g[j][2] < dist[g[j][1]])
				{
					dist[g[j][1]] = dist[g[j][0]] + g[j][2];
				}
			}
		}
		
		// checking for negative weight cycle
		for(int i=0;i<e;i++)
		{
			int x = g[i][0];
			int y = g[i][1];
			int weight = g[i][2];
			if(dist[x] != Integer.MAX_VALUE && dist[x] + weight < dist[y])
			{
				System.out.println("Negative weight cycle present");
				break;
			}
		}
		for(int i=0;i<v;i++)
		{
			System.out.println(i+"\t\t"+dist[i]);
		}
	}

	public static void main(String[] args) {
		int v = 5;
		int e = 8;
		int graph[][] = {
			  
				{0, 1, -1},
				{0, 2, 4},
				{1, 2 , 3},
				{1, 3, 2},
				{1, 4, 2},
				{3, 2, 5},
				{3, 1, 1},
				{4, 3, -3}
		};
		bellman(graph, v, e, 0);

	}

}
