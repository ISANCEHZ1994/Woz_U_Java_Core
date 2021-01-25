// Classes model 2 things: State and Behavior
// STATE - (what a class KNOWS) is modeled by an instance variable
// BEHAVIOR - (what a class DOES) is modeled by instance methods

package israels.core_java.lesson01;

import israels.core_java.lesson01.exercises.Dog;

public class ClassesAndObjects {
	public void inClassWork(){
		System.out.println(this.getClass().getSimpleName() + " .inClassWork()");
		
		// Declaring a REFERENCE VARIABLE of type Dog, DOES NOT create an object;
		Dog newDog; // usually will be  => Dog newDog = new Dog();
		System.out.println("Dog object not created yet!");
		
		// This instantiates a Dog object in memory
		newDog = new Dog();
		System.out.println("Dog object created!");
		
		newDog.weight = 12; 
		newDog.name = "Shrimp";
		
		newDog.bark();
		
		newDog.weight = 171;
		newDog.name = "Sarge";
		newDog.bark();
		
	}
}
