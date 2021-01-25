package israels.core_java.common.animal.mammals;

import java.util.*;
import israels.core_java.common.animal.*;


public abstract class Carnivora extends Mammal implements Carnivore {
	
	
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	protected List <String> prey = new ArrayList<>();
	
	protected String preyFound = null; // note: not nessesary to say null - itll do it by default but good practice!
	protected String preyCaught = null; 
	
// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	
	public Carnivora() {
		setType("uknown carnivore");
		
		
	};
	
// --------------------------> METHOD SECTION <----------------------------------------------------------
	// Animal Overrides
	@Override
	public void eat() {
		if(preyCaught == null || preyCaught.isEmpty()) {
			System.out.println(getType() + " has nothing to eat!!");
		}else {
			System.out.println(getType() + " eats a " + preyCaught);
			preyCaught = null;
		}
	};
	
	
	// Support Carnivore Interface
	@Override
	public void hunt() {
		
		findPrey();
		catchPrey(null);
		eat();

	}

	@Override
	public String findPrey() {
		if(preyFound == null) {
			int x = (int)(Math.random() * prey.size()); // we use .size() because it is a COLLECTION of ArrayLists
			// ArrayLists you can CHANGE but Arrays are STATIC - you CANNOT
			preyFound = prey.get(x);
		}
		return null;
	}

	@Override
	public boolean catchPrey(Animal target) {
		if(preyFound == null || preyFound.isEmpty()) {
			System.out.println(getType() + " has not found food yet!");
			return false;
		}else {
			double probability = Math.random();
			if( probability > .5 ) {
				preyCaught = preyFound;
				return true;
			} // closes IF
		} // closes ELSE
		return false;
	}

}
