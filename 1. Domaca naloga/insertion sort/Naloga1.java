/*

    TO JE INSERTION SORT!

*/
import java.util.Scanner;
public class Naloga1 {
    

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
            if (algoritem.equals("is")) {
                if (smer.equals("up")) {
                    int dolzinaUrejenegaDela = 1;
                    for (int i = 0; i < a.length; i++) {
                        if (i == dolzinaUrejenegaDela) {
                            System.out.printf("| ");
                        }
                        System.out.printf("%d ", a[i]);
                    }
                    while (dolzinaUrejenegaDela < a.length) {
                        System.out.println();
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            if (a[i] < a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                        for (int i = 0; i < a.length; i++) {
                            if (i == dolzinaUrejenegaDela) {
                                System.out.printf("| ");
                            }
                            System.out.printf("%d ", a[i]);
                        }
                    }
                    System.out.printf("|\n");
                } else {
                    int dolzinaUrejenegaDela = 1;
                    for (int i = 0; i < a.length; i++) {
                        if (i == dolzinaUrejenegaDela) {
                            System.out.printf("| ");
                        }
                        System.out.printf("%d ", a[i]);
                    }
                    while (dolzinaUrejenegaDela < a.length) {
                        System.out.println();
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            if (a[i] > a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                        for (int i = 0; i < a.length; i++) {
                            if (i == dolzinaUrejenegaDela) {
                                System.out.printf("| ");
                            }
                            System.out.printf("%d ", a[i]);
                        }
                    }
                    System.out.printf("|\n");
                }
            }
        } else {
            // Stejemo operacije: stevilo primerjav elementov in stevilo prirejanj elementov... Ena zamenjava steje za 3 prirejanja
            if (algoritem.equals("is")) {
                if (smer.equals("up")) {
                    int stPrimerjav = 0;
                    int stPrirejanj = 0;
                    int dolzinaUrejenegaDela = 1;
                    while (dolzinaUrejenegaDela < a.length) {
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            stPrimerjav++;
                            if (a[i] < a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                                stPrirejanj += 3;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);

                    //Zdaj prestej operacije se za ze urejeno tabelo
                    stPrimerjav = 0;
                    stPrirejanj = 0;
                    dolzinaUrejenegaDela = 1;
                    while (dolzinaUrejenegaDela < a.length) {
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            stPrimerjav++;
                            if (a[i] < a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                                stPrirejanj += 3;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);


                    // Zdaj prestej stevilo operacij se za narobe obrnjeno tabelo
                    stPrimerjav = 0;
                    stPrirejanj = 0;
                    dolzinaUrejenegaDela = 1;
                    while (dolzinaUrejenegaDela < a.length) {
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            stPrimerjav++;
                            if (a[i] > a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                                stPrirejanj += 3;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                } else {
                    //Smer = down
                    int stPrimerjav = 0;
                    int stPrirejanj = 0;
                    int dolzinaUrejenegaDela = 1;
                    while (dolzinaUrejenegaDela < a.length) {
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            stPrimerjav++;
                            if (a[i] > a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                                stPrirejanj += 3;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
    
                    //Zdaj prestej operacije se za ze urejeno tabelo
                    stPrimerjav = 0;
                    stPrirejanj = 0;
                    dolzinaUrejenegaDela = 1;
                    while (dolzinaUrejenegaDela < a.length) {
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            stPrimerjav++;
                            if (a[i] > a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                                stPrirejanj += 3;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
    
    
                    // Zdaj prestej stevilo operacij se za narobe obrnjeno tabelo
                    stPrimerjav = 0;
                    stPrirejanj = 0;
                    dolzinaUrejenegaDela = 1;
                    while (dolzinaUrejenegaDela < a.length) {
                        for (int i = dolzinaUrejenegaDela; i > 0; i--) {
                            stPrimerjav++;
                            if (a[i] < a[i - 1]) {
                                //Zamenjaj ju
                                int temp = a[i - 1];
                                a[i - 1] = a[i];
                                a[i] = temp;
                                stPrirejanj += 3;
                            } else {
                                break;
                            }
                        }
                        dolzinaUrejenegaDela++;
                    }
                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                }
            }
        }              
    }
}