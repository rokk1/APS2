import java.util.*;
public class Prva1 {

    public static Scanner in = new Scanner(System.in);

    public static int rezultat = 0;

    public static void main(String[] args) {
        String alg = in.next();
        int baza = in.nextInt();
        String prvo = in.next();
        String drugo = in.next();
        int[] st1 = toInt(prvo);
        int[] st2 = toInt(drugo);
        

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

            int[] stevilo1;
            int[] stevilo2;
            


            if (st1.length % 2 != 0) {
                stevilo1 = new int[st1.length + 1];

                for (int i = st1.length - 1; i >= 0; i--) {
                    stevilo1[i + 1] = st1[i];
                }
                stevilo1[0] = 0;

            } else {
                stevilo1 = st1;
            }
            if (st2.length % 2 != 0) {
                stevilo2 = new int[st2.length + 1];

                for (int i = st2.length - 1; i >= 0; i--) {
                    stevilo2[i + 1] = st2[i];
                }
                stevilo2[0] = 0;
            } else {
                stevilo2 = st2;
            }
            
            int[] rez = divideAndConq(stevilo1, stevilo2, baza);
            print(rez, baza);
            

        } else {
            // Algoritem je karatsuba - alg = "ka"
            int[] stevilo1;
            int[] stevilo2;
            


            if (st1.length % 2 != 0) {
                stevilo1 = new int[st1.length + 1];

                for (int i = st1.length - 1; i >= 0; i--) {
                    stevilo1[i + 1] = st1[i];
                }
                stevilo1[0] = 0;

            } else {
                stevilo1 = st1;
            }
            if (st2.length % 2 != 0) {
                stevilo2 = new int[st2.length + 1];

                for (int i = st2.length - 1; i >= 0; i--) {
                    stevilo2[i + 1] = st2[i];
                }
                stevilo2[0] = 0;
            } else {
                stevilo2 = st2;
            }

            int[] rez = karacuba(stevilo1, stevilo2, baza);
            print(rez, baza);

            
            return;
        }
    }

    public static int[] karacuba(int[] a, int[] b, int baza) {
        a = normalize(a);
        b = normalize(b);
        print(a, baza);
        print(b, baza);
        System.out.println();

        //Izpisi(a);
        //Izpisi(b);
        
        if (a.length == 1) {
            if (a[0] == 0) {
                int[] rez = {0};
                return rez;
            }
            int[] rez = new int[1 + b.length];
            int carry = 0;
            for (int i = b.length - 1; i >= 0; i--) {
                
                rez[i + 1] = a[0] * b[i] + carry;
                
                carry = rez[i + 1] / baza;
                rez[i + 1] = rez[i + 1] % baza;
            }
            rez[0] = carry;
            rez = normalize(rez);
            
            return rez;
        }
        if (b.length == 1) {
            if (b[0] == 0) {
                int[] rez = {0};
                return rez;
            }
            int[] rez = new int[1 + a.length];
            int carry = 0;
            for (int i = a.length - 1; i >= 0; i--) {
                
                rez[i + 1] = b[0] * a[i] + carry;
                
                carry = rez[i + 1] / baza;
                rez[i + 1] = rez[i + 1] % baza;
            }
            rez[0] = carry;
            rez = normalize(rez);
            return rez;
        }

        if (a.length % 2 != 0) {
            a = podaljsaj(a);
        }
        if (b.length % 2 != 0) {
            b = podaljsaj(b);
        }

        //System.out.printf("dolzina a: %d, dolzina b: %d\n", a.length, b.length);
        if (a.length < b.length) {
            int count = b.length - a.length;
            a = expand(a, count);
        }
        if (b.length < a.length) {
            int count = a.length - b.length;
            b  = expand(b, count);
        }

        int[] a0 = x0(a);
        int[] a1 = x1(a);
        int[] b0 = x0(b);
        int[] b1 = x1(b);

        int stNicel = returnMax(a, b);

        int[] a0b0 = karacuba(a0, b0, baza);
        print(a0b0, baza);
        System.out.println();
        int[] a1b1 = karacuba(a1, b1, baza);
        print(a1b1, baza);
        System.out.println();
        int[] vsota1 = add(a0, a1, baza);
        int[] vsota2 = add(b0, b1, baza);
        int[] vsota = karacuba(vsota1, vsota2, baza);
        print(vsota, baza);
        System.out.println();

        return izracunajKa(a1b1, vsota, a0b0, stNicel, baza);
        
    }


    public static int[] izracunajKa(int[] a1b1, int[] vsota, int[] a0b0, int stNicel, int baza) {
        int[] x1 = new int[a1b1.length + stNicel];
        for (int i = 0; i < a1b1.length; i++) {
            x1[i] = a1b1[i];
        }

        int[] vmesni = subtract(vsota, a1b1, baza);
        vmesni = subtract(vmesni, a0b0, baza);

        int[] x2 = new int[vmesni.length + stNicel/2];
        for (int i = 0; i < vmesni.length; i++) {
            x2[i] = vmesni[i];
        }

        int[] x3 = a0b0;

        int[] sum = new int[returnMaxod3(x1, x2, x3) + 1];
        int index = sum.length - 1;
        for (int i = x1.length - 1; i >= 0; i--) {
            sum[index] += x1[i];
            index--;
        }
        index = sum.length - 1;
        for (int i = x2.length - 1; i >= 0; i--) {
            sum[index] += x2[i];
            index--;
        }
        index = sum.length - 1;
        for (int i = x3.length - 1; i >= 0; i--) {
            sum[index] += x3[i];
            index--;
        }

        int carry = 0;
        for (int i = sum.length - 1; i >= 1; i--) {
            sum[i] += carry;
            carry = sum[i] / baza;
            sum[i] %= baza;
        }

        sum[0] = carry;
        sum = normalize(sum);
        return sum;


    }

    public static int[] toInt(String x) {
        int[] a = new int[x.length()];
        for (int i = 0; i < a.length; i++) {
            char znak = x.charAt(i);
            a[i] = Character.getNumericValue(znak);
            //System.out.printf("znak: %c, a[i]: %d\n", znak, a[i]);
            
        }
        return a;
    }

    public static char[] print_1(int[] a, int baza) {
        char[] rez = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 10) {
                rez[i] = (char)(a[i] + '0');
            } else {
                if (a[i] == 10) {
                    rez[i] = 'a';
                } else if (a[i] == 11) {
                    rez[i] = 'b';
                }  else if (a[i] == 12) {
                    rez[i] = 'c';
                }  else if (a[i] == 13) {
                    rez[i] = 'd';
                }  else if (a[i] == 14) {
                    rez[i] = 'e';
                }  else if (a[i] == 15) {
                    rez[i] = 'f';
                }  else if (a[i] == 16) {
                    rez[i] = 'g';
                }  else if (a[i] == 17) {
                    rez[i] = 'h';
                }  else if (a[i] == 18) {
                    rez[i] = 'i';
                }  else if (a[i] == 19) {
                    rez[i] = 'j';
                } else {
                    rez[i] = 'k';
                }
            }
        }
        return rez;
    }

    public static int[] toArray(String a) {
        char[] num = a.toCharArray();
        int[] st = new int[num.length];
        for (int i = 0; i < st.length; i++) {
            st[i] = num[i] - '0';
        }
        return st;
    }

    public static int[] normalize(int[] a) {
        int index = 0;
        while (index < a.length - 1 && a[index] == 0) {
            a = Arrays.copyOfRange(a, 1, a.length);
        }
        return a;
    }

    public static int[] subtract(int[] a, int[] b, int baza) {
        int[] rez = a;
        int index = b.length - 1;
        int carry = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (index < 0) {
                break;
            }
            rez[i] = rez[i] - b[index];
            index--;
        }
        for (int i = rez.length - 1; i >= 0; i--) {
            //System.out.printf("rez[i]: %d, carry: %d\n", rez[i] ,carry);
            if (rez[i] < 0) {
                rez[i] = rez[i] + baza - carry;
                carry = 1;
            } else {
                rez[i] -= carry;
                carry = 0;
            }
        }
        return rez;
    }

    public static int[] divideAndConq(int[] a, int[] b, int baza) {
        a = normalize(a);
        b = normalize(b);
        print(a, baza);
        //System.out.printf("----------------------------------------------");
        print(b, baza);
        //System.out.printf("----------------------------------------------");
        System.out.println();
        //Izpisi(a);
        //Izpisi(b);
        if (a.length == 1 || b.length == 1) {
            if (a.length == 1) {
                if (a[0] == 0) {
                    int[] rez = {0};
                    return rez;
                }
                int[] rez = new int[1 + b.length];
                int carry = 0;
                for (int i = b.length - 1; i >= 0; i--) {
                    
                    rez[i + 1] = a[0] * b[i] + carry;
                    
                    carry = rez[i + 1] / baza;
                    rez[i + 1] = rez[i + 1] % baza;
                }
                rez[0] = carry;
                rez = normalize(rez);
                
                return rez;
            }
            if (b.length == 1) {
                if (b[0] == 0) {
                    int[] rez = {0};
                    return rez;
                }
                int[] rez = new int[1 + a.length];
                int carry = 0;
                for (int i = a.length - 1; i >= 0; i--) {
                    
                    rez[i + 1] = b[0] * a[i] + carry;
                    
                    carry = rez[i + 1] / baza;
                    rez[i + 1] = rez[i + 1] % baza;
                }
                rez[0] = carry;
                rez = normalize(rez);
                return rez;
            }
        }
                
        if (a.length % 2 != 0) {
            a = podaljsaj(a);
        }
        if (b.length % 2 != 0) {
            b = podaljsaj(b);
        }

        //System.out.printf("dolzina a: %d, dolzina b: %d\n", a.length, b.length);
        if (a.length < b.length) {
            int count = b.length - a.length;
            a = expand(a, count);
        }
        if (b.length < a.length) {
            int count = a.length - b.length;
            b  = expand(b, count);
        }

        int[] a0 = x0(a);
        int[] a1 = x1(a);
        int[] b0 = x0(b);
        int[] b1 = x1(b);

        int stNicel = returnMax(a, b);
        //System.out.printf("stNicel: %d\n", stNicel);
        int[] a0b0 = divideAndConq(a0, b0, baza);
        print(a0b0, baza);
        System.out.println();
        int[] a0b1 = divideAndConq(a0, b1, baza);
        print(a0b1, baza);
        System.out.println();
        int[] a1b0 = divideAndConq(a1, b0, baza);
        print(a1b0, baza);
        System.out.println();
        int[] a1b1 = divideAndConq(a1, b1, baza);
        print(a1b1, baza);
        System.out.println();

        return izracunaj(a0b0, a0b1, a1b0, a1b1, baza, stNicel);

    }

    public static int returnMaxod3(int[] a, int[] b, int[] c) {
        if (a.length >= b.length && a.length >= c.length) {
            return a.length;
        }
        if (b.length > a.length && b.length > c.length) {
            return b.length;
        }
        if (c.length > a.length && c.length > b.length) {
            return c.length;
        }
        return 0;
    }

    public static int[] izracunaj(int[] a0b0, int[] a0b1, int[] a1b0, int[] a1b1, int baza, int stNicel) {
        
        int[] x1 = new int[a1b1.length + stNicel];
        for (int i = 0; i < a1b1.length; i++) {
            x1[i] = a1b1[i];
        }
        
        int[] vmesni = add(a0b1, a1b0, baza);
        //System.out.printf("vmesni: \n");
        //Izpisi(vmesni);

        int[] x2 = new int[vmesni.length + stNicel/2];
        for (int i = 0; i < vmesni.length; i++) {
            x2[i] = vmesni[i];
        }

        int[] x3 = a0b0;

        int[] sum = new int[returnMaxod3(x1, x2, x3) + 1];
        int index = sum.length - 1;
        for (int i = x1.length - 1; i >= 0; i--) {
            sum[index] += x1[i];
            index--;
        }
        index = sum.length - 1;
        for (int i = x2.length - 1; i >= 0; i--) {
            sum[index] += x2[i];
            index--;
        }
        index = sum.length - 1;
        for (int i = x3.length - 1; i >= 0; i--) {
            sum[index] += x3[i];
            index--;
        }

        int carry = 0;
        for (int i = sum.length - 1; i >= 1; i--) {
            sum[i] += carry;
            carry = sum[i] / baza;
            sum[i] %= baza;
        }

        sum[0] = carry;
        sum = normalize(sum);
        return sum;

    }

    public static int[] add(int[] a, int[] b, int baza) {
        int[] longer = daljsi(a, b);
        int[] shorter = krajsi(a, b);
        int[] rez = new int[longer.length + 1];
        for (int i = longer.length - 1; i >= 0; i--) {
            rez[i + 1] += longer[i];
        }
        int index = rez.length - 1;
        for (int i = shorter.length - 1; i >= 0; i--) {
            rez[index] += shorter[i];
            index--;
        }
        int carry = 0;
        for (int i = rez.length - 1; i >= 1; i--) {
            rez[i] += carry;
            carry = rez[i]  / baza;
            rez[i] %= baza;
        }
        rez[0] = carry;
        rez = normalize(rez);
        return rez;
    }


    public static int[] x1(int[] a) {
        int[] rez = new int[a.length/2];
        for (int i = 0; i < rez.length; i++) {
            rez[i] = a[i];
        }
        return rez;
    }  

    public static int[] x0(int[] a) {
        int[] rez = new int[a.length/2];
        for (int i = 0; i < rez.length; i++) {
            rez[i] = a[i + rez.length];
        }
        return rez;
    }

    public static int[] podaljsaj(int[] a) {
        int[] rez = new int[a.length + 1];
        for (int i = a.length - 1; i >= 0; i--) {
            rez[i + 1] = a[i];
        }
        return rez;
    }

    public static int[] expand(int[] a, int count) {
        int[] rez = new int[a.length + count];
        for (int i = rez.length - 1; i >= count; i--) {
            rez[i] = a[i - count];
        }
        return rez;
    }

    public static int[] krajsi(int[] a, int[] b) {
        int[] shorter = (a.length < b.length ? a : b);
        return shorter;
    }

    public static int[] daljsi(int[] a, int[] b) {
        int[] longer = (a.length >= b.length ? a : b);
        return longer;
    }

    public static int returnMax(int[] a, int[] b) {
        int max = 0;
        max = (a.length >= b.length ? a.length : b.length);
        return max;
    }

    public static void print(int[] a, int baza) {
        char[] rez = print_1(a, baza);
        for (int i = 0; i < rez.length; i++) {
            System.out.printf("%c", rez[i]);
        }
        System.out.printf(" ");
    }

    public static int[] returnArray(int[] a, int baza) {
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
        return toArray(rez);
    }

    public static int vrniDaljsega(int a, int b) {
        int daljsi = (a >= b ? a : b);
        return daljsi;
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