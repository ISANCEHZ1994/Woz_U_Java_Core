package israels.core_java.common.animal.domestic;
import java.util.List;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Pet;
import israels.core_java.common.animal.mammals.Carnivora;


// NOTE: it WAS Nameable, Domesticatable - HOWEVER Pet does both!
public class Cat extends Carnivora implements Pet{ // To use interface we MUST IMPLEMENT 
	// NOTE: Below are two ways to format the same things  ( either all in one line or in 3)
	
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
	public void setBreed( String s) { breed = s; }; // DON'T SWITCH => will come back NULL
	
	public Cat() { // Constructor!
		setType("cat");
		MAX_AGE = 16;
		MATURITY = 2;
		prey.add("eats mice");
		prey.add("cat food");
		prey.add("some birds");
		prey.add("SOULS OF THE DAMNED");
		prey.add("Greg's messed up face");		
		
	};
	
	
	@Override
	public boolean hasLicense() {
		// TODO Auto-generated method stub
		return false;
	};
	@Override
	public void beFriendly() { // ITS A CAT IMPOSSIBLE LOL
		// TODO Auto-generated method stub
		String describe = name + " the" + breed;
		System.out.println(describe + "contemplates your death, WATCH OUT!");
	};
	
	@Override
	public void hunt(List<? extends Animal> nearbyAnimals) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}
	
	
};
