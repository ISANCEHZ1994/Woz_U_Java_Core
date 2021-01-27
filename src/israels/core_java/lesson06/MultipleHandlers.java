package israels.core_java.lesson06;

public class MultipleHandlers {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		throwingExceptions();
		exceptionMatching();
		
		System.out.println("=========================================================================\n\n");
	};
	
	public void printAverage(int total, int number) { // NOTE: same as TryCatchFinally however NO TRY/CATCH/FINALLY
		// Add try catch here
		// Source => Sourround With => try catch block
			try {
				int average = computeAverage(total, number);
				System.out.println("Average = " +                     
						total + " / " + number + " = " + average);
			} catch (IllegalArgumentException e) {
				
				System.err.println("Exception handled in printAverage: " + e);
//				e.printStackTrace();
			}
			System.out.println("Exit printAverage ");
	}
	
	//  Notice that the exception is propagated from the computeAverage
	//  method to the printAverage method where it is handled by a catch block
	public int computeAverage(int sum, int number) {
		if(number == 0) {
			// programmatically throwing an exception
			throw new IllegalArgumentException("computeAverage number parameter can't be 0");
		}
		System.out.println("Computing average..");             
		// Exception may be triggered here
		return sum/number;                                    
	}
	
	private void throwingExceptions() {
		System.out.println("1. Programmatic throwing of an exception: ");

		System.out.println("1a. Normal Execution");
		printAverage(100,20);
		System.out.println("<=============================================================>");
		System.out.println("1b.  Falty Execution");
		printAverage(100,0); // which we know will break it!
		
	};
	
	private void exceptionMatching(){
		System.out.println("2. Exception Matching With Multiple Catch Blocks ");
		
		computeAverage(100,0); // default handler via JVM  => we didnt write a try/catch but the error still got caught
	}
}
