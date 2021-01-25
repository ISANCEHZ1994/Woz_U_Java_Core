package israels.core_java.lesson04;

import israels.core_java.common.animal.*;
import israels.core_java.common.animal.mammals.Lion;

public class RelationalOperators {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		testRelationalOperators();
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void testRelationalOperators() {
		System.out.println("1. Relational Operators  ");
		
		int x = 9;
		long y = 6;
		System.out.println("x < y: " + (x < y) ); //false
		System.out.println("x <= y: " + (x <= y )); //false
		System.out.println("x > y: " + (x > y)); // true
		System.out.println("x >= y: " + (x >= y)); //true
		
		Animal aRef = new Lion();// doesn't have to be this animal - can be ANY Carnivore
		// if you tried using the hunt method with the Gazelle class instead of Lion - ClassCastException - ERROR
		if(aRef instanceof Carnivore) {
			((Carnivore)aRef).hunt(); // <== Do this to get to the hunt method - this is CASTING
		}else {
			System.out.println("aRef is not a Carnivore!");
		}
		
		
	};
	
	
}
