package edu.unlam.progava.oop;

public class FibonacciRecursivo implements Fibonacci {

	public long fib(int n) {
		// System.out.println("Ejecuté para N=" + n);
		if (n < 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
	
}
