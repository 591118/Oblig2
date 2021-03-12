package no.hvl.dat102;

public class Sorteringsmetoder {


	public static void main(String[] args) {
		Integer[] tab = { 7, 3, 1, 9, 2, 4 };
		// utvalgsSortering(tab);
		// sorteringVedInnsetting(tab);
		// bobleSortering(tab);
		fletteSort(tab, 0, tab.length - 1);
		// kvikkSort(tab, 0, tab.length - 1);

		for (Integer e : tab) {
			System.out.print(e + " ");
		}

		System.out.println();

	}
}
