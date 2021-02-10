package israels.core_java.common.animal.domestic;

import israels.core_java.common.Nameable;
import israels.core_java.common.animal.Domesticatable;
import israels.core_java.common.animal.mammals.Mammal;

//import israels.core_java.common.animal.mammals;

public class Horse extends Mammal implements Nameable, Domesticatable{
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	// Supports Nameable Interface
	private String name; // <= Follow encapsulation convention (that's why its private)!!
	public String getName() {  
		return name;
	};
	public void setName(String s) {
		name = s;
	};
	
	// Supports Domesticatable
	private String breed;
	public String getBreed() { return breed; };
	public void setBreed( String s) { s = breed; };
	

// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	
	public Horse() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("horse"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		MAX_AGE = 30;
		MATURITY = 6;
	};
	
	
// --------------------------> METHOD SECTION <----------------------------------------------------------
	
	@Override
	public void eat() {
		System.out.println(getExtendedType() + " grazing and eating grass");
	};
	@Override
	public void move() {
		System.out.println(getExtendedType() + " proudly stomps feet");
	};
	@Override
	public void sleep() {
		System.out.println(getExtendedType() + " kneels before a beautiful night");
	}



};
