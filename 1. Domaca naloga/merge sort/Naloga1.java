/*

    MERGE SORT

*/
import java.util.Scanner;
public class Naloga1 {
    

    public static int[] a;
    public static int[] zacasna;

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        

        String nacin = in.next();
        String algoritem = in.next();
        String smer = in.next();
        int size = in.nextInt();

        a = new int[size];
        
        
        for (int i = 0; i < size; i++) {
            a[i] = in.nextInt();
        }

        if (nacin.equals("trace")) {
            //Izpisuj sled algoritma
            if (algoritem.equals("ms")) {
                if (smer.equals("up")) {
                    Delitev(0, a.length - 1);
                }
            }
        }
    }
    
    public static void Izpisi(int[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.printf("%d ", t[i]);
        }
        System.out.println();
    }
    
    public static void Delitev(int start, int end) {
        if (start == end) {
            int middle = (start + end)/2;
            int[] x = new int[1];
            int[] y = new int[1];
            x[0] = a[start];
            y[0] = a[end];
            //Imamo eno tabelo, dolga je en element
            Zlivaj(x, y);
            
            
        } else {

            /*
            if (start == end - 1) {
                System.out.printf("%d | %d", a[start], a[end]);
                System.out.println();
            }
            */
            int middle = (start + end)/2;
            System.out.println("Start: " + start + " Middle " + middle + " end " + end);
            Delitev(start, middle);
            Delitev(middle + 1, end);
            int[] nova1;
            if ((middle - start) == 0) {
                nova1 = new int[1];
            } else {
                nova1 = new int[middle - start];
            }
            
            for (int k = start; k <= middle; k++) {
                nova1[k] = a[k];
            }
            int[] nova2;
            if ((end - middle) == 0) {
               nova2 = new int[1];
            } else {
               nova2 = new int[end - middle];
            }
            for (int k = middle; k <= end; k++) {
                nova2[k] = a[k];
            } 
            Zlivaj(nova1, nova2);
        }
    }

    public static int[] Zlivaj(int[] a, int[] b) {
        int indexPrve = 0;
        int indexDruge = 0;
        int indexPrave = 0;
        int[] urejena = new int[a.length + b.length];

        while (indexPrve < a.length && indexDruge < b.length) {
            if (a[indexPrve] <= b[indexDruge]) {
                // Ce je element iz tabele a manjsi od elementa iz tabele b
                urejena[indexPrave] = a[indexPrve];
                System.out.printf("a");
                indexPrve++;
                indexPrave++;
            } else {
                //Drugace
                urejena[indexPrave] = b[indexDruge];
                 System.out.printf("b");
                indexDruge++;
                indexPrave++;
            }
        }
        if (indexPrve < a.length) {
            while (indexPrve < a.length) {
                urejena[indexPrave] = a[indexPrve];
                System.out.printf("a");
                indexPrave++;
                indexPrve++;   
            }
        }
        if (indexDruge < b.length) {
            while (indexDruge < b.length) {
                urejena[indexPrave] = b[indexDruge];
                System.out.printf("b");
                indexPrave++;
                indexDruge++;   
            }
        }
        return urejena;
    }
}