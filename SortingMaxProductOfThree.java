// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
       for(int j=0;j<3;j++) {
			for(int i=0;i<A.length-j-1;i++) {
				if(A[i]> A[i+1]) {
					int temp = A[i];
					A[i]=A[i+1];
					A[i+1] = temp;
				}
			}
		}
		
		for(int j=0;j<2;j++) {
			for(int i=A.length-1;i>0+j;i--) {
				if(A[i] < A[i-1]) {
					int temp = A[i-1];
					A[i-1]=A[i];
					A[i] = temp;
				}
			}
		}
		long minmax = A[0] * A[1] * A[A.length-1];
		long maxmax = A[A.length-1]*A[A.length-2]*A[A.length-3];
		return (int)(minmax > maxmax? minmax:maxmax);
    }
}
