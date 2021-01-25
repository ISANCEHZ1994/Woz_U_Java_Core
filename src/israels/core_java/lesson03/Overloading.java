package israels.core_java.lesson03;

import java.util.*; // UTIL NOT THE OTHER ONE

import israels.core_java.common.animal.*;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.mammals.*;

public class Overloading {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		simpleOverloading();
		testElephantWeight();
		testRandomAnimal();
		System.out.println("=========================================================================\n\n");
	};
	
	
	
	private void simpleOverloading() {
		System.out.println("1. Overloading In The Same Class <======= ");
		
		Animal some = new Animal();
		some.setAge(1);
		some.setRandomWeightByAge(); // old VOID setRandomWeightByAge()
		System.out.println(some);
		
		Animal some2 = new Animal();
		some2.setAge(1);
		some2.setRandomWeightByAge(100, 150, 125, 200, 10);
		System.out.println(some2);
		some2.setSex(Sex.MALE);
		some2.setRandomWeightByAge(100, 150, 125, 200, 10);
		System.out.println(some2);
		
		System.out.println();
		
		some.setAge(20);
		some.setRandomWeightByAge();
		System.out.println(some);
		
		some2.setAge(20);
		some2.setRandomWeightByAge(100, 150, 125, 200, 10);
		System.out.println(some2);
		some2.setSex(Sex.MALE);
		some2.setRandomWeightByAge(100, 150, 125, 200, 10);
		System.out.println(some2);
		
	};
	
	private void testElephantWeight() {
		Elephant ellie = new Elephant();
		
		// Test birth weight
		ellie.setRandomWeightByAge();
		System.out.println(ellie);
		
		// Test the boundary
		ellie.grow();
		System.out.println(ellie);
		
		// Test the weights at MATURITY
		ellie.setAge(14);
		System.out.println(ellie);
		ellie.grow();
		System.out.println(ellie);
		ellie.grow();
		System.out.println();
		ellie.grow();
		System.out.println(ellie);
		
		System.out.println();
		
		Elephant manny = new Elephant();
		manny.setSex(Sex.MALE);
		
		// Test birth weight
			manny.setRandomWeightByAge();
			System.out.println(manny);
				
		// Test the boundary
			manny.grow();
			System.out.println(manny);
				
		// Test the weights at MATURITY
			manny.setAge(14);
			System.out.println(manny);
			manny.grow();
			System.out.println(manny);
			manny.grow();
			System.out.println();
			manny.grow();
			System.out.println(manny);
		
		
	};
	
	private void testRandomAnimal() {
		System.out.println("3. Test RandomAnimalBuilder <===========");
		List<Animal> animals = (List<Animal>) new RandomAnimalBuilder().build(3);
		
		for(Animal a : animals) {
			System.out.println(a);
			a.grow();
			System.out.println(a);
		}
		
	};
	
}
