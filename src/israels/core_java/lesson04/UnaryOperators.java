/*
 * Unary operators operate on a single operand
 * Prefix operators: ++x, --x      // Change the value before being used
 * Postfix operators: x++, x--     // Change the value after being used
 * Increment operators: ++x, x++   // Increase the value by 1
 * Decrement operators: --x, x--   // Decrease the value by 1
 *
 * +	Unary plus operator; indicates positive value (numbers are positive without this, however)
 * -	Unary minus operator; negates an expression
 * !	Logical complement operator; inverts the value of a boolean
 * ~    Bitwise complement
 *
 * Unary operators have the highest precedence
 */

package israels.core_java.lesson04;

public class UnaryOperators {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		testUnaryOperators();
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	public void testUnaryOperators() {
		
		System.out.println("Increment prefix operator: ++x");
		int x = 10;
		System.out.println(++x); // this prints out 11
		
		System.out.println("Increment postfix operator: x++");
		x = 10;
		System.out.println(x++); // it changed however it was changed AFTER it is used - WHY would you use this??
		
		
		System.out.println("Decrement Prefix Operator: --x");
		x=10;
		System.out.println(--x);
		
		System.out.println("Decrement Postfix Operator: x--");
		x=10;
		System.out.println(x--);
		System.out.println(x);
		
		System.out.println(" Prefix vs postfix from an interview question:");
		x = 10; // x++ makes it 11 then ++x makes it 12
		int y = x++ * ++x;
		System.out.println("y = " + y + ", x = " + x);
		x = 2;
		y = x++ * x++ * x++;
		System.out.println("y = " + y + ", x = " + x);
		x = 2;
		y = ++x * ++x * ++x;
		System.out.println("y = " + y + ", x = " + x);
		
	};
	
}
