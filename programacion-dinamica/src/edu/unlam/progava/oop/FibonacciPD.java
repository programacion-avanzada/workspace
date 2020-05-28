package edu.unlam.progava.oop;

public class FibonacciPD implements Fibonacci {
	
	public long fib(int n) {
		Long[] fibo = new Long[10000];
		fibo[0] = 1L;
		fibo[1] = 1L;
		return fib(n, fibo);
	}

	private long fib(int n, Long[] fibo) {
		System.out.println("Ejecuté para N=" + n);
		if (fibo[n] == null)
			fibo[n] = fib(n - 1, fibo) + fibo[n - 2];
		return fibo[n];
	}

}
