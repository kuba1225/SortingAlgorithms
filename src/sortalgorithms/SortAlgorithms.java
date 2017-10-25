package sortalgorithms;

import java.util.Random;

/**
 *
 * @author Kuba
 */
public class SortAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start, stop;
        HeapSort2 h2 = new HeapSort2();
        MergeSort ms = new MergeSort();
        MergeSort2 ms2 = new MergeSort2();
        QuickSort qs = new QuickSort();
        QuickSortIterative qsi = new QuickSortIterative();
        InsertSort is = new InsertSort();

        System.out.println("~~~~~~HEAPSORT~~~~~~");
        int[] vi0 = new int[10];
        generateRandomValues(vi0);
        System.out.println("Łańcuch przed posortowaniem: \t" + arrayToString(vi0));
        start = System.nanoTime();
        h2.sort(vi0);
        stop = System.nanoTime();
        System.out.println("Łańcuch po posortowaniu: \t" + arrayToString(vi0));
        check(vi0);
        System.out.println("Czas sortowania tablicy: " + (stop - start) + " ns");
        System.out.println();

        System.out.println("~~~~~~MERGESORT~~~~~~");
        int[] vi1 = new int[10];
        generateRandomValues(vi1);
        System.out.println("Łańcuch przed posortowaniem: \t" + arrayToString(vi1));
        start = System.nanoTime();
        ms.sort(vi1);
        stop = System.nanoTime();
        System.out.println("Łańcuch po posortowaniu: \t" + arrayToString(vi1));
        check(vi1);
        System.out.println("Czas sortowania tablicy: " + (stop - start) + " ns");
        System.out.println();

        System.out.println("~~~~~~MERGESORT2~~~~~~");
        int[] vi11 = new int[10];
        generateRandomValues(vi11);
        System.out.println("Łańcuch przed posortowaniem: \t" + arrayToString(vi11));
        start = System.nanoTime();
        ms2.sort(vi11);
        stop = System.nanoTime();
        System.out.println("Łańcuch po posortowaniu: \t" + arrayToString(vi11));
        check(vi11);
        System.out.println("Czas sortowania tablicy: " + (stop - start) + " ns");
        System.out.println();

        System.out.println("~~~~~~QUICKSORT~~~~~~");
        int[] vi2 = new int[10];
        generateRandomValues(vi2);
        System.out.println("Łańcuch przed posortowaniem: \t" + arrayToString(vi2));
        start = System.nanoTime();
        qs.sort(vi2);
        stop = System.nanoTime();
        System.out.println("Łańcuch po posortowaniu: \t" + arrayToString(vi2));
        check(vi2);
        System.out.println("Czas sortowania tablicy: " + (stop - start) + " ns");
        System.out.println();

        System.out.println("~~~~~~QUICKSORT_ITERATIVE~~~~~~");
        int[] vi3 = new int[10];
        generateRandomValues(vi3);
        System.out.println("Łańcuch przed posortowaniem: \t" + arrayToString(vi3));
        start = System.nanoTime();
        qsi.sort(vi3);
        stop = System.nanoTime();
        System.out.println("Łańcuch po posortowaniu: \t" + arrayToString(vi3));
        check(vi3);
        System.out.println("Czas sortowania tablicy: " + (stop - start) + " ns");
        System.out.println();

        System.out.println("~~~~~~INSERTSORT~~~~~~");
        int[] vi4 = new int[10];
        generateRandomValues(vi4);
        System.out.println("Łańcuch przed posortowaniem: \t" + arrayToString(vi4));
        start = System.nanoTime();
        is.sort(vi4);
        stop = System.nanoTime();
        System.out.println("Łańcuch po posortowaniu: \t" + arrayToString(vi4));
        check(vi4);
        System.out.println("Czas sortowania tablicy: " + (stop - start) + " ns");
        System.out.println();
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String arrayToString(double[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void generateRandomValues(double[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextDouble();
        }
    }

    public static void generateRandomValues(int[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100);
        }
    }

    public static boolean check(int[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i + 1] < t[i]) {
                System.out.println("PORAŻKA :(");
                return false;
            }
        }
        System.out.println("SUKCES :)");
        return true;
    }
}
