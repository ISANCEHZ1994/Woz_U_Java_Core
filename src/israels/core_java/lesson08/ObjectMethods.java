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

import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.domestic.Dog;
import israels.core_java.common.animal.mammals.Lion;

public class ObjectMethods {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		
		testAnimalEquality();
		testAnimalHashCode();
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void testAnimalEquality() {
		Lion fLion1 = null;
		Lion mLion = null;
		Lion fLion3 = null;
		Lion fLion4 = null;
		Lion smallFLion = null;
		Lion oldFLion = null;
		System.out.println("5a. Test Animals are reflexive: x.equals(x) must return true.");
		System.out.println("Does fLion1.equals(fLion1)? " + fLion1.equals(fLion1));
		System.out.println("Does mv2.equals(mv2)? " + mLion.equals(mLion));
		System.out.println("Does mv3.equals(mv3)? " + fLion3.equals(fLion3));
		System.out.println("Does mv5.equals(mv5)? " + smallFLion.equals(smallFLion));
		System.out.println("Does oldFLion.equals(oldFLion)? " + oldFLion.equals(oldFLion));
		System.out.println("\n5b. Test Animals are symmetric");
		System.out.println("Does fLion1.equals(mv4)? " + fLion1.equals(fLion4));
		System.out.println("Does mv4.equals(fLion1)? " + fLion4.equals(fLion1));
		System.out.println("Does fLion1.equals(mv2)? " + fLion1.equals(mLion));
		System.out.println("Does mv2.equals(fLion1)? " + mLion.equals(fLion1));
		System.out.println("Does fLion1.equals(mv5)? " + fLion1.equals(smallFLion));
		System.out.println("Does mv5.equals(fLion1)? " + smallFLion.equals(fLion1));
		System.out.println("\n5c. Test Animals are transitive");
		System.out.println(fLion1 + " " + fLion3 + " " + fLion4);
		System.out.println("Does fLion1.equals(mv3)? " + fLion1.equals(fLion3));
		System.out.println("Does mv3.equals(mv4)? " + fLion3.equals(fLion4));
		System.out.println("Does fLion1.equals(mv4)? " + fLion1.equals(fLion4));
		System.out.println("\n5d. Test Animals are consistent");
		for (byte i=1; i<=10; i++) {
			fLion1.setHealth(i);
			System.out.println("Does fLion1.equals(mv2)? " + fLion1.equals(mLion));
    		System.out.println("Does mv2.equals(mv3)? " + mLion.equals(fLion3));
    		System.out.println("Does mv3.equals(mv4)? " + fLion3.equals(fLion4));
    		System.out.println("Does fLion1.equals(mv4)? " + fLion1.equals(fLion4));
    		System.out.println();
		}
		System.out.println("\n5e. Test null");
		System.out.println("Does fLion1.equals(null)? " + fLion1.equals(null));
		System.out.println("Does mv2.equals(null)? " + mLion.equals(null));
		System.out.println("Does mv3.equals(null)? " + fLion3.equals(null));
		System.out.println("Does oldFLion.equals(null)? " + oldFLion.equals(null));
		System.out.println ("---------------------------------------------------------------------\n");
	}
	
	
	private static void testAnimalHashCode() {
		System.out.println("Testing hashCode contract with Dog:");
		Dog a = new Dog("amy");
		Dog b = new Dog("amy");
		Dog c = new Dog("may");
		Dog d = new Dog("may");
	
		// Override Animal.hashCode
		// What's illegal here?
		System.out.println("a.equals(b) " + a.equals(b) + "\t and a.hashCode()= b.hashcode()? " + (a.hashCode() == b.hashCode()));
		System.out.println("a.equals(c) " + a.equals(c) + "\t and a.hashCode()= c.hashcode()? " + (a.hashCode() == c.hashCode()));
		System.out.println("b.equals(b) " + b.equals(b) + "\t and b.hashCode()= b.hashcode()? " + (b.hashCode() == b.hashCode()));
		System.out.println("d.equals(b) " + d.equals(b) + "\t and d.hashCode()= b.hashcode()? " + (d.hashCode() == b.hashCode()));
		// Override Dog.hashCode to correct the problem
	
		System.out.println("\n7a. Test Animals hashCodes are consistent");
		System.out.println("a: " + a + ", b: " + b);
		for (byte i=1; i<=5; i++) {
			a.setHealth(i);
			System.out.println("a Initial creation:   " + a.hashCode());
		}
	
		System.out.println("\n7b. Include sex in hashCode:");
		b.setSex(Sex.MALE);
		System.out.println("a: " + a + ", b: " + b);
		System.out.println("a Initial creation: " + a.hashCode());
		System.out.println("b.setSex(MALE):     " + b.hashCode());
	
		System.out.println("\n7c. Include age in hashCode:");
		b.setAge(10);
		System.out.println("a: " + a + ", b: " + b);
		System.out.println("a Initial creation: " + a.hashCode());
		System.out.println("b.setAge(10):       " + b.hashCode());
	
		System.out.println("\n7d. Include weight in hashCode:");
		b.setWeight(36);
		System.out.println("a: " + a + ", b: " + b);
		System.out.println("a Initial creation: " + a.hashCode());
		System.out.println("b.setWeight(36):    " + b.hashCode());
	
		System.out.println ("---------------------------------------------------------------------\n");
	}
	
}
