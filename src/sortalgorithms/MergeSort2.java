package sortalgorithms;

/**
 *
 * @author Kuba
 */
public class MergeSort2 {

    public void sort(int[] t) {
        mergeSort(t, t.length - 1);
    }

    private void mergeSort(int[] t, int n) {
        for (int p = 1; p <= n; p *= 2) {
            for (int i = 0; i <= n - p; i += 2 * p) {
                merge(t, i, i + p - 1, min(n, i + 2 * p - 1));
            }
        }
    }

    private void merge(int[] T, int left, int middle, int right) {
        int[] tmpT = new int[T.length];
        for (int i = left; i <= right; i++) {
            tmpT[i] = T[i];
        }//System.arraycopy(T, 0, tmpT, 0, T.length);
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

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
