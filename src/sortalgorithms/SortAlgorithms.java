/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

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
        HeapSort h = new HeapSort();
        int[] v = {0, 423, 2352334, 1231235, 23, 234, 345, 234, 1, 42, 353, 45, 23, 12, 2342, 45, 234, 123, -23, -543, -234, 1, -4};

        System.out.println("Łańcuch przed posortowaniem: \t" + arrayToString(v));
        start = System.nanoTime();
        h.sort(v);
        stop = System.nanoTime();
        System.out.println("Łańcuch po posortowaniu: \t" + arrayToString(v));
        System.out.println("Czas sortowania tablicy: " + (stop - start) + " ns");
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
}
