/*  class Object methods needed for the exam
 *		String toString()			Returns a text representation of this object
 * 		boolean equals (Object obj)	Decides whether two objects are meaningfully equivalent
 *		int hashCode()				Returns a hashcode int value so that an object can be used in
 *									collection classes that use hashing
 *		void finalize()				Called by garbage collector when an object is no longer referenced
 *		final void notify()			Wakes up a thread that is waiting for this object's lock
 *		final void notifyAll()		Wakes up all threads that are waiting for this objects lock
 *		final void wait()			Causes the current thread to wait until another thread calls
 *									notify() or notifyAll() on this object
 * 		protected Object clone() throws CloneNotSupportedException
 * 									Creates and returns a copy of this object
*/
package israels.core_java.lesson08;

public class ObjectMethods {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	
	
}
