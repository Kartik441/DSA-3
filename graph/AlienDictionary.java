package graph;

public class AlienDictionary {
	// it will not work if input is not valid
	static void solve(String []words, int n)
	{
		Graph g = new Graph(n);
		
		for(int i=0;i<words.length-1;i++)
		{
			String w1 = words[i];
			String w2 = words[i+1];
			
			int minLen = Math.min(w1.length(), w2.length());
			
			for(int j=0;j<minLen;j++)
			{
				if(w1.charAt(j) != w2.charAt(j))
				{
					g.addEdge(w1.charAt(j) - 'a', w2.charAt(j) - 'a');
					//System.out.println( i+" "+j);
					break;
				}
			}
		}
		TopologicalSort.sort(g);
	}

	public static void main(String[] args) {
		String words[]  = { "caa", "aaa", "aab"};
		solve(words, 3);
		
		String w1[] = {"aba", "bba", "aaa"};
		solve(w1, 2);
		

	}

}
