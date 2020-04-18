/*

    TO JE HEAP SORT!

    Ne potrebujes posebej objektov Heap in/ali Node

*/
import java.util.Scanner;
public class Naloga1 {
    

    public static int stPrimerjanj = 0;
    public static int stPriredb = -3;

    public static Scanner in = new Scanner(System.in);

    public static int[] a;
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
            if (algoritem.equals("hs")) {
                if (smer.equals("up")) {
                   
                    Heapsort();
                    System.out.printf("%d", a[1]);
                } else {
                    HeapsortMin();
                    System.out.printf("%d", a[1]);
                }
            }
        } else {
            if (algoritem.equals("hs")) {
                if (smer.equals("up")) {
                    HeapsortCount();
                    System.out.println(stPrimerjanj + " " + stPriredb);
                    stPrimerjanj = 0;
                    stPriredb = 0;
                    HeapsortCount();
                    System.out.println(stPrimerjanj + " " + stPriredb);
                    stPrimerjanj = 0;
                    stPriredb = 0;
                    HeapsortMinCount();
                    System.out.println(stPrimerjanj + " " + stPriredb);
                    stPrimerjanj = 0;
                    stPriredb = 0;
                } else {
                    HeapsortMinCount();
                    System.out.println(stPrimerjanj + " " + stPriredb);
                    stPrimerjanj = 0;
                    stPriredb = 0;
                    HeapsortMinCount();
                    System.out.println(stPrimerjanj + " " + stPriredb);
                    stPrimerjanj = 0;
                    stPriredb = 0;
                    HeapsortCount();
                    System.out.println(stPrimerjanj + " " + stPriredb);
                    stPrimerjanj = 0;
                    stPriredb = 0;
                }
            }
        } 
    }





    public static int[] SestaviMinKopico(int[] n, int len) {
        for (int i = (len - 1)/2; i >= 0; i--) {
            PopraviMin(i, len - 1);
        }
        return n;
    }


    public static int[] SestaviMaxKopico(int[] n, int len) {
        for (int i = (len - 1)/2; i >= 0; i--) {
            Popravi(i, len - 1);
        }
        return n;
    }

    public static void PopraviMin(int i, int j) {
        if (i <= j/2) {
                
            int oce = i;
            int manjsi = 0;
            int sin1 = (2 * i) + 1;
            
            if (sin1 <= j) {
                if (a[sin1] > a[sin1 + 1]) {
                    stPrimerjanj++;
                    manjsi = sin1 + 1;
                } else {
                    stPrimerjanj++;
                    manjsi = sin1;
                }
                //System.out.printf("Sin1: %d, Sin2: %d\n", a[sin1], a[sin1 + 1]);
            } else {
                manjsi = sin1;
            }
            //System.out.println("Oce: " + a[oce] + " Vecji: " + a[vecji]);
            //System.out.println("Oce: " + a[oce] + " Manjsi sin: " + a[manjsi]);
            //System.out.println("Vecji sin: " + vecji);
            if (a[manjsi] < a[oce]) {
                // SWAP
                //System.out.println("ZAMENJAVA...............................");
                //Izpisi(a, a.length);
                stPriredb += 3;
                stPrimerjanj++;
                int temp = a[oce];
                a[oce] = a[manjsi];
                a[manjsi] = temp;
                //Izpisi(a, a.length);
                
                
                //System.out.println("Vecji: " + vecji);
                PopraviMin(manjsi, j);
            }
        }
    }

    public static void Popravi(int i, int j) {
        if (i <= j/2) {
                
            int oce = i;
            int vecji = 0;
            int sin1 = (2 * i) + 1;
            
            if (sin1  <= j) {
                if (a[sin1] < a[sin1 + 1]) {
                    stPrimerjanj++;
                    vecji = sin1 + 1;
                } else {
                    stPrimerjanj++;
                    vecji = sin1;
                }
                //System.out.printf("Sin1: %d, Sin2: %d\n", a[sin1], a[sin1 + 1]);
            } else {
                
                vecji = sin1;
            }
            //System.out.println("Oce: " + a[oce] + " Vecji: " + a[vecji]);
            //System.out.println("Oce: " + a[oce] + " Vecji sin: " + a[vecji]);
            //System.out.println("Vecji sin: " + vecji);
            if (a[vecji] > a[oce]) {
                // SWAP
                stPriredb += 3;
                stPrimerjanj++;
                int temp = a[oce];
                a[oce] = a[vecji];
                a[vecji] = temp;
                
                
                //System.out.println("Vecji: " + vecji);
                Popravi(vecji, j);
            }
        }
    }

    public static void Izpisi(int[] x, int doKam) {
        int c = 1;
        for (int i = 0; i < doKam; i++) {
            if (i + 1 == c) {
                if (c != 1) {
                    System.out.printf("| ");
                }
                c = 2 * c;
            }
            System.out.printf("%d ", x[i]);
        }
        System.out.println();
    }

    
    public static void Heapsort() {
        int r = a.length;

        SestaviMaxKopico(a, r - 1);
        while (r > 1) {
            Izpisi(a, r);
            stPriredb += 3;
            int temp = a[0];
            a[0] = a[r - 1];
            a[r - 1] = temp;
            r--;
            //System.out.println(r);
            SestaviMaxKopico(a, r - 1);
        }
    }

    public static void HeapsortMin() {
        int r = a.length;

        SestaviMinKopico(a, r - 1);
        while (r > 1) {
            Izpisi(a, r);
            stPriredb += 3;
            int temp = a[0];
            a[0] = a[r - 1];
            a[r - 1] = temp;
            r--;
            //System.out.println(r);
            SestaviMinKopico(a, r - 1);
        }
    }

    public static void HeapsortCount() {
        int r = a.length;

        SestaviMaxKopico(a, r - 1);
        while (r > 1) {
            stPriredb += 3;
            
            int temp = a[0];
            a[0] = a[r - 1];
            a[r - 1] = temp;
            r--;
            //System.out.println(r);
            SestaviMaxKopico(a, r - 1);
        }
    }

    public static void HeapsortMinCount() {
        int r = a.length;

        SestaviMinKopico(a, r - 1);
        while (r > 1) {
            stPriredb += 3;
            
            int temp = a[0];
            a[0] = a[r - 1];
            a[r - 1] = temp;
            r--;
            //System.out.println(r);
            SestaviMinKopico(a, r - 1);
        }
    }
}