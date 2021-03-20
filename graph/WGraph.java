package graph;

import java.util.LinkedList;

// WGraph
 class Edge
{
	 int e;   // the connection between the vertex(connected to this vertex)
	 int w;    // with this weight
	 
	 Edge(int e, int w)
	 {
		 this.e = e;
		 this.w = w;
	 }
}

public class WGraph {     // for weighted graph
	
	
	int v;  // vertices
	LinkedList<Edge> adj[];  //Adjacency List
	
	WGraph(int v)
	{
		this.v = v;
		adj = new LinkedList[v];      // array of size v
		
		for(int i=0; i<v;i++)
			adj[i] = new LinkedList<Edge>();
	}
	
	void addEdge(int v, int e, int w)
	{
		adj[v].add(new Edge(e,w));
	}

	public static void main(String[] args) {
		

	}

}
