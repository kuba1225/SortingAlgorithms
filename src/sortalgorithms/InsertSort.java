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
        for (int i = 0; i < v.length; i++) {//i=1 nie byłoby lepsze?
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
