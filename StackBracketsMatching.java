// you can also use imports, for example:
// import java.util.*;
import java.util.Stack;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        Stack<Character> s = new Stack<>();
		for(char c: S.toCharArray()) {
			if(c == '{' || c== '(' || c== '[') {
				s.push(c);
			} else {
				char p = '$';
				if(!s.isEmpty()) {
					p = s.peek();
				}
				if((c== ')' &&  p != '(') || (c== '}' &&  p != '{') || (c== ']' &&  p != '['))  {
					return 0;
				} else {
					s.pop();
				}
			}
		}
		return (s.isEmpty()?1:0);
    }
}
