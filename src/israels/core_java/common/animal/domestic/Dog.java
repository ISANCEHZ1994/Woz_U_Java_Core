package israels.core_java.common.animal.domestic;
import java.util.concurrent.ThreadLocalRandom;

import israels.core_java.common.animal.Pet;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.birds.Raptor;
import israels.core_java.common.animal.mammals.Carnivora;


// NOTE: it WAS Nameable, Domesticatable - HOWEVER Pet does both!
public class Dog extends Carnivora implements Pet{ // To use interface we MUST IMPLEMENT 
	// NOTE: Below are two ways to format the same things  ( either all in one line or in 3)
	
// ********************************** VARIABLES, GETTERS AND SETTERS SECTION ***************************************************
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
	public void setBreed( String s) { breed = s; };

// ********************************** CONSTRUCTOR SECTION ***************************************************

	public Dog() { // Constructor!
		setType("dog");
		MAX_AGE = 16;
		MATURITY = 2;
		prey.add(" table scraps");
		prey.add(" dog food");
		prey.add(" a bone");
		prey.add(" canned dog food");
		prey.add(" grass from the lawn");
		
		
	};
	
	public Dog(String d) {
		this();
		name = d;
	}
	
// ********************************** METHOD SECTION ***************************************************
	
	@Override
	public boolean equals(Object other) {
		if(this == other) { return true;}
		boolean result = false;
		if(other instanceof Carnivora) {
			result = super.equals(other)
					&& name.equals(((Dog)other).name)
					&& breed.equals(((Dog)other).breed);
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		int code = super.hashCode();
		// ^= is the bitwise XOR assignment operator
		 code += name.hashCode();
		 code ^= breed.hashCode();
		return code;
	}

	@Override
	public boolean hasLicense() {
		return true;
	};
	
	@Override
	public void beFriendly() {
		
		String describe = name + " the " + breed;
		System.out.println(describe + " licks your face!");
		
	};
	
	// Overloading Method
	public Dog[] reproduce(int number) {
		Dog[] litter = new Dog[number]; 
		if (getSex() == Sex.MALE) {
			System.out.println("Male " + getType() + " looks for female " + getType());
			return null;
		}  
		if(getAge() > MATURITY) {
			for(int i = 0; i < litter.length; i++) {
				Dog baby = new Dog();
				if(ThreadLocalRandom.current().nextBoolean()) {
					baby.setSex(Sex.MALE);	
					}	
				litter[i] = baby;
			}
		}else {
			return null;
		}
		return litter;
	}; // closes Reproduce
	
	
}; // Closes Dog Class
