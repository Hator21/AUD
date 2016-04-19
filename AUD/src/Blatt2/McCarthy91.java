package Blatt2;

public class McCarthy91 {

	public static int mcCarthy(int n) {
		//System.out.println(n);
		if (n > 100) {
			return n - 10;
		} else {
			//System.out.println("Rekusion!");
			return mcCarthy(mcCarthy(n + 11));			
		}
	}

	public static void main(String[] args) {
		int N = 15;
		System.out.println(mcCarthy(N));
	}
}
// Gilt nur solange n<102