package Praktikum2ADS;

public class McCarthy91 {
	public static int doMcCarthy91(int value) {
		//System.out.println(n);
		if (value > 100) {
			return value - 10;
		} else {
			//System.out.println("Rekusion!");
			return doMcCarthy91(doMcCarthy91(value + 11));
		}
	}

	public static void main(String[] args) {
		int N = 15;
		System.out.println(doMcCarthy91(N));
	}
}
