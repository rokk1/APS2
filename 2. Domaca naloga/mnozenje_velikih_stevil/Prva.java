import java.util.*;
public class Prva {

    public static Scanner in = new Scanner(System.in);

    public static int rezultat = 0;

    public static void main(String[] args) {
        String alg = in.next();
        int baza = in.nextInt();
        int prvo = in.nextInt();
        int drugo = in.nextInt();
        int _1 = prvo;
        int _2 = drugo;
        if (alg.equals("os")) {
            
            int dolzinaDrugega = vrniDolzinoStevila(drugo);
            int[] drugoStevilo = new int[dolzinaDrugega];
            for (int i = dolzinaDrugega - 1; i >= 0; i--) {
                drugoStevilo[i] = drugo%10;
                drugo = drugo/10;
            }

            int dolzinaPrvega = vrniDolzinoStevila(prvo);
            int[] prvoStevilo = new int[dolzinaPrvega];
            for (int i = dolzinaPrvega - 1; i >= 0; i--) {
                prvoStevilo[i] = prvo%10;
                prvo = prvo/10;
            }
            
            // Zdaj izracunaj vmesne korake/rezultate

            // Prvo stevilo zmnozimo z vsemi stevkami drugega, potem pa 
            // sestej vsa dobljena stevila - seveda ustrezno zamaknjena.
            int[] vmesni = new int[dolzinaPrvega];
            int[] celiRezultat = new int[dolzinaPrvega + dolzinaDrugega];
            int index = dolzinaPrvega;
            int prejsnjiIndex = dolzinaPrvega;
            for (int i = 0; i < dolzinaDrugega; i++) {
                
                for (int j = dolzinaPrvega - 1; j >= 0; j--) {
                    int vrednost = prvoStevilo[j] * drugoStevilo[i];
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
            int dolzinaDrugega = vrniDolzinoStevila(drugo);
            int dolzinaPrvega = vrniDolzinoStevila(prvo);
            int daljsi = vrniDaljsega(dolzinaPrvega, dolzinaDrugega);
            if (daljsi%2 != 0) {
                daljsi = daljsi + 1;
            }


            
            int[] drugoStevilo = new int[daljsi];
            for (int i = daljsi - 1; i >= 0; i--) {
                drugoStevilo[i] = drugo%10;
                drugo = drugo/10;
            }
            int[] prvoStevilo = new int[daljsi];
            for (int i = daljsi - 1; i >= 0; i--) {
                prvoStevilo[i] = prvo%10;
                prvo = prvo/10;
            }
            
            System.out.printf("%d %d\n", _1, _2);
            int[] rezultat = deliRek(prvoStevilo, drugoStevilo, baza);
            Izpisi(rezultat);
            //System.out.println("Prvo stevilo: ");
            //Izpisi(prvoStevilo);
            //System.out.println("Drugo stevilo: ");
            //Izpisi(drugoStevilo);
            //deliRek(prvoStevilo, drugoStevilo);
             

        } else {
            // Algoritem je karatsuba - alg = "ka"
            return;
        }
    }

    public static int vrniDaljsega(int a, int b) {
        int daljsi = (a >= b ? a : b);
        return daljsi;
    }

    public static int[] deliRek(int[] a, int[] b, int baza) {

        if (a.length == 2) {
            if (a[0] == 0) {
                if (a[1] == 0) {
                    int[] novo = new int[1];
                    novo[0] = 0;
                    return novo;
                } else {
                    int stevka = a[1];
                    int ostanek = 0;
                    for (int i = b.length - 1; i >= 0; i--) {
                        b[i] = b[i] * stevka + ostanek;
                        ostanek = b[i] / baza;
                        b[i] = b[i] / baza;
                    }
                    if (ostanek > 0) {
                        int[] tmp = new int[b.length + 1];
                        for (int i = tmp.length - 1; i >= 1; i--) {
                            tmp[i] = b[i - 1];
                        }
                        tmp[0] = ostanek;
                        b = tmp;
                    }
                    return b;
                }
            } else {
                return b;
            }
        } else if (b.length == 2) {
            if (b[1] == 0) {
                int[] novo = new int[1];
                novo[0] = 0;
                return novo;
            } else {
                int stevka = b[1];
                int ostanek = 0;
                for (int i = a.length - 1; i >= 0; i--) {
                    a[i] = a[i] * stevka + ostanek;
                    ostanek = a[i] / baza;
                    a[i] = a[i] / baza;
                }
                if (ostanek > 0) {
                    int[] tmp = new int[a.length + 1];
                    for (int i = tmp.length - 1; i >= 1; i--) {
                        tmp[i] = a[i - 1];
                    }
                    tmp[0] = ostanek;
                    a = tmp;
                }
                return a;
            }
        } else {
            int[] num1 = a;
            int[] num2 = b;
            
                        

            //Izpisi(num1);
            //Izpisi(num2);

            int[] a0 = new int[num1.length/2];
            int[] b0 = new int[num2.length/2];
            int[] a1 = new int[num1.length/2];
            int[] b1 = new int[num2.length/2];

            for (int i = a0.length - 1; i >= 0; i--) {
                a1[i] = num1[i];
                a0[i] = num1[i + num1.length/2];
            }

            for (int i = b0.length - 1; i >= 0; i--) {
                b1[i] = num2[i];
                b0[i] = num2[i + num2.length/2];
            }

            
            a0 = podaljsaj(a0);
            b0 = podaljsaj(b0);
            a1 = podaljsaj(a1);
            b1 = podaljsaj(b1);


            Izpisi(a0);
            System.out.print(" ");
            Izpisi(b0);
            System.out.println();
            int[] a0b0 = deliRek(a0, b0, baza);
            Izpisi(a0);
            System.out.print(" ");
            Izpisi(b1);
            System.out.println();
            int[] a0b1 = deliRek(a0, b1, baza);
            Izpisi(a1);
            System.out.print(" ");
            Izpisi(b0);
            System.out.println();
            int[] a1b0 = deliRek(a1, b0, baza);
            Izpisi(a1);
            System.out.print(" ");
            Izpisi(b1);
            System.out.println();
            int[] a1b1 = deliRek(a1, b1, baza);
            System.out.println();

            return null;

        }
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

    public static int[] vrniTabelo(int a) {
        int st = a;
        int dolzinaStevila = vrniDolzinoStevila(a);
        if (dolzinaStevila % 2 != 0) {
            dolzinaStevila++;
        }
        int[] stevilo = new int[dolzinaStevila];
            for (int i = dolzinaStevila - 1; i >= 0; i--) {
                stevilo[i] = a%10;
                a = a/10;
            }
        return stevilo;
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
        //System.out.println();
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