package oppgave2;

public class KjedetKlient {

	private static DobbelKjedetListeS<String> listen;

	public static void main(String[] args) {

		listen = new <String>DobbelKjedetListeS("AAA", "ZZZ");

		String x = "Håkon ";
		String f = "Kake ";
		String c = "Fylla! ";
		String v = "invite ";
		String o = "og";

		listen.leggTil(x);
		listen.leggTil(v);
		listen.leggTil(c);
		listen.leggTil(o);
		listen.leggTil(f);

		listen.fins(f);
		listen.fins("Nå");

		listen.fjern(c);
		listen.fjern(f);

		listen.visListe();

	}

}
