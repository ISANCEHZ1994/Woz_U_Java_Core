
//* Abstract class - a class that must be subclassed to be used
// * 1. A class may contain one or more abstract methods which have to be implemented by
// *    a sub class(es).
// * 2. An abstract class can contain non abstract (concrete) methods. If you want to add
// *    a new method that applies to all subclasses, the method can simply be implemented
// *    in the abstract class.
// * 3. An abstract class definition begins with the keyword "abstract" keyword followed by
// *    Class definition.
// * 4. Abstract classes are useful in a situation when some general methods should be
// *    implemented and other specialized behavior should be implemented by subclasses.
// *

package israels.core_java.lesson02;

import israels.core_java.common.animal.birds.Bird;
import israels.core_java.common.animal.birds.Duck;
import israels.core_java.common.animal.birds.Emu;
import israels.core_java.common.animal.birds.Hawk;
import israels.core_java.common.animal.birds.Raptor;
import israels.core_java.common.animal.mammals.Lion;

public class AbstractClasses {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
//		testAbstractMammal();
		testAbstractBird();
		testAbstractMethods();
		 testAbstractRaptor();
		 
	};
	
	private void testAbstractMammal() {
		System.out.println("4. Abstract ");
		Lion scar = new Lion();
		scar.grow();
		scar.grow();
		scar.grow();
		scar.grow();
		scar.grow();
		scar.grow();
		System.out.println(scar);
		System.out.println(scar.getRunningSpeed());
		scar.setHealth((byte) 0);
		System.out.println(scar.getRunningSpeed());
		scar.setHealth((byte) -5);
		System.out.println(scar.getRunningSpeed());
		
	};
	
	private void testAbstractMethods() {
		System.out.println("1. If a class has abstract classes,  the class must be abstract!");
		
//		Bird newBird = new Emu();
//		newBird.move(); // baby emu flying!
//		
//		Bird newBird2 = new Duck();
//		newBird2.move(); // baby duck flying!
	};
	
	private void testAbstractRaptor() {
		System.out.println("3a Abstract methods MAY be implemented in abstract classes");
		Raptor b1 = new Hawk();
		
		System.out.println("Can swim? " + b1.canSwim());

		System.out.println("3b. You don't have to implement abstract methods in abstract classes");
		System.out.println("Can run? " + b1.canRun());
		
	}
	
	private void testAbstractBird() {
		System.out.println("2. Abstract method must be implemented in the first CONCCRETE Class");
		
		Bird b1 = new Emu();
		b1.move();
		
		Bird b2 = new Duck();
		b2.move();
		
		Bird b3 = new Hawk();
		b3.move();
		
	};
	
	
};

