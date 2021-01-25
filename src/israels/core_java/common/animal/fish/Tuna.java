package israels.core_java.common.animal.fish;

import java.util.concurrent.ThreadLocalRandom;

public class Tuna extends Fish{
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	

// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
		
	public Tuna() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("tuna"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
	};
	
	public Tuna(int a) { // Argument Constructor!
		this();
		setAge(a);
		setWeight(setRandomWeightByAge(a));
	}
		
		
// --------------------------> METHOD SECTION <----------------------------------------------------------

	@Override
	public void eat() {
		System.out.println(getType() + " eats squid");
	};
	
//	@Override
//	public void move() {
//		System.out.println(getType() + " swims fast and true");
//	};
//	@Override
//	public void sleep() {
//		System.out.println(getType() + "...do they EVEN sleep??");
//	};
	
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
