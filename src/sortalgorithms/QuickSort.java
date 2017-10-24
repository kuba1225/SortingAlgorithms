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
public class QuickSort {

    public void sort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    private int podziel(int[] a, int s, int k) {
        int i, j;

        j = s;
        for (i = s + 1; i <= k; i++) {
            if (a[i] < a[s]) {
                swap(a, ++j, i);
            }
        }
        swap(a, j, s);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void qsort(int[] a, int s, int k) {
        if (s < k) {
            int j = podziel(a, s, k);
            qsort(a, s, j - 1);
            qsort(a, j + 1, k);
        }
    }
}
