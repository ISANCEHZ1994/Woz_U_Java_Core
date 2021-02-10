package israels.core_java.common.animal.mammals;

//import israels.core_java.common.animal.mammals;

public class Gorilla extends Mammal{
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	

// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	
	public Gorilla() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("gorilla"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
	};
	
	
// --------------------------> METHOD SECTION <----------------------------------------------------------
	@Override
	public void eat() {
		System.out.println(getExtendedType() + " eats banannas");
	};
	@Override
	public void move() {
		System.out.println(getExtendedType() + " moves around terrority");
	};
	@Override
	public void sleep() {
		System.out.println(getExtendedType() + " sleeping after protecting pride");
	};
	
	
};
