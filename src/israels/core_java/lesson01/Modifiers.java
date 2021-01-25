/* There are 4 levels of ACCESS 
 * But only 3 access modifies 
 * Variables and Methods with NO access modifier have package (default) level of access
 * 
 * ACCESS MODIFIERS 
 * 	public - MOST COMMON of modifier - ANYONE can see an import statement
 * 	protected - package + kids (in same package or inherits from)
 * 	private - visible ONLY to the Class itself
 * 
 *  default - does not use a modifier, hardly used
 * 
 * NON-ACCESS MODIFIERS 
 * 	final - CANNOT be changed
 * 	abstract - MUST be OVERRIDEN (methods) or extended (classes)
 * 	static - can be used WITHOUT instantiating an object
 * 	
 * 	synchronized - used in multithreaded applications to prevent collisions between threads
 * 	transparent - in fileIO to ignore variables in serialization
 * 
 * 
 * 	volatile - used in multithreaded applications to reconcile data modified in multiple threads
 * 	STRICTFP - forces floating point notation to use IEEE754 standard
 * 	NATIVE - method is implemented in another language
 */

package israels.core_java.lesson01;

public class Modifiers {
	
	// Class variables use the static keyword
	static String classVar = "Class Variable";
	
	// can't change CONSTANT/FINAL
	private final double TEST_FINAL = 123_342.789;
	// final can also be used in CLASSES 
	//NOTE: String is already a final https://docs.oracle.com/javase/8/docs/api/ 
	// public final class String <= thats what you will find online!
	
	public void inClassWork() {
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
		
	}
	
	// public abstract void testAbstractMethod();
	
	
}
