package sortalgorithms;

/**
 *
 * @author Kuba
 */
public class QuickSortIterative {

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
        //iteracyjna implementacja wymaga zastosowania stosu
        int ss[] = new int[k - s + 1];//początki podwektorów
        int ks[] = new int[k - s + 1];//końce podwektorów
        int sp = 0;
        int bs, bk, j;

        if (s < k) {
            ss[0] = s;
            ks[0] = k;
            sp = 1;
            while (sp > 0) {
                bs = ss[--sp];
                bk = ks[sp];
                j = podziel(a, bs, bk);
                if (j - 1 > bs) {
                    ss[sp] = bs;
                    ks[sp++] = j - 1;
                }
                if (k > j + 1) {
                    ss[sp] = j + 1;
                    ks[sp++] = bk;
                }
            }

        }
    }
}
