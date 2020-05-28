package edu.unlam.progava.oop;

public class FibonacciPDMejorado implements Fibonacci {

	private static Long[] fibo;
	
	public FibonacciPDMejorado() {
		fibo = new Long[10000];
		fibo[0] = 1L;
		fibo[1] = 1L;
	}

	public long fib(int n) {
		// System.out.println("Ejecuté para N=" + n);
		if (fibo[n] == null)
			fibo[n] = fib(n - 1) + fibo[n - 2];
		return fibo[n];
	}

}
