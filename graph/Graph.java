package graph;

import java.util.LinkedList;

public class Graph {       // it is unweighted graph
	
	int v;  // vertices
	LinkedList<Integer> adj[];  //Adjacency List
	
	Graph(int v)
	{
		this.v = v;
		adj = new LinkedList[v];      // array of size v
		
		for(int i=0; i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
