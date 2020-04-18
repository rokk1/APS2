import java.util.Scanner;
public class Naloga1 {
    

    public static Scanner in = new Scanner(System.in);

    public static int stPrirejanj = 0;
    public static int stPrimerjav = 0;

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
            if (algoritem.equals("ss")) {
                if (smer.equals("up")) {
                    //od min do max vrednosti
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    int index = 0;
                    while (index < size) {

                        int min = findMin(a, index);
                        int temp = a[index];
                        a[index] = a[min];
                        a[min] = temp;
                        index++;

                        for (int i = 0; i < size; i++) {
                            if (index == size) {
                                break;
                            }
                            if (i == index) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[i]);
                        }
                        System.out.println();
                    }
                } else {
                    //od max do min vrednosti
                    System.out.print("| ");
                    for (int l = 0; l < size; l++) {
                        System.out.printf("%d ", a[l]);
                    }
                    System.out.println();
                    int index = 0;
                    while (index < size) {

                        int max = findMax(a, index);
                        int temp = a[index];
                        a[index] = a[max];
                        a[max] = temp;
                        index++;

                        for (int i = 0; i < size; i++) {
                            if (index == size) {
                                break;
                            }
                            if (i == index) {
                                System.out.print("| ");
                            }
                            System.out.printf("%d ", a[i]);
                        }
                        System.out.println();
                    }
                }
            }
        } else {
            //Izpisi stetje operacij
            if (algoritem.equals("ss")) {
                if (smer.equals("up")) {
                    //od min do max vrednosti
                    int index = 0;
                    while (index < size - 1) {

                        int min = findMin(a, index);
                        int temp = a[index];
                        a[index] = a[min];
                        a[min] = temp;
                        stPrirejanj += 3;
                        stPrimerjav += size - index - 1;
                        index++;
                    }

                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    stPrimerjav = 0;
                    stPrirejanj = 0;

                    //Stetje operacij ze urejenemu seznamu stevil
                    index = 0;
                    while (index < size - 1) {

                        int min = findMin(a, index);
                        int temp = a[index];
                        a[index] = a[min];
                        a[min] = temp;
                        stPrirejanj += 3;
                        stPrimerjav += size - index - 1;
                        index++;

                    }

                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    stPrimerjav = 0;
                    stPrirejanj = 0;

                    //Stetje operacij ze urejenemu seznamu, ki pa je urejen v napacni smeri
                    index = 0;
                    while (index < size - 1) {

                        int max = findMax(a, index);
                        int temp = a[index];
                        a[index] = a[max];
                        a[max] = temp;
                        stPrirejanj += 3;
                        stPrimerjav += size - index - 1;
                        index++;
                    }

                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    stPrimerjav = 0;
                    stPrirejanj = 0;
                } else {
                    //od max do min vrednosti
    
                    int index = 0;
                    while (index < size - 1) {

                        int max = findMax(a, index);
                        int temp = a[index];
                        a[index] = a[max];
                        a[max] = temp;
                        stPrirejanj += 3;
                        stPrimerjav += size - index - 1;
                        index++;
                    }

                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    stPrimerjav = 0;
                    stPrirejanj = 0;

                    //Stetje operacij ze urejenemu seznamu
                    index = 0;
                    while (index < size - 1) {

                        int max = findMax(a, index);
                        int temp = a[index];
                        a[index] = a[max];
                        a[max] = temp;
                        stPrirejanj += 3;
                        stPrimerjav += size - index - 1;
                        index++;
                    }

                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    stPrimerjav = 0;
                    stPrirejanj = 0;

                    //Stetje operacij ze urejenemu seznamu, ki pa je urejen v napacni smeri
                    index = 0;
                    while (index < size - 1) {

                        int min = findMin(a, index);
                        int temp = a[index];
                        a[index] = a[min];
                        a[min] = temp;
                        stPrirejanj += 3;
                        stPrimerjav += size - index - 1;
                        index++;
                    }

                    System.out.printf("%d %d\n", stPrimerjav, stPrirejanj);
                    stPrimerjav = 0;
                    stPrirejanj = 0;
                }
            }
        }
    }

    public static int findMin(int[] x, int index) {
        int minIndex = index;
        int min = x[index];
        for (int i = index; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    public static int findMax(int[] x, int index) {
        int maxIndex = index;
        int max = x[index];
        for (int i = index; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}