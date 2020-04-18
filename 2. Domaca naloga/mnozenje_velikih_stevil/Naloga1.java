import java.util.*;
public class Naloga1 {

    public static Scanner in = new Scanner(System.in);

    public static int rezultat = 0;

    public static void main(String[] args) {
        String alg = in.next();
        int baza = in.nextInt();
        String prvo = in.next();
        String drugo = in.next();
        int[] st1 = toArray(prvo);
        int[] st2 = toArray(drugo);
        

        if (alg.equals("os")) {
            
            //Izpisi(st1);
            //Izpisi(st2);

            int[] vmesni = new int[st1.length];
            int[] celiRezultat = new int[st1.length + st2.length];
            int index = st1.length;
            int prejsnjiIndex = st1.length;
            for (int i = 0; i < st2.length; i++) {
                
                for (int j = st1.length - 1; j >= 0; j--) {
                    int vrednost = st1[j] * st2[i];
                    vmesni[j] = vrednost;
                    celiRezultat[index] = celiRezultat[index] + vrednost;
                    index--;
                }
                
                prejsnjiIndex++;
                index = prejsnjiIndex;
                //Izpisi(celiRezultat);
                
                //Izpisi(vmesni);
                vrniRez(vmesni, baza, false);

            }
            vrniRez(celiRezultat, baza, true);


        } else if (alg.equals("dv")) {
            
            // Razsiri z se eno niclo ce je tabela stevila lihe dolzine

            int[] stevilo1 = podaljsaj(st1);
            int[] stevilo2 = podaljsaj(st2);

            int[] rez = deliInVladaj(stevilo1, stevilo2, baza);
            
            

        } else {
            // Algoritem je karatsuba - alg = "ka"
            Izpisi(st1);
            Izpisi(st2);

            
            return;
        }
    }

    public static boolean justOneNumber(int[] a) {
        
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] toArray(String a) {
        char[] num = a.toCharArray();
        int[] st = new int[num.length];
        for (int i = 0; i < st.length; i++) {
            st[i] = num[i] - '0';
        }
        return st;
    }

    public static int[] podaljsaj(int[] a) {
        if (a.length % 2 != 0) {
            int[] tmp = a;
            a = new int[tmp.length + 1];
            for (int i = tmp.length - 1; i >= 0; i--) {
                a[i + 1] = tmp[i];
            } 
        }
        return a;
    }

    public static boolean isZero(int[]  a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] multiply(int[] st1, int[] st2) {
        int[] vmesni = new int[st1.length];
        int[] celiRezultat = new int[st1.length + st2.length];
        int index = st1.length;
        int prejsnjiIndex = st1.length;
        for (int i = 0; i < st2.length; i++) {
            
            for (int j = st1.length - 1; j >= 0; j--) {
                int vrednost = st1[j] * st2[i];
                vmesni[j] = vrednost;
                celiRezultat[index] = celiRezultat[index] + vrednost;
                index--;
            }
            
            prejsnjiIndex++;
            index = prejsnjiIndex;
        }
        return celiRezultat;
    }

    public static int[] deliInVladaj(int[] a, int[] b, int baza) {
        // Preveri ali je katero od stevil 0
        if (a.length == 1) {
            if (a[0] == 0) {
                return a;
            } else {
                // Pomnozi stevili med sabo
                int[] rez = multiply(a, b);
                Izpisi(rez);
                return rez;
            }
        } else if (b.length == 1) {
            if (b[0] == 0) {
                return b;
            } else {
                // Pomnozi stevili med sabo
                int[] rez = multiply(a, b);
                Izpisi(rez);
                return rez;
            }
        } else {
            Izpisi(a);
            Izpisi(b);

            int[] a0 = razdeli(a, 0);
            int[] a1 = razdeli(a, 1);
            int[] b0 = razdeli(b, 0);
            int[] b1 = razdeli(b, 1);
            a0 = porezi(a0);
            a1 = porezi(a1);
            b0 = porezi(b0);
            b1 = porezi(b1);


            int[] a0b0 = deliInVladaj(a0, b0, baza);
            int[] a0b1 = deliInVladaj(a0, b1, baza);
            int[] a1b0 = deliInVladaj(a1, b0, baza);
            int[] a1b1 = deliInVladaj(a1, b1, baza);
    
                
            return null;
    
        }
    }

    public static int[] porezi(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 0) {
                a = Arrays.copyOfRange(a, 1, a.length);
            } else {
                return a;
            }
        }
        return a;
    }

    public static int[] razdeli(int[] a, int del) {
        int[] rez = new int[a.length / 2];
        if (del == 0) {
            for (int i = 0; i < rez.length; i++) {
                rez[i] = a[i + rez.length];
            }
        } else {
            for (int i = 0; i < rez.length; i++) {
                rez[i] = a[i];
            }
        }
        return rez;
    }

    public static int returnMax(int[] a, int[] b) {
        int max = 0;
        max = (a.length >= b.length ? a.length : b.length);
        return max;
    }

    public static void vrniRez(int[] a, int baza, boolean zadnji) {
        String rez = "";
        int prenesi = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int vrednost = (a[i] + prenesi) % baza;
            prenesi = (a[i] + prenesi)/baza;
            rez = pretvori(vrednost, baza) + rez;
        }
        if (prenesi > 0) {
            rez = pretvori(prenesi, baza) + rez;
        }
        for (int i = 0; i < rez.length(); i++) {
            if (rez.charAt(0) != '0') {
                break;
            }
            rez = rez.substring(1);
        }
        if (zadnji == true) {
            int stCrtic = rez.length();
            for (int i = 0; i < stCrtic; i++) {
                System.out.printf("-");
            }
            System.out.println();
        }
        System.out.printf("%s\n", rez);
    }

    
    public static void Izpisi(int[] a) {
        if (a == null) {
            System.out.printf("null\n");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d", a[i]);
        }
        System.out.println();
    }

    public static int vrniDolzinoStevila(int a) {
        int stMest = 0;
        while (a > 0) {
            stMest++;
            a = a/10;
        }
        return stMest;
    }

    public static String pretvori(int a, int baza) {
        String rez = "";
        if (baza == 10) {
            
            return Integer.toString(a);
        } else {
            if (a > 0) {
                while (a > 0) {
                    int vmesni  = a % baza;
                    a = a / baza;
                    switch (baza) {
                        case 11:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else {
                                rez = "a" + rez;
                            }
                            break;
                        case 12:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else {
                                rez = "b" + rez;
                            }
                            break;
                        case 13:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else {
                                rez = "c" + rez;
                            }
                            break;
                        case 14:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else if (vmesni == 12) {
                                rez = "c" + rez;
                            } else {
                                rez = "d" + rez;
                            }
                            break;
                        case 15:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else if (vmesni == 12) {
                                rez = "c" + rez;
                            } else if (vmesni == 13) {
                                rez = "d" + rez;
                            } else {
                                rez = "e" + rez;
                            }
                            break;
                        case 16:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else if (vmesni == 12) {
                                rez = "c" + rez;
                            } else if (vmesni == 13) {
                                rez = "d" + rez;
                            } else if (vmesni == 14) {
                                rez = "e" + rez;
                            } else {
                                rez = "f" + rez;
                            }
                            break;
                        case 17:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else if (vmesni == 12) {
                                rez = "c" + rez;
                            } else if (vmesni == 13) {
                                rez = "d" + rez;
                            } else if (vmesni == 14) {
                                rez = "e" + rez;
                            } else if (vmesni == 15) {
                                rez = "f" + rez;
                            } else {
                                rez = "g" + rez;
                            }
                            break;
                        case 18:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else if (vmesni == 12) {
                                rez = "c" + rez;
                            } else if (vmesni == 13) {
                                rez = "d" + rez;
                            } else if (vmesni == 14) {
                                rez = "e" + rez;
                            } else if (vmesni == 15) {
                                rez = "f" + rez;
                            } else if (vmesni == 16) {
                                rez = "g" + rez;
                            } else {
                                rez = "h" + rez;
                            }
                            break;
                        case 19:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else if (vmesni == 12) {
                                rez = "c" + rez;
                            } else if (vmesni == 13) {
                                rez = "d" + rez;
                            } else if (vmesni == 14) {
                                rez = "e" + rez;
                            } else if (vmesni == 15) {
                                rez = "f" + rez;
                            } else if (vmesni == 16) {
                                rez = "g" + rez;
                            } else if (vmesni == 17) {
                                rez = "h" + rez;
                            } else {
                                rez = "i" + rez;
                            }
                            break;
                        case 20:
                            if (vmesni < 10) {
                                rez = rez + String.valueOf(vmesni);
                            } else if (vmesni == 10) {
                                rez = "a" + rez;
                            } else if (vmesni == 11) {
                                rez = "b" + rez;
                            } else if (vmesni == 12) {
                                rez = "c" + rez;
                            } else if (vmesni == 13) {
                                rez = "d" + rez;
                            } else if (vmesni == 14) {
                                rez = "e" + rez;
                            } else if (vmesni == 15) {
                                rez = "f" + rez;
                            } else if (vmesni == 16) {
                                rez = "g" + rez;
                            } else if (vmesni == 17) {
                                rez = "h" + rez;
                            } else if (vmesni == 18) {
                                rez = "i" + rez;
                            } else {
                                rez = "j" + rez;
                            }
                            break;
                        default:
                            rez = String.valueOf(vmesni) + rez;
                            break;
                    }
                } 
            } else {
                rez = Integer.toString(a) + rez;
            }
            return rez;
        }
    }
}