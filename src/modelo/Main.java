package modelo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// for (int string : calcularHilos(12)) {
		// System.out.println(string);
		// }
		// System.exit(1);
		long timeStart = System.currentTimeMillis();
		Factorial[] nums = null;
		List<Integer> lista = null;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("ingresa un numero"));
		if (numero > 0) {
			lista = calcularHilos(numero);
			nums = new Factorial[lista.size() - 1];

			for (int i = 0; i < nums.length; i++) {
				nums[i] = new Factorial(lista.get(lista.size() - i - 1) + 1, lista.get(lista.size() - i - 2));
				nums[i].setPriority(5);
				nums[i].start();
			}

			for (int j = 0; j < nums.length; j++)
				try {
					nums[j].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			BigInteger resultado = BigInteger.ONE;

			for (Factorial i : nums) {

				resultado = resultado.multiply(i.getFactorial());
			}
			long timeEnd = System.currentTimeMillis();

			JOptionPane.showMessageDialog(null, resultado.bitCount() + "   " + (timeEnd - timeStart) / 1000.0);

		}

	}

	private static List<Integer> calcularHilos(int num) {
		List<Integer> lista = new ArrayList<>();
		while (num > 50) {
			lista.add(num);
			num -= 50;
		}
		if (num != 0)
			lista.add(num);
		if (num != 1)
			lista.add(1);

		return lista;

	}

}
