/*

    COUNTING SORT

*/
import java.util.Scanner;
public class Naloga1 {
    

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        

        int[] array = new int[256];

        String nacin = in.next();
        String algoritem = in.next();
        String smer = in.next();
        int size = in.nextInt();

        int[] a = new int[size];

        int[] rez = new int[size];
        
        
        for (int i = 0; i < size; i++) {
            a[i] = in.nextInt();
        }

        if (nacin.equals("trace")) {
            //Izpisuj sled algoritma
            if (algoritem.equals("cs")) {
                if (smer.equals("up")) {
                    array = vrniTabelo(a, array);
                    rez = uredi(a, array, rez);
                    Izpisi(rez);
                }
            }
        }
    }

    public static int[] vrniTabelo(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[a[i]]++;
        }
        //Izpisi(b);
        b = izracunKumulativ(b);
        return b;
    }

    public static void Izpisi(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%d ", x[i]);
        }
        System.out.println();
    }

    public static int[] izracunKumulativ(int[] b) {
        for (int i = 1; i < b.length; i++) {
            b[i] += b[i - 1];
        }
        Izpisi(b);
        return b;
    }

    public static int[] uredi(int[] a, int[] b, int[] c) {
        /*
            int[] a = prva tabela : 5 1 6 1 6 2 0 2 = originalna

            int[] b = tabela kumulativ: 1 3 5 5 5 8 8 8 8 8 ... = kumulative

            int[] c = nova tabela   = nova
        */
        for (int i = a.length - 1; i >= 0; i--) {
            int value = a[i];
            int mesto = b[value] - 1;
            System.out.printf("%d ", mesto);
            c[mesto] = value;
            b[value]--;
        }
        System.out.println();
        return c;
    }
}