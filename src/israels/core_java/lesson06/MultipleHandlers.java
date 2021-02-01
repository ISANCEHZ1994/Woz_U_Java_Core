package israels.core_java.lesson06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.mammals.Lion;

public class MultipleHandlers {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		throwingExceptions();
		exceptionMatching();
		integerateFileListsIntoRAB();
		
		Lion leo = new Lion(6,350,Sex.MALE);
		leo.hunt();
		leo.sleep();
		
		
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
			// programmatically throwing an exception <== This is throwing a new exception!
			throw new IllegalArgumentException("computeAverage number parameter can't be 0");
		}
		System.out.println("Computing average..");             
		// Exception may be triggered here
		return sum/number;                                    
	}
	
	private void throwingExceptions() {
		System.out.println("1. Throwing Exceptions Method Block: ");
		System.out.println();

		System.out.println("1a. Normal Execution");
		printAverage(100,20);
		System.out.println("<=============================================================>");
		System.out.println();
		System.out.println("1b.  Falty Execution");
		System.out.println();
		printAverage(100,0); // which we know will break it!
		System.out.println();
	};
	
	private void exceptionMatching(){
		System.out.println("2. Exception Matching With Multiple Catch Blocks ");
//	computeAverage(100,0); // default handler via JVM  => we didnt write a try/catch but the error still got caught
		RandomAccessFile raf = null; 
		try {
			raf = new RandomAccessFile("myfile.txt", "r");
			// this exception is being checked by the complier
			byte[] buffer = new byte[100];
			raf.readFully(buffer,0,100);
			// Unhandled exception of io exception
			computeAverage(100,0);
		}catch(IllegalArgumentException iae) {
			System.out.println(iae);
		}catch(NullPointerException npe) {
			System.out.println(npe);
		}catch(ArithmeticException ae) {
			System.out.println(ae); 
		}catch(FileNotFoundException fnfe) { // now gets an error because it is a subclass of IO - MUST BE ABOVE
			System.out.println(fnfe);
		}catch(IOException ioe) {
			System.out.println(ioe);
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println();
	};
	
	private void integerateFileListsIntoRAB(){
		System.out.println("3. Testing file names and RandomAnimalBuilder");
		RandomAnimalBuilder builder = new RandomAnimalBuilder();
		
		try {
			builder.testGetClassList("mammals"); // change to fish, reptile, domestic to see different files in console!
		} catch (NullPointerException npe) {
			npe.printStackTrace(); // now loin still runs !
		}
		
	};
}
