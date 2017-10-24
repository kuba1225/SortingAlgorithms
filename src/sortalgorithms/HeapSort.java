package sortalgorithms;

/**
 *
 * @author Kuba
 */
public class HeapSort {

    /**
     * Ta metoda używana jest do sortowania kopcowego tablicy zawierającej
     * elementy typu int
     *
     * @param argv Tablica do posortowania
     */
    public void sort(int[] argv) {
        int n = argv.length;
        for (int i = n / 2 - 1; i >= 0; i--) {//przeszukiwania rozpoczynamy od ostatniego ojca n/2-1 - indeks ost. ojca
            heapArray(argv, n, i);
        }//tutaj zbudowaliśmy kopiec (drzewo binarne spełniające warunek kopca)

        for (int i = n - 1; i > 0; i--) {
            swap(argv, 0, i);//zamieniamy korzeń kopca z jego ostatnim liściem
            heapArray(argv, i, 0);//indeks rodzica ustawiamy na 0, gdyż wewnątrz heapArray mamy rekurencyjne wywołanie, które zamieni drzewo na kopiec
        }//tutaj zamieniamy ostatni element z początkiem, przechodzimy po kolejnych elementach kopca od korzenia, sprawdzając czy spełniony jest warunek kopca(rekurencja)
    }

    /**
     * Ta metoda używana jest do sprawdzania warunku kopca
     *
     * @param argv Tablica do posortowania
     * @param w Wielkość tablicy do sprawdzenia
     * @param parentIndex Indeks rodzica
     */
    private void heapArray(int[] argv, int w, int parentIndex) {

        int larger = parentIndex;//zakladamy ze rodzic jest najwiekszym elementem
        int leftChild = 2 * parentIndex + 1;//ustalamy indeks lewego dziecka
        int rightChild = 2 * parentIndex + 2;//ustalamy indeks prawego dziecka

        if (leftChild < w && argv[leftChild] > argv[larger]) {//jezeli lewe dziecko istnieje oraz jest wieksze od rodzica to staje sie największym elementem 
            larger = leftChild;
        }
        if (rightChild < w && argv[rightChild] > argv[larger]) {//jezeli prawe dziecko istnieje oraz jest wieksze od rodzica to staje sie największym elementem 
            larger = rightChild;
        }

        if (larger != parentIndex) {//jezeli ktores z dzieci danego parent index jest wieksze od niego samego, to zamieniamy je miejscami
            swap(argv, parentIndex, larger);
            heapArray(argv, w, larger);//sprawdzaj rekurencyjnie warunek kopca do momentu gdzy znajdzesz rodzica, którego dzieci są od niego mniejsze
        }
    }

    /**
     * Metoda ta zamienia ze sobą miejscami dwa elementy tablicy
     *
     * @param array tablica w której chcemy dokonać zamiany
     * @param x indeks pierwszego elementu tablicy
     * @param y indeks drugiego elementu tablicy
     */
    private void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    /**
     * Ta metoda sortuje tablicę w sposób malejący
     *
     * @param argv tablica do posortowania
     */
    public void sortDesc(int[] argv) {
        sort(argv);
        reverseArray(argv);
    }

    /**
     * Metoda ta odwraca tablicę posortowaną algorytmem HeapSort
     *
     * @param array
     */
    private void reverseArray(int[] array) {
        int n = array.length;
        int i, j;
        int tmp;

        for (i = n - 1, j = 0; j < n / 2; i--, j++) {
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

}
