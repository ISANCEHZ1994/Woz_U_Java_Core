package israels.core_java.common.animal.mammals;

//import israels.core_java.common.animal.mammals;

public class Monkey extends Mammal{
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	

// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	
	public Monkey() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("monkey"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		MAX_AGE = 20;
		MATURITY = 4;
		setMaxRunningSpeed(34);
	};
	
	
// --------------------------> METHOD SECTION <----------------------------------------------------------
	@Override
	public void eat() {
		System.out.println(getType() + " eating bugs");
	};
	@Override
	public void move() {
		System.out.println(getType() + " monkeying around");
	};
	@Override
	public void sleep() {
		System.out.println(getType() + " sleeping after monkeying around");
	};
	
	
};
