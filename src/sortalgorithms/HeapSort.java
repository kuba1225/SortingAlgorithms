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
public class HeapSort {

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

    private void heapArray(int[] argv, int w, int parentIndex) {//tutaj sprawdzamy warunek kopca: w - wielkosc tablicy do sprawdzenia, parentIndex - indeks rodzica

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


        /*-znajdz wiekszego syna, jeslli istnieje
            -swap wiekszy syn z mniejszym ojcem
            -przejdz rekurencyjnie po wszystkich synach az do momentu gdy znajdziesz ojca bez synow??? lub zaden z nich nie bedzie wiekszy od ojca*/
        //zamien ostatni element tablicy args[] z korzeniem (root node)
    }

    public void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public void sortDesc(int[] argv) {
        sort(argv);
        reverseArray(argv);
    }

    public void reverseArray(int[] array) {
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
