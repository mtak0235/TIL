package collection.set.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetOperationsTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));
        HashSet<Integer> sum = new HashSet<>(set1);
        HashSet<Integer> common = new HashSet<>();
        HashSet<Integer> diff = new HashSet<>(set1);
        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            sum.add(next);
            diff.remove(next);
            if (set1.contains(next)) {
                common.add(next);
            }
        }
        System.out.println("차집합 = " + diff);
        System.out.println("교집합 = " + common);
        System.out.println("합집합 = " + sum);

        HashSet<Integer> union = new HashSet<>(set1);
        HashSet<Integer> intersection = new HashSet<>(set1);
        HashSet<Integer> difference = new HashSet<>(set1);
        union.addAll(set2);
        intersection.retainAll(set2);
        difference.removeAll(set2);

    }
}
