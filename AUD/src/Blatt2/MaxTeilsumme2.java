package Blatt2;

import java.util.Random;

public class MaxTeilsumme2 {
	private static int[] folge = new int[3000];
	private static int n = folge.length;
	private static long von, bis, additionen, maxsumme, summe;

	static Random random = new Random();

	public static void randomfolge(int n) {
		int z = 0;
		for (int j = 0; j < n; j++) {
			// int randomNumber = (random.nextInt(60) - 31);
			folge[j] = z;
			z++;
		}
	}

	public static void main(String[] args) {
		randomfolge(n);

		maxsumme = Integer.MIN_VALUE;
		von = 0;
		bis = 0;
		long time = -System.nanoTime();

		for (int i = 0; i < n; i++) {
			summe = 0;
			// System.out.println("\n");
			for (int j = 0; j < i; j++) {
				summe += folge[j];
				additionen += 1;
				if (summe > maxsumme) {
					maxsumme = summe;
					bis = n-1;
				}
			}
		}
		long time2 = time + System.nanoTime();
		Long l = new Long(time2);
		double ms = l.doubleValue() / 1000000;
		double sec = l.doubleValue() / 1000000000;
		System.out.println("max. Teilsumme: " + maxsumme);
		System.out.println("erster Index: " + von);
		System.out.println("letzter: " + bis);
		System.out.println("Additionen: " + additionen);
		System.out.println(time2 + "ns = " + ms + "ms = " + sec + "s");
	}
}
