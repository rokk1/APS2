/*

    TO JE BUBBLESORT

    trace bs up 6
    8 5 6 1 7 2

*/

import java.util.Scanner;
class Naloga1 {
    

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
            if (algoritem.equals("bs")) {
                if (smer.equals("up")) {
                    //Narascajoci vrstni red
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
        
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] < a[i]) {
                                //Zamenjaj
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                        }
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                    }
                } else {
                    //Padajoc vrstni red
                    
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] > a[i]) {
                                //Zamenjaj
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                        }
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                    }
                }
            }
        } else {
            //Izpisi stevilo primerjav in stevilo prirejanj
            if (algoritem.equals("bs")) {
                if (smer.equals("up")) {
                    int stPrirejanj = 0;
                    int stPrimerjav = 0;
                    //Narascajoci vrstni red
                    /*
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    */
        
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] < a[i]) {
                                //Zamenjaj
                                stPrirejanj += 3;
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                            stPrimerjav++;
                        }
                        /*
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                        */
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    //Izracunaj stPrirejanj in zamenjav za ze urejeno tabelo stevil
                    stPrirejanj = 0;
                    stPrimerjav = 0;
                    //Narascajoci vrstni red
                    /*
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    */
        
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] < a[i]) {
                                //Zamenjaj
                                stPrirejanj += 3;
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                            stPrimerjav++;
                        }
                        /*
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                        */
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    //Izracunaj stPrirejanj in zamenjav za ze urejeno tabelo, vendar ko jo moramo urediti v drugacnem vrstnem redu
                    stPrirejanj = 0;
                    stPrimerjav = 0;
                    //Narascajoci vrstni red
                    /*
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    */
        
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] > a[i]) {
                                //Zamenjaj
                                stPrirejanj += 3;
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                            stPrimerjav++;
                        }
                        /*
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                        */
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                } else {
                    int stPrirejanj = 0;
                    int stPrimerjav = 0;
                    //Narascajoci vrstni red
                    /*
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    */
        
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] > a[i]) {
                                //Zamenjaj
                                stPrirejanj += 3;
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                            stPrimerjav++;
                        }
                        /*
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                        */
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    //Izracunaj stPrirejanj in zamenjav za ze urejeno tabelo stevil
                    stPrirejanj = 0;
                    stPrimerjav = 0;
                    //Narascajoci vrstni red
                    /*
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    */
        
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] > a[i]) {
                                //Zamenjaj
                                stPrirejanj += 3;
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                            stPrimerjav++;
                        }
                        /*
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                        */
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    //Izracunaj stPrirejanj in zamenjav za ze urejeno tabelo, vendar ko jo moramo urediti v drugacnem vrstnem redu
                    stPrirejanj = 0;
                    stPrimerjav = 0;
                    //Narascajoci vrstni red
                    /*
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    */
        
                    //Izpisuj samo  sled algoritma
                    for (int k = 0; k < size - 1; k++) {
                        for (int i = size - 2; i >= k; i--) {
                            if (a[i + 1] < a[i]) {
                                //Zamenjaj
                                stPrirejanj += 3;
                                int temp = a[i];
                                a[i] = a[i + 1];
                                a[i + 1] = temp;
                            }
                            stPrimerjav++;
                        }
                        /*
                        for (int l = 0; l < size; l++) {
                            if (l == k + 1) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[l]);
                        }
                        System.out.println();
                        */
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                }
            }
        }
    }  
}