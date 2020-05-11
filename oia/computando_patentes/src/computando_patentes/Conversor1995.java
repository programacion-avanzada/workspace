package computando_patentes;

public class Conversor1995 extends Conversor {
	@Override
	protected long getNumero(String patente) {
		char[] p = patente.toCharArray();
		long n = 0;
		n += (p[5] - 48);
		n += (p[4] - 48) * 10;
		n += (p[3] - 48) * 100;
		n += (p[2] - 65) * 1_000;
		n += (p[1] - 65) * 26_000;
		n += (p[0] - 65) * 676_000;
		return n;
	}

	@Override
	protected String getPatente(long n) {
		char[] p = new char[6];
		p[0] = (char) (n / 676_000 + 65);
		n %= 676_000;
		p[1] = (char) (n / 26_000 + 65);
		n %= 26_000;
		p[2] = (char) (n / 1_000 + 65);
		n %= 1_000;
		p[3] = (char) (n / 100 + 48);
		n %= 100;
		p[4] = (char) (n / 10 + 48);
		n %= 10;
		p[5] = (char) (n + 48);

		return new String(p);
	}
}
