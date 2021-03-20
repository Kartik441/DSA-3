package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// something wrong
// look at it 

class Meeting
{
	int start;
	int end;
	int pos;
	Meeting(int start, int end, int pos)
	{
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}

class meetingComparator implements Comparator<Meeting>
{

	@Override
	public int compare(Meeting o1, Meeting o2) {
		if(o1.end < o2.end)
			return -1;
		else if(o1.end > o2.end)
			return 1;
		else if(o1.pos < o2.pos)
			return -1;
		return 1;
	}
	
	
}

public class NmeetingsInOneRoom {
	
	static void solve(int start[], int end[], int n)
	{
		ArrayList<Meeting> meet = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			meet.add(new Meeting(start[i], end[i], i+1));
		}
		
		meetingComparator mc = new meetingComparator();
		Collections.sort(meet, mc);
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(meet.get(0).pos);
		int limit = meet.get(0).end;
		
		for(int i=1;i<n;i++)
		{
			if(meet.get(i).start > limit)
			{
				limit = meet.get(i).end;
				ans.add(meet.get(i).pos);
			}
		}
		
		for(int i=0;i<ans.size();i++)
		{
			System.out.print(ans.get(i) +" ");
		}
	}

	public static void main(String[] args) {
		int start[] = {1, 0, 3, 8 ,5, 8};
		int end[] = {2, 6, 4, 2, 7, 9};
		solve(start, end, start.length);

	}

}
