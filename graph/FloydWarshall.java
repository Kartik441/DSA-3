package graph;

public class FloydWarshall {
	
	static void solve(int graph[][])
	{
		int v = graph.length;
		int dis[][] = new int[v][v];   // matrix to store closest distance
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				dis[i][j] = graph[i][j];
			}
		}
		
		for(int k=0;k<v;k++)
		{
			for(int i=0;i<v;i++)
			{
				for(int j=0;j<v;j++)
				{
					// distance from i to j via vertex k
					if(dis[i][k] + dis[k][j] < dis[i][j])
						dis[i][j] = dis[i][k] + dis[k][j];
				}
			}
		}
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.print(dis[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
	

	}

}
