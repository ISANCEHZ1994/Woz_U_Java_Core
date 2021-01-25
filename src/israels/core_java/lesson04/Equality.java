package israels.core_java.lesson04;

import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.birds.BirdFood;
import israels.core_java.common.animal.mammals.Elephant;

public class Equality {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		primitiveEquality();
		referenceEquality();
		enumEquality();
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void primitiveEquality() {
		
		System.out.println("1. PRIMITIVE EQUALITY <=== ");
		int x = 7;
		int y = 7;
		// Test for equality is the double equal
		System.out.println(x == y); // TRUE
		// Test for INEQUALITY is the bang equal
		System.out.println(x != y); // FALSE
		
		// Primitives support equality of all numeric types
		double dy = 7.0;
		System.out.println(x == dy); // TRUE
		System.out.println(x != dy); //FALSE
		
	};
	
	private void referenceEquality() {
		
		System.out.println("2. REFERENCE EQUALITY <=== ");
		Elephant e = new Elephant();
		//e.setAge(5); // this will make e.equals(e2) false!
		//e.setWeight(500); // this will make e.equals(e2) false!
		//e.setSex(Sex.MALE); // this will make e.equals(e2) false!
		Elephant e2 = new Elephant();
//		e2 = null;
		System.out.println(e == e2); // will ALWAYS be false
		System.out.println(e.equals(e2)); // true
	};
	
	private void enumEquality() {
		
		System.out.println("3. ENUM EQUALITY <=== ");
		BirdFood foodType = BirdFood.UKNOWN;
		System.out.println(foodType == BirdFood.FRUIT); //FALSE
		System.out.println(foodType == BirdFood.UKNOWN); //TRUE
	};
	
	
	
};
