package computando_patentes;

public class Conversor2016 extends Conversor {
	@Override
	protected long getNumero(String patente) {
		char[] p = patente.toCharArray();
		long n = 0;
		n += (p[6] - 65);
		n += (p[5] - 65) * 26;
		n += (p[4] - 48) * 676;
		n += (p[3] - 48) * 6_760;
		n += (p[2] - 48) * 67_600;
		n += (p[1] - 65) * 676_000;
		n += (p[0] - 65) * 17_576_000;
		return n;
	}

	@Override
	protected String getPatente(long n) {
		char[] p = new char[7];
		p[0] = (char) (n / 17_576_000 + 65);
		n %= 17_576_000;
		p[1] = (char) (n / 676_000 + 65);
		n %= 676_000;
		p[2] = (char) (n / 67_600 + 48);
		n %= 67_600;
		p[3] = (char) (n / 6_760 + 48);
		n %= 6_760;
		p[4] = (char) (n / 676 + 48);
		n %= 676;
		p[5] = (char) (n / 26 + 65);
		n %= 26;
		p[6] = (char) (n + 65);

		return new String(p);
	}
}
