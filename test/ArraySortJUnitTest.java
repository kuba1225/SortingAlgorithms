/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sortalgorithms.HeapSort;

/**
 *
 * @author Kuba
 */
public class ArraySortJUnitTest {

    HeapSort h;

    public ArraySortJUnitTest() {
    }

    @Before
    public void setUp() {
        h = new HeapSort();
    }

    /*@Test
    public void computationalComplexityTest() {
        
    }*/
    @Test
    public void longVectorTest() {
        int[] argv = new int[1000];
        Random r = new Random();
        for (int i = 0; i < argv.length; i++) {
            r.nextInt(10000);
        }
        long start, stop;
        start = System.nanoTime();
        h.sort(argv);
        stop = System.nanoTime();
        System.out.println("Czas sortowania długiego wektora: " + (stop - start) + " ns");
    }

    @Test
    public void emptyVectorTest() {
        int[] argv = {};
        long start, stop;
        start = System.nanoTime();
        h.sort(argv);
        stop = System.nanoTime();
        System.out.println("Czas sortowania pustego wektora: " + (stop - start) + " ns");
    }

    @Test
    public void negativeNumberTest() {
        int[] argv = {-23, -23432, -12, 23, 34, 54, 23, 234, 234, 34, -342, -234, 23, -43};
        long start, stop;
        start = System.nanoTime();
        h.sort(argv);
        stop = System.nanoTime();
        for (int i = 0; i < argv.length - 1; i++) {
            assertTrue(argv[i] <= argv[i + 1]);
        }
        System.out.println("Czas sortowania wektora zawierającego ujemne liczby: " + (stop - start) + " ns");
    }

    @Test
    public void thisSameElementInVectorTest() {
        int[] argv = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        long start, stop;
        start = System.nanoTime();
        h.sort(argv);
        stop = System.nanoTime();
        for (int i = 0; i < argv.length - 1; i++) {
            assertTrue(argv[i] <= argv[i + 1]);
        }
        System.out.println("Czas sortowania wektora zawierającego takie same liczby: " + (stop - start) + " ns");
    }
}
