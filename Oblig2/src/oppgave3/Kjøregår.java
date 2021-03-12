package oppgave3;

public class Kjøregår<T> {

	public static <T extends Comparable<T>> boolean binsok(T[] tab, int min, int max, T el) {
		boolean funnet = false;
		int midt = (min + max) / 2;
		int resultat = el.compareTo(tab[midt]);

		if (max < min)
			funnet = false;

		else if (resultat == 0)
			funnet = true;

		else if (resultat < 0)
			return binsok(tab, min, midt - 1, el);
		else
			return binsok(tab, midt + 1, max, el);

		return funnet;
	}

	public static void main(String[] args) {

		Integer[] tab = { 2, 4, 5, 7, 8, 10, 12, 15, 18, 21, 23, 27, 29, 30, 31 };

		System.out.println(binsok(tab, 0, tab.length, 8));

		System.out.println(binsok(tab, 0, tab.length, 16));
	}
}