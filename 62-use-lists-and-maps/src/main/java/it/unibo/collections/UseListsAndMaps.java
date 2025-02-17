package it.unibo.collections;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final int START_INCLUDED = 1000;
        final int END_EXCLUDED = 2000;
        List<Integer> ali = new ArrayList<>();
        for (int i = START_INCLUDED; i < END_EXCLUDED; i++) {
            ali.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> lli = new LinkedList<>(ali);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp;
        tmp = ali.get(0);
        ali.set(0, ali.size() - 1);
        ali.set(ali.size() - 1, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : ali) {
            System.out.println(integer);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            ali.addFirst(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Inserting "
                        + ali.size()
                        + " ints in a ArrayList took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            lli.addFirst(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Inserting "
                        + lli.size()
                        + " ints in a LinkedList took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");
        /*
         * Prepare a variable for measuring time
         */

        /*
         * Run the benchmark
         */

        /*
         * Compute the time and print result
         */

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            ali.get(ali.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Reading "
                        + 1000
                        + " ints in a ArrayList took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {

            lli.get(lli.size() / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Reading "
                        + 1000
                        + " ints in a LinkedList took "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> world = new HashMap<>();
        world.put("Africa", 111063500l);
        world.put("Americas", 972005000l);
        world.put("Asia", 4298723000l);
        world.put("Antartica", 0l);
        world.put("Europe", 742452000l);
        world.put("Oceania", 38304000l);
        /*
         * 8) Compute the population of the world
         */
        System.out.println("\nContinents Population");
        for (Map.Entry<String, Long> e : world.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue() + " people");
        }
    }
}
