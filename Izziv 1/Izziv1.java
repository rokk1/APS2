import java.util.Random;
import java.util.Scanner;

public class Izziv1 {

    public static Random rand = new Random();
    public static Scanner in = new Scanner(System.in);
    public static int steviloPonovitev;

    public static void main(String[] args) {
        System.out.printf("      n    |  linearno  |  dvojisko |\n");
        System.out.println("-------------------------------------");
        for (int i = 1000; i <= 100000; i = i + 1000) {
            long casLinearno = timeLinear(i);
            long casBinarno = timeBinary(i);
            System.out.format("%10d | %10d | %10d|\n", i, casLinearno, casBinarno);
            //System.out.printf("  %d  |  %d  |  %d  |\n", i, casLinearno, casBinarno);
        }
    }

    public static int[] generateTable(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }
        return array;
    }

    public static int findLinear(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /*
    - Poisci stevilo value v tabeli a binarno,
    - l in r sta leva in desna meja v tabeli
    */
    public static int findBinary(int[] a, int l, int r, int value) {
        
        if (l == r) {
            //System.out.println("Vrednost " + value + " je v tabeli na mestu: " + l);
            return l;
        }
        /*
        if (l > r) {
            System.out.println("Vrednosti " + value + " ni v tabeli!");
            return -1;
        }
        */
        
        int index = (r + l)/2;
        if (a[index] == value) {
            //We found our element in array, return
            return index;
        } else if (a[index] < value) {
            //We must move to the right half of array
            return findBinary(a, index + 1, r, value);
        } else {
            //We must move to the left half of array
            return findBinary(a, l, index - 1, value);
        }
    }

    public static long timeLinear(int n) {
        int[] array = generateTable(n);
        /*
        for (int i = 0; i < n; i++) {
            System.out.printf("[%d], ", array[i]);
        }
        System.out.println();
        */

        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int value = rand.nextInt(n) + 1;
            //System.out.println("Nakljucna vrednost (linearno): " + value);
            int index = findLinear(array, value);
        }

        long executionTime = System.nanoTime() - startTime;
        long time = executionTime/1000;

        //System.out.println("Potreben cas (linearno): " + time);
        
        return time;
    }

    public static long timeBinary(int n) {
        int[] array = generateTable(n);

        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            int value = rand.nextInt(n) + 1;
            //System.out.println("Nakljucna vrednost (binarno): " + value);
            int index = findBinary(array, 0, n - 1, value);
        }

        long executionTime = System.nanoTime() - startTime;
        long time = executionTime/1000;

       // System.out.println("Potreben cas (binarno): " + time);
        
        return time;
    }
}