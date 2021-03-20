package greedy;
import java.util.*;

public class ActivitySelection {
	
	// here end time is sorted
	static void maxActivities(int s[], int e[])
	{
		System.out.println(s[0] +" "+ e[0]);
		int j=0;      // it will point to the last chosen activity 
		for(int i=1;i<s.length;i++)
		{
			if(s[i] > e[j])
			{
				// than this activity can be include
				System.out.println(s[i]+" "+e[i]);
				j = i;
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Maximum trains for which stoppage can be provided
//	We are given n-platform and two main running railway track for both direction. 
//	Trains which needs to stop at your station must occupy one platform for their stoppage and 
//	the trains which need not to stop at your station will run away through either of main track 
//	without stopping. Now, each train has three value first arrival time, second departure time and 
//	third required platform number. We are given m such trains you have to tell maximum number of
//	train for which you can provide stoppage at your station.
	
	static void maxStop(int start[], int dept[], int plat[])
	{
		// here trains has to be sorted as per departure time. If not sorted  than sort explicitly.
		int n = start.length;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int p = 2; // no of platform
		
		
		
	}

	public static void main(String[] args) {
		
		int s[] =  {1, 3, 0, 5, 8, 5}; 
	    int f[] =  {2, 4, 6, 7, 9, 9}; 
	    maxActivities(s, f);

	}

}
