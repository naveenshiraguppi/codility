/*
Task description
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
*/

// you can also use imports, for example:
// import java.util.*;
import java.util.HashMap;
import java.util.Map;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    private static final Integer MIN = Integer.MIN_VALUE;
	public int solution(int[] A) {
		int count = 0;
		int firstEquiLeader = MIN;
		int secondEquiLeader = MIN;
		for(int i=0;i<A.length-1;i++) {
			firstEquiLeader = equiLeader(A, 0, i);
			secondEquiLeader = equiLeader(A, i+1, A.length - 1);
			//System.out.println("i: " + i + " firstEquiLeader: " + firstEquiLeader + " secondEquiLeader:" + secondEquiLeader);
			if( firstEquiLeader!= MIN && firstEquiLeader == secondEquiLeader) {
				count++;
			}
		}
		return count;
	}
	private int equiLeader(int[] A, int i, int i2) {
			int len = i2-i;
	         if(len == 1) {
	        	if(A[i] == A[i+1]) {
	        		return A[i];
	        	} else {
	        		return MIN;
	        	}
	        }
	        else if(len == 0) {
	            return A[i];
	        }
	        
	        // Implement your solution here
	        final Map <Integer,Integer> countMap = new HashMap<>();     
	   
	        for(int j=i;j<i+len+1;j++) {
	            if(countMap.containsKey(A[j]))
	            {
	                //System.out.println("i:" + i);
	                countMap.put(A[j], (countMap.get(A[j]).intValue() + 1));
	            } else {
	                countMap.put(A[j], 1);
	            }
	        }
	        Map.Entry<Integer,Integer> entry = countMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
	        if(entry.getValue() > (len+1) /2){
	            return entry.getKey();
	        }
	        return MIN;
	    }
}
