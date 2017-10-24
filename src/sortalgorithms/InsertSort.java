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
public class InsertSort {

    public void sort(int[] T) {
        insertSort(T);
    }

    private void insertSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            wstaw(v, i);
        }
    }

    private void wstaw(int[] v, int n) {
        int j = n;
        int tmp = v[n];
        while (j > 0 && v[j - 1] > tmp) {
            v[j] = v[j - 1];
            j--;
        }
        v[j] = tmp;
    }
}
