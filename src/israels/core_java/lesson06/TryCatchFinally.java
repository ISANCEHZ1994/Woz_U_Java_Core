/*
 * TryCatchFinally.java Copyright 2013,2015, Steve Montgomery, All rights reserved
 * 
 * Exception: the customary way in Java to indicate that an abnormal condition 
 * has occurred. The error handling mechanism built into Java
 * 
 * The default handler is in the JVM and it runs if you do not handle your
 * exceptions. Execution of your program stops completely when you hit an exception
 * without handling it.
 * 
 * Three conditions for a try/catch/finally block:
 * 
 *                  Execute try block
 *                          |
 *        ------------------|------------------
 *        |                 |                 |
 *        | (1)             | (2)             | (3)  
 *        | No              | Exception       | Exception 
 *        | Exception       | Caught          | not caught
 *        |                 |                 |
 *        ------------------|------------------
 *                          |
 *                Execute Finally Block
 *
 *  If try block executes then finally is guaranteed to execute
 *  
 *  try block - where you put risky code
 *  catch block - where you handle an exception
 *  finally block - runs no matter what
 *  
 *  If you have a try block, you must have either a catch block or a finally block
 *  The finally block must be after catch blocks if they both exist
 */

package israels.core_java.lesson06;

public class TryCatchFinally {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		
		printAverage(100,20);
		System.out.println("<=============================================================>");
		System.out.println("2. TryCatch with Errors");
		printAverage(100,0); // which we know will break it!
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	public void printAverage(int total, int number) {
		// Add try catch here
		try {
			int average = computeAverage(total, number);
			System.out.println("Average = " +                     
					total + " / " + number + " = " + average);
			return;
		} catch (ArithmeticException ae) { // catches errors!
//		} catch (NullPointerException ae) {
			System.out.println("Exception handled in printAverage()"); // prints out red and blue lines in console - error details
			ae.printStackTrace();
//			System.exit(1);
		} finally {
			System.out.println("In the finally block");
		}
		System.out.println("Exit printAverage().");           
	}
	
	//  Notice that the exception is propagated from the computeAverage
	//  method to the printAverage method where it is handled by a catch block
	public int computeAverage(int sum, int number) {
		System.out.println("Computing average.");             
		// Exception may be triggered here
		return sum/number;                                    
	}
	
	
}
