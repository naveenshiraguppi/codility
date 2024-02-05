/*
An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
*/

// you can also use imports, for example:
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(int[] A) {
        if(A.length == 0 || A.length == 2) {
            return -1;
        }
        else if(A.length == 1) {
            return 0;
        }
        
        // Implement your solution here
        final Map <Integer,Integer> countMap = new HashMap<>();     
        final Map <Integer,Integer> indexMap = new HashMap<>();        
   
        for(int i=0;i<A.length;i++) {
            if(countMap.containsKey(A[i]))
            {
                //System.out.println("i:" + i);
                countMap.put(A[i], (countMap.get(A[i]).intValue() + 1));
                indexMap.put(A[i], i);
            } else {
                countMap.put(A[i], 1);
                indexMap.put(A[i], i);
            }
        }
        Map.Entry<Integer,Integer> entry = countMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        if(entry.getValue() > A.length /2){
            return indexMap.get(entry.getKey());
        }
        return -1;
    }
}
