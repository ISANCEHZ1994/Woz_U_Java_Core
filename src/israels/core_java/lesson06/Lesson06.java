package israels.core_java.lesson06;

public class Lesson06 {

	public static void main(String[] args) {
		
		TryCatchFinally tryCatch = new TryCatchFinally();
		tryCatch.inClassWork();
		
		MultipleHandlers mHandle = new MultipleHandlers();
		mHandle.inClassWork();
		
		ExtendExceptions ee = new ExtendExceptions();
		ee.inClassWork();
		
		//TryResources NEW to Java 7
		TryWithResources twr = new TryWithResources();
		twr.inClassWork();
		
		
	}

}
