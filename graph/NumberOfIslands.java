package graph;

public class NumberOfIslands {
	// 1 represents land, 0 represents water
	// TC: we are visiting each element at most 5 times (1 while visiting and 4 other ways)
	//   : O(5mn) => o(mn)
	
	
	// we can use visited array to mark coordinates which are visited but that will cost extra
	// space of O(mn)
	// if we are allowed to modify the matrix than we can change the visited values to 2 which
	// will not consume any extra space
	
	static void totalIslands(int grid[][])
	{
		int n = grid.length;
		int m = grid[0].length;
		int islands = 0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(grid[i][j] == 1)
				{
					solve(grid, i, j);
					islands++;
				}
				
			}
		}
		System.out.println(islands);
	}
	
	
	static void solve(int grid[][], int i, int j)
	{
		if( i < 0 || j < 0 || i>= grid.length || j>=grid[0].length)
			return;
		
		if(grid[i][j] == 0)
			return;
		
		if(grid[i][j] == 2)
			return;
		
		if(grid[i][j] == 1)
		{
			grid[i][j] = 2;
			solve(grid, i+1, j);
			solve(grid, i-1, j);
			solve(grid, i, j+1);
			solve(grid, i, j-1);
		}
			
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {
				{1, 1, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 1, 1}
				
		};
		totalIslands(grid);

		
		
		int grid1[][] = {
				{1, 1, 1, 1},
				{1, 0, 0, 1},
				{1, 0, 0, 0},
				
		};
		totalIslands(grid1);

		
		int grid2[][] = {
				{1, 1, 0, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0},
				
				
		};
		totalIslands(grid2);
	

	}

}
