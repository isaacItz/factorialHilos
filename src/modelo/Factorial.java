package modelo;

import java.math.BigInteger;

public class Factorial extends Thread {

	private int inicio;
	private int fin;
	private BigInteger f;

	public Factorial(int inicio, int fin) {
		this.inicio = inicio;
		this.fin = fin;
		f = BigInteger.valueOf(inicio);
	}

	public BigInteger getFactorial() {
		return f;
	}

	@Override
	public void run() {
		factorial();
		// System.out.println(f);
	}

	private void factorial() {
		for (int i = inicio + 1; i <= fin; i++)
			f = f.multiply(BigInteger.valueOf(i));

	}

}
