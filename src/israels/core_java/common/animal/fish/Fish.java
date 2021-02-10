package israels.core_java.common.animal.fish;

import java.util.concurrent.ThreadLocalRandom;

import israels.core_java.common.animal.Animal;

public abstract class Fish extends Animal{
// ********************************** VARIABLES, GETTERS AND SETTERS SECTION ***************************************************

	

	
// ********************************** CONSTRUCTOR SECTION ***************************************************
	
	
	public Fish() {
//		System.out.println("In fish no-arg constructor");
		setType("unknown fish");
	};
	

	
// ********************************** METHOD SECTION ***************************************************

	@Override
	public void move() {
		System.out.println(getExtendedType() + " swimming in the water");
	};
	@Override
	public void sleep() {
		System.out.println(getExtendedType() + " sleeping with its eyes open..creepy");
	};
	
	protected int setRandomWeightByAge(int a) { // void DOES NOT return anything so use int (INTEGER)
		int result;
		if(a < 5) {
			result = a + 1;
		}else {
			result = ThreadLocalRandom.current().nextInt(5,20);
		}
		return result;
	};
	
}
