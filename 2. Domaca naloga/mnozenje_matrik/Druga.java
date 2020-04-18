import java.util.*;

public class Druga {

    public static Scanner in = new Scanner(System.in);

    public static int rezultat = 0;

    public static void main(String[] args) {
        String alg = in.next();
    
        if (alg.equals("os")) {
            int stVrstic1 = in.nextInt();
            int stStolpcev1 = in.nextInt();

            int[][] matrika1 = new int[stVrstic1][stStolpcev1];
            for (int i = 0; i < stVrstic1; i++) {
                for (int j = 0; j < stStolpcev1; j++) {
                    matrika1[i][j] = in.nextInt();
                }
            }


            int stVrstic2 = in.nextInt();
            int stStolpcev2 = in.nextInt();

            int[][] matrika2 = new int[stVrstic2][stStolpcev2];
            for (int i = 0; i < stVrstic2; i++) {
                for (int j = 0; j < stStolpcev2; j++) {
                    matrika2[i][j] = in.nextInt();
                }
            }
            
            int[][] rez = multiply(matrika1, matrika2);
            
            System.out.printf("DIMS: %dx%d\n", stVrstic1, stStolpcev2);
            Izpisi(rez);
        } else if (alg.equals("bl")) {

            int blockSize = in.nextInt();
            int stVrstic1 = in.nextInt();
            int stStolpcev1 = in.nextInt();
            int stVrstic1_1 = stVrstic1;
            int stStolpcev1_1 = stStolpcev1;
            if (stVrstic1_1 % blockSize != 0) {
                while (stVrstic1_1 % blockSize != 0) {
                    stVrstic1_1++;
                }
            }
            if (stStolpcev1_1 % blockSize != 0) {
                while (stStolpcev1_1 % blockSize != 0) {
                    stStolpcev1_1++;
                }
            }
            int[][] matrika1 = new int[stVrstic1_1][stStolpcev1_1];
            for (int i = 0; i < stVrstic1; i++) {
                for (int j = 0; j < stStolpcev1; j++) {
                    matrika1[i][j] = in.nextInt();
                }
            }


            int stVrstic2 = in.nextInt();
            int stStolpcev2 = in.nextInt();
            int stVrstic2_2 = stVrstic2;
            int stStolpcev2_2 = stStolpcev2;
            if (stVrstic2_2 % blockSize != 0) {
                while (stVrstic2_2 % blockSize != 0) {
                    stVrstic2_2++;
                }
            }
            if (stStolpcev2_2 % blockSize != 0) {
                while (stStolpcev2_2 % blockSize != 0) {
                    stStolpcev2_2++;
                }
            }

            int[][] matrika2 = new int[stVrstic2_2][stStolpcev2_2];
            for (int i = 0; i < stVrstic2; i++) {
                for (int j = 0; j < stStolpcev2; j++) {
                    matrika2[i][j] = in.nextInt();
                }
            }

            // Razdeli prvo matriko na bloke

            /*
            for (int i_a = 0; i_a < matrika1.length; i_a += blockSize) {
                for (int j_a = 0; j_a < matrika1[0].length; j_a += blockSize) {
                    for (int i_b = 0; i_b < matrika2.length; i_b += blockSize) {
                        for (int j_b = 0; j_b < matrika2[0].length; j_b += blockSize) {
                            int sum = 0;
                            for (int i = i_a; i < min(i_a + blockSize - 1, matrika1.length); i++) {
                                for (int j = j_b; j < min(j_b + blockSize - 1, matrika2[0].length); j++) {
                                    for (int k = 0; k < blockSize; k++) {
                                        sum += matrika1[i][k] * matrika2[k][j];
                                    }
                                }
                            }
                            System.out.printf("sum: %d\n", sum);
                        }
                    }
                }
            }
            */
        
            for (int i0 = 0; i0 < matrika1[0].length; i0 += blockSize) {
                for (int j0 = 0; j0 < matrika2.length; j0 += blockSize) {
                    System.out.printf("j0: %d\n", j0);
                    for (int k0 = 0; k0 < matrika1[0].length; k0 += blockSize) {
                        int[][] rez = new int[stVrstic1][stStolpcev2];
                        int sum = 0;
                        for (int i = i0; i < min(i0 + blockSize, matrika1[0].length); i++) {
                            for (int j = j0; j < min(j0 + blockSize, matrika2.length); j++) {
                                for (int k = k0; k < min(k0 + blockSize, matrika1[0].length); k++) {
                                    //System.out.printf("%d * %d = %d\n", matrika1[i][k], matrika2[k][j], matrika1[i][k] * matrika2[k][j]);
                                    System.out.printf("i0: %d, j0: %d, k0: %d, i: %d, j: %d, k: %d\n", i0, j0, k0, i, j, k);
                                    rez[i][j] += matrika1[i][k] * matrika2[k][j];
                                    sum += matrika1[i][k] * matrika2[k][j];
                                }
                            }
                        }
                        System.out.printf("sum: %d\n", sum);
                        Izpisi(rez);
                    }
                }
            }

            Izpisi(matrika1);
            Izpisi(matrika2);
            

            
            System.out.printf("DIMS: %dx%d\n", stVrstic1, stStolpcev2);

        
        } else if (alg.equals("dv")) {
            // Primitiven deli in vladaj algoritem za mnozenje matrik
            int blockSize = in.nextInt();

            int stVrstic1 = in.nextInt();
            int stStolpcev1 = in.nextInt();

            int[][] matrika = new int[stVrstic1][stStolpcev1];
            for (int i = 0; i < stVrstic1; i++) {
                for (int j = 0; j < stStolpcev1; j++) {
                    matrika[i][j] = in.nextInt();
                }
            }

            int max = returnMax(stVrstic1, stStolpcev1);

            
            int stVrstic2 = in.nextInt();
            int stStolpcev2 = in.nextInt();

            int[][] matrika2 = new int[stVrstic2][stStolpcev2];
            for (int i = 0; i < stVrstic2; i++) {
                for (int j = 0; j < stStolpcev2; j++) {
                    matrika2[i][j] = in.nextInt();
                }
            }
            

            int max2 = returnPower(matrika, matrika2);

            int[][] nova_matrika1 = new int[max2][max2];
            int[][] nova_matrika2 = new int[max2][max2];
            

            for (int i = 0; i < stVrstic1; i++) {
                for (int j = 0; j < stStolpcev1; j++) {
                    nova_matrika1[i][j] = matrika[i][j];
                } 
            }
            for (int i = 0; i < stVrstic2; i++) {
                for (int j = 0; j < stStolpcev2; j++) {
                    nova_matrika2[i][j] = matrika2[i][j];
                } 
            }
            

            int[][] rez = izracunajProdukt(nova_matrika1, nova_matrika2, blockSize);

            System.out.printf("DIMS: %dx%d\n", nova_matrika1.length, nova_matrika1.length);
            Izpisi(rez);


        } else {
            // Strassen

            int blockSize = in.nextInt();

            int stVrstic1 = in.nextInt();
            int stStolpcev1 = in.nextInt();

            int[][] matrika = new int[stVrstic1][stStolpcev1];
            for (int i = 0; i < stVrstic1; i++) {
                for (int j = 0; j < stStolpcev1; j++) {
                    matrika[i][j] = in.nextInt();
                }
            }

            int max = returnMax(stVrstic1, stStolpcev1);

            
            int stVrstic2 = in.nextInt();
            int stStolpcev2 = in.nextInt();

            int[][] matrika2 = new int[stVrstic2][stStolpcev2];
            for (int i = 0; i < stVrstic2; i++) {
                for (int j = 0; j < stStolpcev2; j++) {
                    matrika2[i][j] = in.nextInt();
                }
            }

            int max2 = returnPower(matrika, matrika2);

            int[][] nova_matrika1 = new int[max2][max2];
            int[][] nova_matrika2 = new int[max2][max2];

            for (int i = 0; i < stVrstic1; i++) {
                for (int j = 0; j < stStolpcev1; j++) {
                    nova_matrika1[i][j] = matrika[i][j];
                } 
            }
            for (int i = 0; i < stVrstic2; i++) {
                for (int j = 0; j < stStolpcev2; j++) {
                    nova_matrika2[i][j] = matrika2[i][j];
                } 
            }
            
            int[][] rez = strassen(nova_matrika1, nova_matrika2, blockSize);
            //System.out.printf("%d\n", vrniVsoto(rez));
            
            System.out.printf("DIMS: %dx%d\n", nova_matrika1.length, nova_matrika1.length);
            Izpisi(rez);
        }
    }

    public static int[][] add(int[][] a, int[][] b) {
        int[][] rez = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                rez[i][j] = a[i][j] + b[i][j];
            }
        }
        return rez;
    }
    
    public static int[][] subtract(int[][] a, int[][] b) {
        int[][] rez = new int[a[0].length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                rez[i][j] = a[i][j] - b[i][j];
            }
        }
        return rez;
    }

    public static int[][] strassen(int[][] a, int[][] b, int velikost) {
        if (a.length == velikost) {
            int[][] rez = multiply(a, b);
            return rez;
        } else {
            
            int size = a.length/2;
            
            int[][] a11 = new int[size][size];
            int[][] a12 = new int[size][size];
            int[][] a21 = new int[size][size];
            int[][] a22 = new int[size][size];
            int[][] b11 = new int[size][size];
            int[][] b12 = new int[size][size];
            int[][] b21 = new int[size][size];
            int[][] b22 = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    a11[i][j] = a[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = size; j < 2*size; j++) {
                    a22[i-size][j-size] = a[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = 0; j < size; j++) {
                    a21[i-size][j] = a[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = size; j < 2*size; j++) {
                    a12[i][j - size] = a[i][j];
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    b11[i][j] = b[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = size; j < 2*size; j++) {
                    b22[i-size][j-size] = b[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = 0; j < size; j++) {
                    b21[i-size][j] = b[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = size; j < 2*size; j++) {
                    b12[i][j - size] = b[i][j];
                }
            }
            
            int[][] tmp1 = new int[size][size];
            int[][] tmp2 = new int[size][size];

            tmp1 = subtract(b12, b22);
            int[][] p1 = strassen(a11, tmp1, velikost);
            

            System.out.printf("%d\n", vrniVsoto(p1));
            tmp1 = add(a11, a12);
            int[][] p2 = strassen(tmp1, b22, velikost);
                        
            System.out.printf("%d\n", vrniVsoto(p2));
            tmp1 = add(a21, a22);
            int[][] p3 = strassen(tmp1, b11, velikost);
            
            System.out.printf("%d\n", vrniVsoto(p3));
            tmp1 = subtract(b21, b11);
            int[][] p4 = strassen(a22, tmp1, velikost);
                        
            System.out.printf("%d\n", vrniVsoto(p4));
            tmp1 = add(a11, a22);
            tmp2 = add(b11, b22);
            
            int[][] p5 = strassen(tmp1, tmp2, velikost);
            
            System.out.printf("%d\n", vrniVsoto(p5));
            tmp1 = subtract(a12, a22);
            tmp2 = add(b21, b22);
            int[][] p6 = strassen(tmp1, tmp2, velikost);
            
            System.out.printf("%d\n", vrniVsoto(p6));
            tmp1 = subtract(a11, a21);
            tmp2 = add(b11, b12);
            int[][] p7 = strassen(tmp1, tmp2, velikost);
            

            System.out.printf("%d\n", vrniVsoto(p7));

            return izracunajDelne(p1, p2, p3, p4, p5, p6, p7, size);
            
            /*

            [x1    x2 ]
            
            [x3    x4 ]
            
            */
        }
    }

    public static int[][] izracunajDelne(int[][] p1, int[][] p2, int[][] p3, int[][] p4, int[][] p5, int[][] p6, int[][] p7, int velikost) {
        

        int size = p1.length * 2;
        int[][] x1 = add(subtract(add(p5, p4), p2), p6);
        int[][] x2 = add(p1, p2);
        int[][] x3 = add(p3, p4);
        int[][] x4 = subtract(subtract(add(p1, p5), p3), p7);
        int[][] rez = new int[size][size];
        //System.out.printf("size: %d, x1.len: %d, x2.len: %d, x3.len: %d, x4.len: %d\n", size, x1.length, x2.length, x3.length, x4.length);
        int x = x1.length;
        for (int i = 0; i < x1.length; i++) {
            for (int j = 0; j < x1.length; j++) {
                rez[i][j] = x1[i][j];
            }
        }
        for (int i = 0; i < x1.length; i++) {
            for (int j = 0; j < x1.length; j++) {
                rez[i][j + x] = x2[i][j];
            }
        }
        for (int i = 0; i < x1.length; i++) {
            for (int j = 0; j < x1.length; j++) {
                rez[i + x][j] = x3[i][j];
            }
        }
        for (int i = 0; i < x1.length; i++) {
            for (int j = 0; j < x1.length; j++) {
                rez[i + x][j + x] = x4[i][j];
            }
        }
        return rez;
    }

    public static int[][] izracunajProdukt(int[][] a, int[][] b, int velikost) {
        if (a.length == velikost) {
            int[][] rez = multiply(a, b);
            return rez;
        } else {

            
            
            int size = a.length/2;
            int[][] a11 = new int[size][size];
            int[][] a12 = new int[size][size];
            int[][] a21 = new int[size][size];
            int[][] a22 = new int[size][size];
            int[][] b11 = new int[size][size];
            int[][] b12 = new int[size][size];
            int[][] b21 = new int[size][size];
            int[][] b22 = new int[size][size];

            // Izracunamo/prepisemo delne matrike

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    a11[i][j] = a[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = size; j < 2*size; j++) {
                    a22[i-size][j-size] = a[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = 0; j < size; j++) {
                    a21[i-size][j] = a[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = size; j < 2*size; j++) {
                    a12[i][j - size] = a[i][j];
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    b11[i][j] = b[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = size; j < 2*size; j++) {
                    b22[i-size][j-size] = b[i][j];
                }
            }
            for (int i = size; i < 2*size; i++) {
                for (int j = 0; j < size; j++) {
                    b21[i-size][j] = b[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = size; j < 2*size; j++) {
                    b12[i][j - size] = b[i][j];
                }
            }

            
            int[][] a11b11 = izracunajProdukt(a11, b11, velikost);
            System.out.printf("%d\n", vrniVsoto(a11b11));
            int[][] a12b21 = izracunajProdukt(a12, b21, velikost);
            System.out.printf("%d\n", vrniVsoto(a12b21));
            int[][] a11b12 = izracunajProdukt(a11, b12, velikost);
            System.out.printf("%d\n", vrniVsoto(a11b12));
            int[][] a12b22 = izracunajProdukt(a12, b22, velikost);
            System.out.printf("%d\n", vrniVsoto(a12b22));
            int[][] a21b11 = izracunajProdukt(a21, b11, velikost);
            System.out.printf("%d\n", vrniVsoto(a21b11));
            int[][] a22b21 = izracunajProdukt(a22, b21, velikost);
            System.out.printf("%d\n", vrniVsoto(a22b21));
            int[][] a21b12 = izracunajProdukt(a21, b12, velikost);
            System.out.printf("%d\n", vrniVsoto(a21b12));
            int[][] a22b22 = izracunajProdukt(a22, b22, velikost);
            System.out.printf("%d\n", vrniVsoto(a22b22));
            

        
            int velikost1 = size * 2;
            int x = size;
            int[][] vrnjena = new int[velikost1][velikost1];
            int[][] x1 = add(a11b11, a12b21);
            int[][] x2 = add(a11b12, a12b22);
            int[][] x3 = add(a21b11, a22b21);
            int[][] x4 = add(a21b12, a22b22);

            for (int i = 0; i < x1.length; i++) {
                for (int j = 0; j < x1.length; j++) {
                    vrnjena[i][j] = x1[i][j];
                }
            }
            for (int i = 0; i < x1.length; i++) {
                for (int j = 0; j < x1.length; j++) {
                    vrnjena[i][j + x] = x2[i][j];
                }
            }
            for (int i = 0; i < x1.length; i++) {
                for (int j = 0; j < x1.length; j++) {
                    vrnjena[i + x][j] = x3[i][j];
                }
            }
            for (int i = 0; i < x1.length; i++) {
                for (int j = 0; j < x1.length; j++) {
                    vrnjena[i + x][j + x] = x4[i][j];
                }
            }


            
            return vrnjena;
        }
    }

    public static int vrniVsoto(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }

    public static int returnMax(int a, int b) {
        return (a >= b ? a : b);
    }

    public static int returnPower(int[][] a, int[][] b) {
        int max1 = returnMax(a.length, a[0].length);
        int max2 = returnMax(b.length, b[0].length);

        int max = returnMax(max1, max2);
        int potenca = 2;
        while (max > potenca) {
            potenca *= 2;
        }
        return potenca;
    } 
    
    public static int blocneMatrike(int[][] a, int[][] b, int i_a, int j_a, int i_b, int j_b, int blockSize) {
        if (i_a >= a.length) {
            return 0;
        }
        if (j_b >= b[0].length) {
            return 0;
        }

        int sum = 0;
        for (int i = i_a; i < i_a + blockSize; i++) {
            for (int j = j_b; j < j_b + blockSize; j++) {
                for (int k = 0; k < blockSize; k++) {
                    System.out.printf("%d * %d = %d \n", a[i][k], b[k][j], a[i][k] * b[k][j]);
                    sum += a[i][k] * b[k][j];
                }
            }
        }
        System.out.printf("sum: %d\n", sum);
        return blocneMatrike(a, b, i_a + blockSize, j_a, i_b, j_b + blockSize, blockSize);
    }

    public static int max(int a, int b) {
        int maks = (a >= b ? a : b);
        return maks;
    }

    public static int min(int a, int b) {
        return (a <= b ? a : b);
    }

    /*
    public static int[] multiplyRec(int[][] a, int[][] b, int velikost, int i_a, int j_a, int i_b, int j_b) {
        if (velikost == 1) {
            return a[i_a][j_a] * b[i_b][j_b];
        } else {
            int size = velikost/2;
            int[][] a11 = multiplyRec(a, b, size);
        }
    }
    */

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] rez = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    rez[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return rez;
    }

    public static int returnSum(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }
    
    public static void Izpisi(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}
