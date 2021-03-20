package greedy;
//Given an array, we need to find the maximum sum of absolute difference of any permutation
//of the given array.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input : { 1, 2, 4, 8 }
//Output : 18
//Explanation : For the given array there are 
//several sequence possible
//like : {2, 1, 4, 8}
//       {4, 2, 1, 8} and some more.
//Now, the absolute difference of an array sequence will be
//like for this array sequence {1, 2, 4, 8}, the absolute
//difference sum is 
//= |1-2| + |2-4| + |4-8| + |8-1|
//= 14
//For the given array, we get the maximum value for
//the sequence {1, 8, 2, 4}
//= |1-8| + |8-2| + |2-4| + |4-1|
//= 18
public class MaxSumofAbsDiff {
//	To get the maximum sum, we should have a sequence in which small and large elements
//	comes alternate. This is done to get maximum difference.
	
	static int MaxSumDifference(Integer []a, int n) 
    { 
          
        // final sequence stored in the vector 
        List<Integer> finalSequence =  
                        new ArrayList<Integer>(); 
      
        // sort the original array 
        // so that we can retrieve 
        // the large elements from 
        // the end of array elements 
        Arrays.sort(a); 
      
        // In this loop first we will insert 
        // one smallest element not entered 
        // till that time in final sequence 
        // and then enter a highest element 
        // (not entered till that time) in 
        // final sequence so that we 
        // have large difference value. This 
        // process is repeated till all array 
        // has completely entered in sequence. 
        // Here, we have loop till n/2 because 
        // we are inserting two elements at a 
        // time in loop. 
        for (int i = 0; i < n / 2; ++i) { 
            finalSequence.add(a[i]); 
            finalSequence.add(a[n - i - 1]); 
        } 
  
        // If there are odd elements, push the 
        // middle element at the end. 
        if (n % 2 != 0) 
            finalSequence.add(a[n/2]); 
  
        // variable to store the 
        // maximum sum of absolute 
        // difference 
        int MaximumSum = 0; 
      
        // In this loop absolute difference 
        // of elements for the final sequence 
        // is calculated. 
        for (int i = 0; i < n - 1; ++i) { 
            MaximumSum = MaximumSum + 
                  Math.abs(finalSequence.get(i)  
                   - finalSequence.get(i + 1)); 
        } 
      
        // absolute difference of last element 
        // and 1st element 
        MaximumSum = MaximumSum + 
              Math.abs(finalSequence.get(n - 1) 
                       - finalSequence.get(0)); 
      
        // return the value 
        return MaximumSum; 
    } 

	public static void main(String[] args) {
		 Integer []a = { 1, 2, 4, 8 }; 
	        int n = a.length; 
	      
	        System.out.print(MaxSumDifference(a, n)); 

	}

}
