package sortalgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kuba
 */
public class QuickSortIterative {

    public void sort(int[] a) {
        qsortStack(a, 0, a.length - 1);
    }

    private void qsortTable(int[] a, int s, int k) {
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

    private void qsortStack(int[] t, int p, int k) {
        if (p >= k) {
            return;
        }

        Stack s = new Stack();

        s.push(p);
        s.push(k);

        while (!s.isEmpty()) {
            k = s.pop();
            p = s.pop();
            int m = podziel(t, p, k);

            if (m - 1 > p) {
                s.push(p);
                s.push(m - 1);
            }
            if (m + 1 < k) {
                s.push(m + 1);
                s.push(k);
            }
        }
    }

    private class Stack {

        List<Integer> l = new ArrayList<Integer>();

        public void push(int x) {
            l.add(x);
        }

        public int pop() {
            return l.remove(l.size() - 1);
        }

        public boolean isEmpty() {
            return l.isEmpty();
        }
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
}
