/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
*/
// you can also use imports, for example:
import java.util.*;
import java.util.stream.Collectors;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        long sum = 0;
///////////// to handle large integer multiplications resulting in overflows
        if(A.length % 2 == 0) {
            sum = ((A.length + 2) / 2) * (A.length + 1);
        } else {
            sum = (A.length + 2) * ((A.length + 1)/2);
        }
        
        long totalSum = 0;
        for(int i: A) {
            totalSum +=i;
        }
        return (int)(sum-totalSum);
    }
}
