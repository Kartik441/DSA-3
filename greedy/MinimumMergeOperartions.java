package greedy;
// find min merge operations required to make an array palindrome
// only positive integers are allowed in array
public class MinimumMergeOperartions {

	static void solve(int a[])
	{
		int n = a.length;
		int i=0;
		int j = n-1;
		int count = 0;
		while(i<j)
		{
			if(a[i] == a[j])
			{
				i++;
				j--;
			}
			else
			{
				// do merging
				if(a[i] > a[j])
				{
					// merge j with adjacent
					a[j-1] = a[j-1] + a[j];
					j--;
					count++;
				}
				else
				{
					a[i+1] = a[i+1] + a[i];
					i++;
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	public static void main(String[] args) {
		int a[] = {15, 4, 15};
		solve(a);
		
		int a1[] = {1, 4, 5, 1};
		solve(a1);
		
		int a2[] = {11, 14, 15, 99};
		solve(a2);

	}

}
