package standards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.IntStream.rangeClosed;

public class Fibonacci {

    /**
     * Recursive
     */
    public  int fibR(int n) {
        return n <= 1 ? n : fibR(n - 1) + fibR(n - 2);
    }



    /**
     * Dynamic top down - memoized
     */
    private Map<Integer, Integer> lookup = new HashMap<>();

    public int fibM(int n) {
        return lookup.computeIfAbsent(n, m -> m <= 1 ? m : fibM(m - 1) + fibM(m - 2));
    }


    /**
     * Dynamic bottom up - tabulated
     */
    public int fibT(int n) {
        List<Integer> lookup = new ArrayList<>();
        lookup.add(0);
        lookup.add(1);

        rangeClosed(2, n).forEach(i -> lookup.add(lookup.get(i-1) + lookup.get(i-2)));

        return lookup.get(n);
    }


//    public static void main(String[] args) {
//
//        int n = 43;
//
//        System.err.println(fibM(n));
//        System.err.println(fibT(n));
//        System.err.println(fibR(n));
//    }
}
