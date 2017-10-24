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
public class HeapSort2 {

    public void sort(int[] t) {
        for (int i = 1; i < t.length; i++) {
            heapUp(t, i);
        }

        for (int i = t.length - 1; i > 0; i--) {
            swap(t, i, 0);
            heapDown(t, i);
        }
    }

    private void heapUp(int[] h, int n) {
        int i = n;
        while (i > 0) {
            if (h[(i - 1) / 2] < h[i]) {
                swap(h, i, (i - 1) / 2);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void heapDown(int[] t, int n) {
        int i = 0;
        int c = 2 * i + 1;
        while (c < n) {
            if (c + 1 < n && t[c + 1] > t[c]) {
                c++;
            }

            if (t[i] >= t[c]) {
                break;
            } else {
                swap(t, i, c);
                i = c;
                c = 2 * i + 1;
            }
        }
    }

    private void swap(int[] t, int i, int j) {
        int tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }
}
