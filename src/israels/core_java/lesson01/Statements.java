package israels.core_java.lesson01;

public class Statements {
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + " .inClassWork()");
		// declaration statements
		int x; // (32 bit) primitive declaration
		String s1;// this is a class - when used we create something, called a REFERENCE VARIABLE
		double d2;
		
		// ASSIGNMENT STATEMENT
		x = 25; // Integer literals are 32 bit
		s1 = "Rocks!";
		d2 = 3.1415; // Floating Point literals are 64 bit
		
		// Combination of declaration and assignment
		String s2 = "Java ";
		double d = Math.random(); // it will get a random number between 0 and 1
		
		// This is an EXPRESSION - a combination of variables, operators, method calls and literals
		d2 = x * d;
		d2 = x + 5 * 5;
		
		x++; // <= This is an EXPRESSION that is ALSO a STATEMENT
		
		// A LITERAL is a value that you write out
		System.out.println(s2 + s1);
		
	}
}
