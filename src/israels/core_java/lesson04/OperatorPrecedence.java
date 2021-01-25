/* Operator precedence determines the order in which operators are evaluated.
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 *
 * OPERATOR PRECEDENCE TABLE (highest to lowest)
 *		unary			++ -- + - ~ !
 *		multiplicative	* / %
 *		additive		+ -
 *		shift			<< >> >>>
 *		relational		< > <= >= instanceof
 *		equality		== !=
 *		bitwise logic	& ^ |
 *		logical AND     &&
 *		logical OR      ||
 *		ternary         ? :
 *		assignment      = += -= *= /= %= &= ^= |= <<= >>= >>>=
 *
 * Operators of equal precedence are evaluated from left to right except for
 * assignment operators which are evaluated right to left*/

package israels.core_java.lesson04;

public class OperatorPrecedence {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		testOperatorPrecedence();
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void testOperatorPrecedence() {
		
		int test = 3 + 4 * 5 + 2; // remember PEMDAS!! 
		System.out.println(test); // returns =>  25
		
		boolean test2 = 3 + 4 * 5 - 2 > (3+4) * (5-2);
		System.out.println(test2); // returns => FALSE
		
		boolean test3 = 3 + 4 * 5 - 2 > (3+4) * (5-2) || 7 > 3;
		System.out.println(test3); // returns => TRUE
		
		
	};
	
	
}
