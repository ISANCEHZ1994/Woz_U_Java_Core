/** Interfaces are like 100% abstract classes and are a contract:
 *    A Java Interface can contain only method declarations and public static
 *    final constants and doesn't contain their implementation. The classes
 *    which implement the Interface must provide the method definition for all
 *    the methods present.
 *
 * An interface is also used in situations when a class needs to extend more
 *    than one class. In java its not possible to have multiple inheritance of
 *    classes. An interface can be used when it is required to implement more
 *    than one interfaces.
 *
 * Interface Rules
 *	1. Interface methods are implicitly public and abstract (Java 8: unless declared default or static)
 *	2. All variables defined in an interface must be public, static and final (constants)
 *	3. Interface methods cannot be final, strictfp or native
 *	4. An interface can extend one or more other interfaces
 *	5. An interface cannot extend anything but another interface
 *	6. An interface cannot implement anything (interface or class)
 *	7. An interface must be declared with the keyword interface
 *	8. Interface types can be used polymorphically
 */


package israels.core_java.lesson02;

import israels.core_java.common.animal.mammals.Cat;
import israels.core_java.common.animal.mammals.Dog;
import israels.core_java.common.animal.mammals.Lion;

public class Interfaces { 
	//An interface is a completely "abstract class" that is used to group related methods with empty bodies:
//	 interface
	
//	interface Animal {
//		  public void animalSound(); // interface method (does not have a body)
//		  public void run(); // interface method (does not have a body)
//		}	
	
// ALL METHODS IN INTERFACES ARE ABSTRACT - by default 
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		// Go To  java.common => Nameable.java
		
		// Student Exercise: Make Fish Implement Carnivore and test it in a method in this class!
		
		testPetInterface();
		testCarnivoreInterface();
		
		
		
		System.out.println("=========================================================================\n\n");
	}; // closes CLASSWORK
	
	private void testCarnivoreInterface() {
		System.out.println("2. Test the Carnivore Interface <=============================");
		
		Lion scar = new Lion();
		scar.setName("Scar");
		scar.hunt();
		
		Dog major = new Dog();
		major.setName("Major");
		major.hunt();
		
		Cat lucy = new Cat();
		lucy.setName("Lucy");
		lucy.hunt();
		
		
	};
	
	private void testPetInterface() {
		System.out.println("1. Test the Pet Interface <=================");
		
		
		Dog aDog = new Dog();
		System.out.println(aDog);
		System.out.println("Name :" + aDog.getName() + ", Breed: " + aDog.getBreed());
		aDog.setName("Tramp");
		aDog.setBreed("German Shepard");
		System.out.println("Name :" + aDog.getName() + ", Breed: " + aDog.getBreed());
		aDog.beFriendly();
		
		Cat aCat = new Cat();
		System.out.println(aCat);
		System.out.println("Name :" + aCat.getName() + ", Breed: " + aCat.getBreed());
		aCat.setName("CHAD");
		aCat.setBreed(" demon(??)...");
		System.out.println("Name :" + aCat.getName() + ", Breed: " + aCat.getBreed());
		aCat.beFriendly();
		
		
		
	}; // closes PETINTERFACE
	
	
	
}; // closes CLASS
