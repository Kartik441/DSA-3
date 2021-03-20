package graph;

import java.util.LinkedList;

public class CountTriangleInGraph {
	// this will work for both directed and undirected graph
	static void solve(int[][] g, boolean isDirected)
	{
		int v = g.length;
		
		int count = 0;
		// consider every possible triplet of edge in graph
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				for(int k=0;k<v;k++)
				{
					// check the triplet if it satisfies the condition
					if(g[i][j] == 1 && g[j][k] == 1 && g[k][i] == 1)
						count++;
				}
			}
		}
		
		// it will consider every vertex in each triangle as the starting point for triangle
		// hence need to divide count by 3 in directed graph
		
		// for undirected graph it will also consider opposite directions
		// hence divide by 6 in undirected graph
		
		if(isDirected)
			count = count/3;
		else
			count = count/6;
		
		System.out.println(count);
		
	}
	
	// another method is there which can be extended to not only triangles but to polygon with
	// more sides as well
	
	// Prop: If we compute A^n for an adjacency matrix representation of graph, than
	// a value of A^n[i][j] represents number of distinct walks between vertex i to j
	// in a graph.
	// In A^3 we get all distinct paths of length 3 between every pair of vertices
	
	// so we just need to check if path of length 3 exists such that starting and destination
	// vertex is same 
	// since it is an undirected graph, we need to divide result by 6
	
	
	static int[][] multiply(int a[][], int b[][])
	{
		int c[][] = new int[a.length][a[0].length];
		int v = c.length;
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				c[i][j] = 0;
				for(int k=0;k<v;k++)
				{
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
		
	}
	
	static int getTrace(int g[][])
	{
		int trace  = 0;
		int v = g.length;
		for(int i=0;i<v;i++)
		{
			trace += g[i][i];
		}
		return trace;
	}
	
	static void countTriangles(int g[][])
	{
		int aux2[][] = multiply(g, g);
		int aux3[][] = multiply(g, aux2);
		
		int trace = getTrace(aux3);
		System.out.println(trace/6);
	}

	public static void main(String[] args) {
		int g[][] = {
				{0, 1, 1, 0},
				{1, 0, 1, 1},
				{1, 1, 0, 1},
				{0, 1, 1, 0}
		};
		
		solve(g, false);
		
		countTriangles(g);

	}

}
