package greedy;

import java.util.Arrays;

public class CommonElementInMatrix {// row wise sorted matrix
	
	// idea is to get min element out of all the elements in the last column because other element
    // can't be the answer
	
	static int solve(int mat[][])
	{
		int r = mat.length;
		int c = mat[0].length;
		int cp[] = new int[r];        // column pointer
		Arrays.fill(cp, c-1);
		
		// finding min index
		int min_row = 0;        // index for min element
		
		
		while(cp[min_row] >= 0)
		{
			for(int i=0;i<r;i++)
			{
				if(mat[i][cp[i]] < mat[min_row][cp[min_row]])
					min_row = i;
			}
			int eqCount = 0;      // how many elements are equal for one round
			for(int i=0;i<r;i++)
			{
				if(mat[i][cp[i]] > mat[min_row][cp[min_row]])
				{
					cp[i] = cp[i] - 1;
					if(cp[i] == -1)
						return -1;
				}
				else
					eqCount++;
		
			}
			if(eqCount == r)
				return mat[min_row][cp[min_row]];
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int mat[][] = {
				{1, 2, 3, 4, 5},
				{2, 4, 5, 8, 10},
				{3, 5, 7, 9, 11},
				{1, 3, 5, 7, 9}
		};
		int mat1[][] = {
				{1, 2, 3, 4, 5, 9},
				{2, 4, 5, 8, 10, 45},
				{1, 2, 6, 7, 9, 9},
				{2, 3, 5, 7, 9, 9}
		};
		System.out.println(solve(mat));
		System.out.println(solve(mat1));

	}

}
