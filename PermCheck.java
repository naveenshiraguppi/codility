// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        long sum = 0;
        for(int i=0;i<A.length;i++) {
            sum+=A[i];
        }
        int expectedSum = (int)(Long.valueOf(A.length + 1) * A.length / 2); 
        if (expectedSum == sum) {
            return 1;
        } else {
            return 0;
        }
    }
}
