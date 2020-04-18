import java.util.*;

public class Izziv7 {

	public static String rez = "";

	public static boolean is = false;

	public static boolean first = true;
	public static int last = 0;

	public static Scanner in = new Scanner(System.in);
	public static int[][] x;

	public static void main(String[] args) {

		int k = in.nextInt();
		int n = k;
		

		PKE(n, findNextPrime(n + 1));
		System.out.println(rez);
		Izpisi(x);
		
	}

	public static void Izpisi(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.printf("%2d ", a[j][i]);
			}
			System.out.println();
		}
	}
	
	public static void Izpisi1(int[][] a, int min, int delitelj) {
		for (int m = 0; m < a.length; m++) {
			for (int l = 0; l < a.length; l++) {
				a[l][m] = (int)Math.pow(min, m*l)%delitelj;
			}
		}
		//Izpisi(a);
	}
	
	public static void PKE(int n, int delitelj) {
		
		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < delitelj; i++) {
			int remainder = (int)Math.pow(i, n)%delitelj;
			if (remainder == 1) {
				is = true;
				for (int z = 1; z < n; z++) {
					int ostanek = (int)Math.pow(i, z)%delitelj;
					if (ostanek == 1) {
						is = false;
						break;
					} else {

						
						if (i != last) {
							rez = rez + Integer.toString(i) + " ";	
						}
						last = i;
						sum++;
						if (i < min) {
							min = i;
						}
					}
				}
			}
		}
		if (first) {
			System.out.printf("%d: ", delitelj);
			x = new int[n][n];
			Izpisi1(x, min, delitelj);
		}
		if (sum == 0) {
			PKE(n, findNextPrime(delitelj + 1));
		}
		first = false;
	}

	public static int findNextPrime(int x) {
		while (true) {
			int numOfDivisors = 0;
			for (int i = 1; i <= x; i++) {
				if (x % i == 0) {
					numOfDivisors++;
				}
			}
			if (numOfDivisors == 2) {
				return x;
			} else {
				x++;
			}
		}
	}
}