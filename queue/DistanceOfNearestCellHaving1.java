package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// given a binary matrix, for each element fill the value of the distance of nearest 1
// distance is |(i1 - i2) + (j1 - j2)|

public class DistanceOfNearestCellHaving1 {
	
	static class Pair
	{
		int i;
		int j;
		Pair(int i, int j)
		{
			this.i = i;
			this.j = j;
		}
	}
	
	static void solve(int mat[][])
	{
		int r = mat.length;
		int c = mat[0].length;
		
		int sol[][] = new int[r][c];
		
		Queue<Pair> q = new LinkedList<>();
		
		for(int a[]:sol)
			Arrays.fill(a, -1);
		
	
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(mat[i][j] == 1)
				{
					q.add(new Pair(i, j));
					sol[i][j] = 0;
				}
				
			}
		}
		
		q.add(null);
		
		int dist = 1;
		
		while(!q.isEmpty())
		{
			Pair p =q.poll();
			if(p == null)
			{
				if(q.peek() == null)
					break;
				else
					q.add(null);
				
				dist++;
				continue;
			}
		
			int i = p.i;
			int j = p.j;
			
			proc(mat, sol,q, i-1 , j, dist);
			proc(mat, sol,q, i , j+1, dist);
			proc(mat, sol,q, i+1 , j, dist);
			proc(mat, sol,q, i , j-1, dist);
			
		}
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void proc(int mat[][], int sol[][], Queue<Pair> q, int i, int j, int dist )
	{
		if(!isValid(i, j, sol.length, sol[0].length, sol))
			return;
		
		sol[i][j] = dist;
		q.add(new Pair(i, j));		

	}
	
	static boolean isValid(int i,int j,int r, int c, int sol[][])
	{
		if(i < 0 || i >= r || j <0|| j>=c || sol[i][j] != -1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		int mat[][] = {
				{0, 0, 0, 1},
				{0, 0, 1, 1},
				{0, 1, 1, 0}
		};
		solve(mat);
		
		int mat1[][] = {
				{1, 0, 0},
				{0, 0, 1},
				{0, 1, 1}
		};
		solve(mat1);
		
		

	}

}
