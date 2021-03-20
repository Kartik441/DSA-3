package graph;

public class TravellingSalesmanProblem {
	
	static void tsp(int [][]graph)
	{
		int n = graph.length;
		
		boolean[] vis = new boolean[n];
		vis[0] = true;
		int ans = Integer.MAX_VALUE;
		ans = dfs(graph, vis, 0,n, 1, 0, ans);
		System.out.println(ans);
	}
	
	static int dfs(int [][]graph, boolean vis[], int curr, int n, int count, int cost, int ans)
	{
		
		if(count == n && graph[curr][0] > 0)
		{
			ans = Math.min(ans, cost+graph[curr][0]);
			return ans;
		}
		
		for(int i=0;i<n;i++)
		{
			if(vis[i] == false && graph[curr][i] > 0)
			{
				vis[i] = true;
				ans = dfs(graph, vis, i, n, count+1, cost+graph[curr][i], ans);
				
				vis[i] = false;  // IMP: backtracking
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int [][]g  = {
				{0, 10, 15, 20},
				{10, 0, 35, 25},
				{15, 35, 0, 30},
				{20, 25, 0, 30}
		};
		tsp(g);
		

	}

}
