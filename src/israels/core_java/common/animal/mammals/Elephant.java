package israels.core_java.common.animal.mammals;

import java.util.concurrent.ThreadLocalRandom;

import israels.core_java.common.animal.Sex;

//import java.util.concurrent.ThreadLocalRandom;

//import israels.core_java.common.animal.mammals;

public class Elephant extends Mammal{
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	

// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	{
	    setType("elephant"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		MAX_AGE = 70;
		MATURITY = 15;
		BIRTH_WEIGHT = 200;
		ADULT_FEMALE_MIN_WEIGHT = 5_300;
		ADULT_FEMALE_MAX_WEIGHT = 7_700;
		ADULT_MALE_MIN_WEIGHT = 8_800;
		ADULT_MALE_MAX_WEIGHT = 13_900;
	}
	
	
	public Elephant() { // No argument Constructor! - NOT a Default Constructor
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
	};
	
	public Elephant(int a) {
		setAge(a);
		setWeight(setRandomWeightByAge(a));
	}
	
	
// --------------------------> METHOD SECTION <----------------------------------------------------------
	
	// Class Animal OVERRIDES
	@Override
	public void eat() {
		System.out.println(getType() + " chomping tree branches");
	};
	@Override
	public void move() {
		System.out.println(getType() + " shuffling ponderously");
	};
	@Override
	public void sleep() {
		System.out.println(getType() + " sleeping under a starlit sky");
	};
	
	
	// Elephant return type is a COVARIANT RETURN look to lesson3! 
	// reproduce was taken from Animal 
	public Elephant reproduce() {
		if (getSex() == Sex.MALE) {
			System.out.println("Male " + getType() + " looks for female " + getType());
			return null;
		}
		if(getAge() > MATURITY){
			Elephant baby = new Elephant();
			if(ThreadLocalRandom.current().nextBoolean()) {
			baby.setSex(Sex.MALE);	
			}		
			return baby;	
			}	
				else {
			System.out.println("Female " + getType() + " is not old enough.");
			return null;
		}
	};
	
	
	
};
