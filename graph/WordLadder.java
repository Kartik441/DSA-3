package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	
	static class Pair
	{
		String word;
		int len;
		Pair(String word,int len)
		{
			this.word = word;
			this.len = len;
		}
	}
	
	static void solve(String beginWord,String endWord, String[] dict)
	{
		if(beginWord.length() == 0 || endWord.length() == 0 || dict.length == 0)
		{
			System.out.println(0);
			return;
		}
		
		// use hashset to search in O(1) time
		HashSet<String> dic = new HashSet<>();
		for(int i=0;i<dict.length;i++)
		{
			dic.add(dict[i]);
		}
		// create a queue for bfs
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(beginWord, 1));
		while(!q.isEmpty())
		{
			Pair curr = q.poll();
			// using list iterator so that we can remove the word which is adjacent 
			Iterator<String> it = dic.iterator();
			while(it.hasNext())
			{
				String temp = it.next();
				if(isAdjacent(curr.word, temp))
				{
					if(temp.equals(endWord))
					{
						System.out.println(curr.len+1);
						return;
					}
					
					it.remove();
					q.add(new Pair(temp, curr.len+1));
					
				}
			}
			
		}
		
		System.out.println(0);
		
		
	}
	
	static boolean isAdjacent(String s1, String s2)
	{
		int n = s1.length();
		int count = 0;
		for(int i=0;i<n;i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				count++;
			}
			if(count > 1)
				return false;
		}
		
		return count == 1?true:false;
	}

	public static void main(String[] args) {
		String[] dict = {"hot", "dot", "dog", "lot", "log", "cog"};
		solve("hit", "cog", dict);
		
	}

}
