/*

    RADIX SORT

*/
import java.util.Scanner;
public class Naloga1 {
    

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        

        int[] kumulative = new int[257];

        String nacin = in.next();
        String algoritem = in.next();
        String smer = in.next();
        int size = in.nextInt();

        int[][] a = new int[size][2];


        int[] tabelaBajtov = new int[size];

        int[][] rezultat = new int[size][2];

        
        
        
        for (int i = 0; i < size; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = 0;
        }

        Izpisi2(a);

        if (nacin.equals("trace")) {
            //Izpisuj sled algoritma
            if (algoritem.equals("rs")) {
                if (smer.equals("up")) {
                    for (int i = 1; i <= 4; i++) {
                        kumulative = vrniTabelo(a, kumulative);
                        rezultat = countingSort(a, i, kumulative);
                        rezultat = vrnjeno(a);
                    }
                }
            }
        }
    }

    public static int[][] vrnjeno(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            a[i][1] = a[i][0]/256;
        }
        return a;
    }

    public static int[][] countingSort(int[][] a, int nivo, int[] kumulative) {
        int delitelj = 256;
        int[][] rez = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            a[i][1] = a[i][0] % delitelj;
            rez = uredi(a, kumulative, i);
        }
        return a;
    }

    public static int[] vrniTabelo(int[][] a, int[] b) {
        int delitelj = 256;
        for (int i = 0; i < a.length; i++) {
            System.out.println("Delitelj: " + delitelj);
            System.out.println("a[i][0]: " + a[i][0]);
            int value = a[i][0] % delitelj;
            b[value]++;
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

    public static void Izpisi2(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%d ", x[i][0]);
        }
        System.out.println();
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%d ", x[i][1]);
        }
    }

    public static int[] izracunKumulativ(int[] b) {
        /*
        for (int i = 1; i < b.length; i++) {
            b[i] += b[i - 1];
        }
        Izpisi(b);
        return b;
        */
        for (int i = 1; i < b.length; i++) {
            b[i] += b[i - 1];
        }
        Izpisi(b);
        return b;


    }

    

    public static int[][] uredi(int[][] a, int[] b, int nivo) {
        return null;        
    }

    /*

    public static int[] bajt(int x) {
        int stevilo = x;
        int[] z = new int[32];
        for (int i = z.length - 1; i >= 0; i--) {
            //System.out.println(stevilo);
            z[i] = stevilo%2;
            //System.out.println(z[i]); 
            stevilo = stevilo/2;
        }

        //Izpisi(z);

        return z;
    }

    /*

    public static int pretvoriNazaj(int[] x, int blok) {
        int stevilo = 0;
        int vrednost = 0;
        if (blok == 1) {
            for (int i = 31; i >= 24; i--) {
                if (x[i] == 1) {
                    stevilo += (int)Math.pow(2, vrednost);
                }
                vrednost++;
            }
        } else if (blok == 2) {
            for (int i = 23; i >= 16; i--) {
                if (x[i] == 1) {
                    stevilo += (int)Math.pow(2, vrednost);
                }
                vrednost++;
            }
        } else if (blok == 3) {
            for (int i = 15; i >= 8; i--) {
                if (x[i] == 1) {
                    stevilo += (int)Math.pow(2, vrednost);
                }
                vrednost++;
            }
        } else {
            for (int i = 7; i >= 0; i--) {
                if (x[i] == 1) {
                    stevilo += (int)Math.pow(2, vrednost);
                }
                vrednost++;
            }
        }
        //System.out.printf("Stevilo: %d\n", stevilo);
        return stevilo;
    }

    */
}