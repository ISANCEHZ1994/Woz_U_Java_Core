package israels.core_java.lesson03;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.mammals.*;

public class ReturnTypes {
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		nullReturnsAreOk();
		returningArrays();
		covariantReturns();
		testEnumSex();
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void testEnumSex() {
		System.out.println("1. Test The Sex Enum <============================================");
		
		Animal animal = new Animal();
		System.out.println(animal); // => First is nothing 
		animal.setSex(Sex.MALE);
		animal.grow();
		System.out.println(animal); // => Then its filled with information!!
		
		System.out.println();
		
		Elephant dumbo = new Elephant();
		System.out.println(dumbo);
		dumbo.setSex(Sex.MALE);
		dumbo.setAge(15);
		dumbo.setWeight(1300);
		dumbo.grow();
		System.out.println(dumbo);
		
		System.out.println();
		
	};
	
	public void nullReturnsAreOk() {
		System.out.println("1. NULL is a vaild return vaule <======================================");
		
		Lion baby;
		Lion leo = new Lion(6, 700, Sex.MALE);
		baby = (Lion)leo.reproduce();
		System.out.println("baby = " + baby);
		leo.reproduce();
		Lion elsa = new Lion(3, 600, Sex.FEMALE);
		baby = (Lion)elsa.reproduce();
		System.out.println("baby = " + baby);
		elsa.reproduce(); // This won't work because she is too young
		elsa.grow(); 
		elsa.reproduce(); // Now she is old enough to reproduce
		
		
		
		System.out.println();
	};
	
	public void returningArrays() {
		System.out.println("2. ARRAYS are vaild return types <======================================");
		
		Dog[] newLitter;
		Dog mother = new Dog();
		mother.setAge(4);
		newLitter = mother.reproduce(6);
		for( Dog d : newLitter) {
			System.out.println(d);
		};
		
		
		System.out.println();
	};
	
	public void covariantReturns() {
		System.out.println("3. COVARIANT returns are allowed in overriding methods <======================================");  
		
		Elephant baby;
		Elephant elmore = new Elephant(17);
		elmore.setSex(Sex.MALE);
		baby = elmore.reproduce();
		System.out.println("baby = " + baby);
		Elephant ellie = new Elephant(15);
		baby = ellie.reproduce();
		System.out.println("baby = " + baby);
		ellie.grow();
		baby = ellie.reproduce();
		System.out.println("baby = " + baby);
		

		
		System.out.println();
	};
	
	
	
	
}
