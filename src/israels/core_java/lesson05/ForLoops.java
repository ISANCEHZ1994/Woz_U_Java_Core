// * The basic for loop:
// *   The declaration has three parts:
// *     1. initialization sets up the loop control variable:     int i = 0
// *     2. conditional test determines when loop terminates:     i < 4
// *     3. iterator increments the loop control variable:        i++
// *   A fourth part is the body of the for loop
// *
// * Enhanced for loop introduced in Java 5:
// *   Designed for ease of use with arrays and collections
// *   Two parts to setting up the enhanced for loop:
// *     1. declaration - a block variable of the same type as the array element
// *     2. expression - the array itself
// *
// * If you do not use curly braces, the loop body consists of just one statement

package israels.core_java.lesson05;

import israels.core_java.common.animal.mammals.Lion;

public class ForLoops {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		
		testBasicForLoop();
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void testBasicForLoop() {
		System.out.println("======> 1. Basic old style for loop <======");
		
		for(int i = 0; i < 4; i++) { //loop body
			System.out.print("i = " + i + ", ");
		}
		// STUDENT EXERCISE: change i<4 to i>4: what happens? => It'll never execute
		// Loop will only execute when the conditional expression returns true
		
		System.out.println("======> 1a. The Iteration Expression Can Be Anything <======");
		for(int j = 10; j > 4; j -= 2) {
			System.out.print("j = " + j + ", ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("======> 1b. The Loop Control Variable Can Be Anything <======");
		for(double j = 100; j > 4; j = j/2) {
			System.out.print("j = " + j + ", ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("======> 1c. Loop Expression Can Literally Be Anything <======");
		for(Lion a = new Lion(); a.getAge() < 5; a.grow()) {
			System.out.println(a);
			a.move();
		}
		System.out.println('\n');
		
		System.out.println("======> 1d. All Declaration Parts are Optional <======");
		int count = 0;
		// This behaves just like while(count < 6)
		for(; count < 6;) {
			System.out.println("count = " + count++);
		}
		System.out.println('\n');
		
		System.out.println("======> 1e. Declaring the Loop Control Variable Outside the Loop <======");
		int k; // now we can use k outside the loop!
		for(k = 1; k <= 3; k++) { // k++ can be replaced with k++ below!
			System.out.println("Inside loop k = " + k); // you can also switch it up by changing k => k++ 
		}
		System.out.println("Ouside the loop k = " + k);
		
		System.out.println('\n');
		
		System.out.println("======> 1f. Multiple Variables in Loop Expressions <======");
		for(long i = 1, j = 2; i <= 16 && j <= 10000; i++, j *= 2) {
			System.out.println("2 to the " + i + " powweerrrrr = " + j);
		}
		System.out.println();
		
	};
	
}
