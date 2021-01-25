/* Polymorphism - changing the behavior of our subclasses. Allows you to treat
 * 		different objects in the same way even if they were created from different
 * 		classes and exhibit different behaviors.
 *
 * We override instance methods to implement polymorphic behavior
 *
 * Rules for overriding a method (from p 108-9)
 *   1. The argument list must be exactly the same as the overridden method
 *   2. The return type must be the same or a subclass of the return type in
 *      the overridden method
 *   3. The access level can't be more restrictive, but can be less restrictive 
 *   meaning Override cannot be protected it has to be public 
 *   4. Overridden method must be visible (not private)
 *   
 *   5. Overridden method can't be final or static
 *   (more overriding rules regarding exceptions in chapter 5)
white_check_mark
eyes
raised_hands::skin-tone-4
*/

package israels.core_java.lesson03;

import java.util.List;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Carnivore;
import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.reptiles.*;

public class Polymorphism {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		studyPolymorphism();
		createOwnAnimal();
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void studyPolymorphism(){
		
		List<Animal> zoo = (List<Animal>) new RandomAnimalBuilder().build(10);
		
		for(Animal a : zoo) {
			a.eat();
			a.move();
			a.sleep();
			if(a instanceof Carnivore) { // when we (down)cast we always want to check if it works!
				((Carnivore)a).hunt();
				// SAME AS:
				//Carnivore carn = (Carivore)animal;
				// carn.hunt();
			}
			System.out.println(); // a space for each animal~
			// RESULT:
//			monkey eating bugs
//			monkey monkeying around
//			monkey sleeping after monkeying around
//
//			elephant chomping tree branches
//			elephant shuffling ponderously
//			elephant sleeping under a starlit sky
//
//			a Crocodile is found eating
//			a Crocodile is found moving
//			a Crocodile is found sleeping
//
//			swordfish eating krill
//			swordfish swims like a torpedo
//			swordfish - what is sleep?
//
//			a Crocodile is found eating
//			a Crocodile is found moving
//			a Crocodile is found sleeping
//
//			monkey eating bugs
//			monkey monkeying around
//			monkey sleeping after monkeying around
//
//			a snake is found eating
//			a snake is found moving
//			a snake is found sleeping
//
//			monkey eating bugs
//			monkey monkeying around
//			monkey sleeping after monkeying around
//
//			monkey eating bugs
//			monkey monkeying around
//			monkey sleeping after monkeying around
//
//			horse grazing and eating grass
//			horse proudly stomps feet
//			horse kneels before a beautiful night
			
			
		}
		
		
	}; // closes studyPoly
	
	private void createOwnAnimal(){
		Animal genericAnimal = new Animal(3);
		Snake snake = new Snake();
		
		System.out.println(genericAnimal);
		System.out.println(snake);
		genericAnimal.eat();
		snake.eat();
		genericAnimal.move();
		snake.move();
		genericAnimal.sleep();
		snake.move();
		
	}
	
	
}
