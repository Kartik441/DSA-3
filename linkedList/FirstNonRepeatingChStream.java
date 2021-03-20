package linkedList;

import java.util.ArrayList;
import java.util.List;

// first non repeating character in a stream of running characters
// can be solved using DLL and queue
// DLL solution below
public class FirstNonRepeatingChStream {
	
	static void solve(String s)
	{
		List<Character> DLL = new ArrayList<>();
		boolean []repeated = new boolean[256];
		
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			
			if(repeated[c] == false)     //if till now it only appeared < 2 times
			{
				// if ch is not in DLL OR appearing for first time
				if(!DLL.contains(c))
					DLL.add(c);
				else // it is second occurence of c
				{
					// could have used hash to remove by storing address of each node
					DLL.remove((Character)c);     // IMP
					repeated[c] = true;
				}

					
			}
			// print first non repeating character
			if(DLL.size()!=0)
				System.out.println(DLL.get(0));
			else
				System.out.println(-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve("geeksforgeeksandgeeksquizfor");

	}

}
