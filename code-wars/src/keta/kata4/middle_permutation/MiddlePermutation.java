package middle_permutation;

import java.util.ArrayList;
import java.util.List;

class MiddlePermutation {

    static List<String> list = new ArrayList<>();

    public static String findMidPerm(String strng) {
        printStringPermutations("", strng);
        list.sort(String::compareTo);
        int s = list.size()% 2 ==0 ? 1 : 0;
        return list.get((list.size()/2)-s);
    }

    private static void printStringPermutations(String prefix, String remaining) {
        int n = remaining.length();
        if (n == 0) {
            list.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                printStringPermutations(newPrefix, newRemaining);
            }
        }
    }
}