package edu.unlam.progava.oop;

public class Prueba {
	
	private static Fibonacci fibonacci;
	
	public static void main(String[] args) {
		// fibonacci = new FibonacciRecursivo();
		fibonacci = new FibonacciPD();
		//fibonacci = new FibonacciPDMejorado();
		
		ejemplo1();
		ejemplo2();
		ejemplo3(); // ¿Qué pasa con FibonacciRecursivo?
		//ejemplo4();
		//ejemplo5();
	}
	
	public static void ejemplo1() {
		System.out.println("Inició ejemplo 1");
		System.out.println(fibonacci.fib(6));
	}
	
	public static void ejemplo2() {
		System.out.println("Inició ejemplo 2");
		System.out.println(fibonacci.fib(10));
		System.out.println(fibonacci.fib(20));
		System.out.println(fibonacci.fib(21));
		System.out.println(fibonacci.fib(15));
	}
	
	public static void ejemplo3() {
		System.out.println("Inició ejemplo 3");
		System.out.println(fibonacci.fib(50));
	}
	
	public static void ejemplo4() {
		System.out.println("Inició ejemplo 4");
		for (int i = 0; i < 90; i++) {
			System.out.println(i + " " + fibonacci.fib(i));
		}
	}
	
	public static void ejemplo5() {
		System.out.println("Inició ejemplo 5");
		for (int i = 90; i < 10000; i++) {
			System.out.println(i + " " + fibonacci.fib(i));
		}
	}
	
}