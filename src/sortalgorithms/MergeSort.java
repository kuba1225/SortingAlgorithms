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
public class MergeSort {

    public void sort(int[] T) {
        mergeSort(T, 0, T.length - 1);
    }

    private void merge(int[] T, int left, int middle, int right) {
        int[] tmpT = new int[T.length];
        for (int i = left; i <= right; i++) {
            tmpT[i] = T[i];
        }
        int i, j, x;
        i = left;
        j = middle + 1;
        x = left;

        while (i <= middle && j <= right) {
            if (tmpT[i] < tmpT[j]) {
                T[x++] = tmpT[i++];
            } else {
                T[x++] = tmpT[j++];
            }
        }

        while (i <= middle) {
            T[x++] = tmpT[i++];
        }

    }

    private void mergeSort(int[] T, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;//m = l + (r - l) / 2;
            mergeSort(T, l, m);
            mergeSort(T, m + 1, r);
            merge(T, l, m, r);
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] v = {6, 5, 2, 1, 3, 8, 7, 9, 4};
        System.out.println(arrayToString(v));
        ms.sort(v);
        System.out.println(arrayToString(v));
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
