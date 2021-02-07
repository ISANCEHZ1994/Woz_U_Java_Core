package israels.core_java.common.animal.mammals;

import java.util.*;
import israels.core_java.common.animal.*;


public abstract class Carnivora extends Mammal implements Carnivore {
	
	
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	private int maxRunningSpeed = 1;
	
	public void setMaxRunningSpeed(int speed) {
		if(speed > 1) {
			maxRunningSpeed = speed;
		}
	
	};
	

	
	protected List <String> prey = new ArrayList<>();
	
	protected transient String preyFound = null; // note: not nessesary to say null - itll do it by default but good practice!
	protected transient String preyCaught = null; 
	
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
	
	@Override
	public boolean equals(Object other) {
		if(this == other) { return true;}
		boolean result = false;
		if(other instanceof Mammal) {
			result = super.equals(other)
					&& maxRunningSpeed == ((Mammal)other).maxRunningSpeed;
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		int code = super.hashCode();
		
		return code;
	}
	
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
		return preyFound;
	}
	
	// Overload the findPrey() method to use a list of animals
	public Animal findPrey(List<? extends Animal> nearbyAnimals) {
		// Looking for prey takes energy, so decrease the health
		changeHealth(-1);
		
		// Scan the nearby animals to see if any are on the preferred list
		List<Animal> possibleTargets = new ArrayList<>();
		System.out.print(this + " sees ");
		
		// In a loop create a list of possible targets
		for( Animal animal : nearbyAnimals) {
			for(String type : prey) { // prey is coming from the(at the) top variable - prey
				if(animal.getType().contains(type)) {
					System.out.print(animal + ", ");
					possibleTargets.add(animal);
				};
			}
		}
		System.out.println();
		
		// Print out a list of possible targets
//		System.out.println(possibleTargets); // technically already written above!
		
		// Set up the process of selecting a target in its own thread - we want them to act alone(their own thread)
			Animal target = null;
			synchronized(nearbyAnimals) { //synchronized - prevents bad things from happening 
				// when you use more than one thread
				
				// Find the weakest target
				if(possibleTargets.size() > 0) {
					for(Animal a : possibleTargets) {
						if( a.isTargeted() ) continue;
						if( target == null ) {
							target = a;
						}else if ( a.getHealth() < target.getHealth() ){
							target = a;
						}
 					}
				} 
				
				// Set the target in preyFound
				if(target == null) {
					System.out.println(this + " could not find prey!"); // this NOT getType because we want the individual animal 
					preyFound = null;
				}else {
					target.setTargeted(true);
					preyFound = target.getType();
					System.out.println(this + " selected a " + target);
				}
				
			};
			
		// Return the target to use in the catchPrey method
		return target;
	};

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
