/*

    TO JE QUICKSORT!

    * DODAJ 

        Dodaj se izpis za 


    *
*/
import java.util.Scanner;
public class Naloga1 {
    

    public static int stPrimerjanj = 0;
    public static int stPriredb = 0;

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        

        String nacin = in.next();
        String algoritem = in.next();
        String smer = in.next();
        int size = in.nextInt();

        int[] a = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = in.nextInt();
        }
        

        
        if (nacin.equals("trace")) {
            //Izpisuj sled algoritma
            if (algoritem.equals("qs")) {
                if (smer.equals("up")) {
                    quicksortUp(a, 0, a.length - 1);
                    
                } else {
                    quicksortDown(a, 0, a.length - 1);
                }
            }
        } else {
            if (smer.equals("up")) {
                quickSortUpCount(a, 0, a.length - 1);
                System.out.println(stPrimerjanj + " " + stPriredb);
                stPrimerjanj = 0;
                stPriredb = 0;
                quickSortUpCount(a, 0, a.length - 1);
                System.out.println(stPrimerjanj + " " + stPriredb);
                stPrimerjanj = 0;
                stPriredb = 0;
                quickSortDownCount(a, 0, a.length - 1);
                System.out.println(stPrimerjanj + " " + stPriredb);
                stPrimerjanj = 0;
                stPriredb = 0;
            } else {
                quickSortDownCount(a, 0, a.length - 1);
                System.out.println(stPrimerjanj + " " + stPriredb);
                stPrimerjanj = 0;
                stPriredb = 0;
                quickSortDownCount(a, 0, a.length - 1);
                System.out.println(stPrimerjanj + " " + stPriredb);
                stPrimerjanj = 0;
                stPriredb = 0;
                quickSortUpCount(a, 0, a.length - 1);
                System.out.println(stPrimerjanj + " " + stPriredb);
                stPrimerjanj = 0;
                stPriredb = 0;
            }
        }
    }

    public static void quickSortUpCount(int[] t, int left, int right) {
        if (left >= right) {
            return;
        }

        
        int pivot = t[(left + ((right - left)/2))];
        stPriredb += 1;
        int i = left;
        int j = right;

        while (i <= j) {
            stPrimerjanj += 2;
            while (t[i] < pivot) {
                stPrimerjanj++;
                i++;
            }
            while (t[j] > pivot) {
                stPrimerjanj++;
                j--;
            }

            if (i <= j) {
                stPriredb += 3;
                //stPrimerjanj += 1;
                int temp = t[i];
                t[i] = t[j];
                t[j] = temp;
                i++;
                j--;
            }
        }


        if (left < j) {
            quickSortUpCount(t, left, j);
        }
        if (i < right) {
            quickSortUpCount(t, i, right);
        }
    }

    public static void quickSortDownCount(int[] t, int left, int right) {
        if (left >= right) {
            return;
        }

        
        int pivot = t[(left + ((right - left)/2))];
        stPriredb += 1;
        int i = left;
        int j = right;

        while (i <= j) {
            stPrimerjanj += 2;
            while (t[i] > pivot) {
                stPrimerjanj++;
                i++;
            }
            while (t[j] < pivot) {
                stPrimerjanj++;
                j--;
            }

            if (i <= j) {
                stPriredb += 3;
                //stPrimerjanj++;
                int temp = t[i];
                t[i] = t[j];
                t[j] = temp;
                i++;
                j--;
            }
        }


        if (left < j) {
            quickSortDownCount(t, left, j);
        }
        if (i < right) {
            quickSortDownCount(t, i, right);
        }
    }

    public static void quicksortUp(int[] t, int left, int right) {
        if (left >= right) {
            return;
        }

        
        int pivot = t[(left + ((right - left)/2))];
        //System.out.println("Pivot: " + pivot);
        int i = left;
        int j = right;

        while (i <= j) {
            while (t[i] < pivot) {
                i++;
            }
            while (t[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = t[i];
                t[i] = t[j];
                t[j] = temp;
                i++;
                j--;
            }
        }

        Izpisi(t, left, right, pivot, i, j);

        if (left < j) {
            quicksortUp(t, left, j);
        }
        if (i < right) {
            quicksortUp(t, i, right);
        }
    }

    public static void quicksortDown(int[] t, int left, int right) {
        if (left >= right) {
            return;
        }

        
        int pivot = t[(left + ((right - left)/2))];
        //System.out.println("Pivot: " + pivot);
        int i = left;
        int j = right;

        while (i <= j) {
            while (t[i] > pivot) {
                i++;
            }
            while (t[j] < pivot) {
                j--;
            }

            if (i <= j) {
                int temp = t[i];
                t[i] = t[j];
                t[j] = temp;
                i++;
                j--;
            }
        }

        Izpisi(t, left, right, pivot, i, j);

        if (left < j) {
            quicksortDown(t, left, j);
        }
        if (i < right) {
            quicksortDown(t, i, right);
        }
    }

    
    public static void Izpisi(int[] x, int left, int right, int pivot, int i, int j) {
        for (int k = left; k <= right; k++) {
            if (j + 1 == k) {
                System.out.printf("| ");
            }
            if (i == k) {
                System.out.printf("| ");
            }
            System.out.printf("%d ", x[k]);
        }
        System.out.println();
    }
}