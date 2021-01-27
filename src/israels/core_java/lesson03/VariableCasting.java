/*
 *  Reference Variables:
 *		Upcast - Up the inheritance tree to a more general type
 *		Downcast - Down the inheritance tree to a more specific type
 *
 *  Primitive casting - converts primitives from one type to another
 * 		implicit - conversion happens automatically
 * 		explicit - must write the cast in parenthesis
 * 		widening - going from smaller to larger datatype (can be implicit)
 * 		narrowing - going from larger to smaller datatype (must be explicit)
 */

package israels.core_java.lesson03;

import israels.core_java.common.animal.mammals.*;
import israels.core_java.common.animal.*;
import israels.core_java.common.animal.domestic.Cat;
import israels.core_java.common.animal.domestic.Dog;
import israels.core_java.common.animal.domestic.Horse;

public class VariableCasting {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		castingReferenceVariables();
		castPrimatives();
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void castingReferenceVariables() {
		
		System.out.println("1. Casting Reference Variable  <===================================");
		
// Upcasting going up the inheritance tree from a specific type to a more general type <===========================================
		
		Dog d = new Dog();
		d.setName("SIRIUS");
		Carnivore carn = d; // Carnivore is an interface \
		Animal anim = d;
		Mammal mam = d;
		
		Cat c = new Cat();
		c.setName("MILY");
		carn = c; // This is UPCASTING - going to a specifc type of animal(Carnivore) or General Type (Animal)
		anim = c;
		
		Horse h = new Horse();
		// carn = h; // would return an error because of how we set it up - NOT A CARNIVORE
		anim = h; // this IS POSSIBLE because a horse is an animal
		mam = h;
		
// Downcasting is going from a general type to a more specifc type  <===========================================
		// WHEN DOWNCASTING WE MUST BE EXPLCIT!! <== CAST
		
		anim = new Lion(); // can't cast this because a dog is not a lion!!
		carn = (Carnivore)anim; // We have to CAST to be EXPLCIT~
		
		anim = c; 
		anim = d;
		if(anim instanceof Dog) {
			d = (Dog)anim; 
			d.beFriendly();
			
			((Dog)anim).beFriendly();
		};
		System.out.println("1b. Using animalHospital <=========================================");
		
		// These Methods are Upcasting
		animalHospital(new Lion());
		animalHospital(new Cat());
		animalHospital(new Horse());
		
	}; // closes castingReferenceVariables
	
	
	
	
	private void animalHospital(Animal a) {
		// These Casts are all Downcasting
			if(a instanceof Pet) {
				((Pet)a).beFriendly();
			}
			
			if(a instanceof Carnivore) {
				((Carnivore)a).hunt();
			}
			
			if(a instanceof Horse) {
				((Horse)a).eat();
			}
		
		
	}; // closes ANIMALHOSPITAL
		
		
	private void castPrimatives() {
		System.out.println("2. Casting Primitives <=================================");
		byte b = 5;
		short s = 50;
		int i = 500;
		long lng = 5000;
		float f = 50_000.0F;
		double d = 500_000.0;
		
		double test;
		test = s;
		System.out.println("test = " + test); // returns => 50.0
		
		long test2;
		test2 = i; // UPCASTING
		test2 = (long)d; // DOWNCASTING - must be EXPLICIT!!
		System.out.println("test2 = "  + test2);
		
		byte testByte = 0;
		testByte = (byte)i; // returns => -12
		System.out.println("testByte = "+ testByte );
		
		
	};
		
		
		
}
