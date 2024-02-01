// you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SortingDistinct {
    public int solution(int[] A) {
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
		return set.size();
    }
}
