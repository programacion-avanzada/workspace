
public class VariosBloquesCatchEjemplo1 {

	public static void main(String[] args) {

		try {
			int a[] = new int[5];
			a[5] = 30 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception");
		} catch (Exception e) {
			System.out.println("Parent Exception");
		}
		System.out.println("otras cosas");
	}
}
