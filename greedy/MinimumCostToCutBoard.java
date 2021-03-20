package greedy;

import java.util.Arrays;
import java.util.Collections;

//A board of length m and width n is given, we need to break this board into m*n squares
//such that cost of breaking is minimum. cutting cost for each edge will be given for the board.
// In short we need to choose such a sequence of cutting such that cost is minimized.

//Total_cost = Total_cost + edge_cost * total_pieces
public class MinimumCostToCutBoard {
	
	// edge cost is constant, so to minimize the cost we must reduce the total pieces multiplied
	// by larger edge cost value
	// to do that we perform cuts on high cost edges as early as possible
	// if more than one edge have same cost than we can choose any one of them
	
	// method returns minimum cost to break board into 
    // m*n squares 
    static int minimumCostOfBreaking(Integer X[], Integer Y[],  
                                                 int m, int n) 
    { 
        int res = 0; 
      
        // sort the horizontal cost in reverse order 
        Arrays.sort(X, Collections.reverseOrder()); 
      
        // sort the vertical cost in reverse order 
        Arrays.sort(Y, Collections.reverseOrder()); 
      
        // initialize current width as 1 
        int hzntl = 1, vert = 1; 
      
        // loop untill one or both 
        // cost array are processed 
        int i = 0, j = 0; 
        while (i < m && j < n) 
        { 
            if (X[i] > Y[j]) 
            { 
                res += X[i] * vert; 
      
                // increase current horizontal 
                // part count by 1 
                hzntl++; 
                i++; 
            } 
            else
            { 
                res += Y[j] * hzntl; 
                // increase current vertical  
                // part count by 1 
                vert++; 
                j++; 
            } 
        } 
      
        // loop for horizontal array,  
        // if remains 
        int total = 0; 
        while (i < m) 
            total += X[i++]; 
        res += total * vert; 
      
        // loop for vertical array,  
        // if remains 
        total = 0; 
        while (j < n) 
            total += Y[j++]; 
        res += total * hzntl; 
      
        return res; 
    } 

	public static void main(String[] args) {
//		 int m = 6, n = 4; 
//	        Integer X[] = {2, 1, 3, 1, 4}; 
//	        Integer Y[] = {4, 1, 2}; 
//	        System.out.print(minimumCostOfBreaking(X, Y, m-1, n-1)); 
//	        System.out.println();
		char X[] = { 'c', 'o', 'd', 'e', 'r'};
	        int i=0;
	        while(i<4)
	        {
	        	System.out.println(i);
	        	System.out.println(++X[i++]+" ");
	        	X[i]++;
	        	System.out.println(i);
	        }

	}

}
