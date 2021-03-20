package graph;
// clique is a subgraph of graph such that all vertices in subgraph are completely
// connected with each other or a subgraph which is a complete graph

// given a graph check if graph can be divided into two cliques

// IMPORTANT OBSERVATION:
//A graph can be divided into two cliques if it complement graph is bipartite

// in compliment of graph, all original edges are removed, and the vertices which do
// not have an edge between them, now have edge



public class TwoCliqueProblem {
	
	static void solve(int g[][])
	{
		int v = g.length;
		int cg[][] = new int[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(i!=j)
				{
					cg[i][j] = 1 - g[i][j];
				}
			}
		}
//		if(isBipartite(cg))
//			System.out.println("yes");
//		else
//			System.out.println("false");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
