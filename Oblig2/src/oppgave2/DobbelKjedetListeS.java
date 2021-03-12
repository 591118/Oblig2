package oppgave2;

public class DobbelKjedetListeS<T extends Comparable<T>> {

	private DobbelNode<T> foerste, siste;
	private int antall;

	public DobbelKjedetListeS() {

	}

	public DobbelKjedetListeS(T minVerdi, T maksVerdi) {

		DobbelNode<T> min = new DobbelNode<T>(minVerdi);
		foerste = min;

		DobbelNode<T> max = new DobbelNode<T>(minVerdi);
		siste = max;

		min.setNeste(max);
		max.setForrige(min);

		antall = 0;
	}

	public void leggTil(T ny) {
		DobbelNode<T> aktuell = foerste;
		DobbelNode<T> nye = new DobbelNode<T>(ny);
		boolean lagtTil = false;

		while (!lagtTil) {
			if (ny.compareTo(nye.getElement()) > 0) {
				nye.setForrige(aktuell);
				nye.setNeste(aktuell.getNeste());
				aktuell.getNeste().setForrige(nye);
				aktuell.setNeste(nye);
				lagtTil = true;
			}
			if (lagtTil == false)
				aktuell.getNeste();
		}
		antall++;
	}

	public T fjern(T element) {
		DobbelNode<T> aktuell = foerste;
		boolean slettet = false;

		while (!slettet && aktuell.getNeste() != null) {
			if (antall == 0) {
				System.out.println("Tomt!");
				return null;
			}
			if (antall == 1 && element == aktuell.getElement()) {
				foerste.setNeste(siste);
				siste.setForrige(foerste);
				antall--;
				aktuell = null;

				return element;
			}

			if (element == siste.getForrige().getElement()) {

				aktuell = siste.getForrige();
				aktuell.getForrige().setNeste(siste);
				siste.setForrige(aktuell.getForrige());
				antall--;
				aktuell = null;

				return element;
			}

			if (antall >= 2 && element == aktuell.getElement()) {

				aktuell.getNeste().setForrige(aktuell.getForrige());
				aktuell.getForrige().setNeste(aktuell.getNeste());
				antall--;
				aktuell = null;

				return element;
			}
			aktuell.getNeste();
		}
		System.out.println("Fant ikke!");
		return null;
	}

	public boolean fins(T element) {
		DobbelNode<T> aktuell = foerste;
		boolean funnet = false;
		int a = 0;

		while (!funnet && a < antall) {
			if (aktuell.getElement().compareTo(element) == 0)
				funnet = true;
			a++;
			aktuell.getNeste();
		}
		return funnet;
	}

	public void visListe() {
		int a = 0;
		DobbelNode<T> aktuell = foerste.getNeste();

		while (a < antall) {
			System.out.println(aktuell);
			a++;
			aktuell.getNeste();
		}
	}
}