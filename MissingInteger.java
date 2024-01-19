/*

This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].


*/
// you can also use imports, for example:
import java.util.*;


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int minPositive = 0;
        int i=0;
        boolean firstNonZero = true;
        for(;i<A.length-1;i++){
            if(A[i] <= 0) 
                continue;
            if(firstNonZero) {
                if(A[i] > 1) {
                    minPositive = 1;
                    break;
                }
                firstNonZero = false;
            } 
            if((A[i + 1] - A[i]) > 1) {
                minPositive = A[i] + 1;
                break;
            }
        }
        if(minPositive == 0) {
            if(A[A.length-1] < 0) {
                minPositive = 1;
            } else {
                minPositive = A[A.length-1] + 1;
            }
        }
        return minPositive;
    }
}
