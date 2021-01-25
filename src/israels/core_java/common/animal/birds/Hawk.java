package israels.core_java.common.animal.birds;

import israels.core_java.common.animal.Animal;

public class Hawk extends Raptor {

	public Hawk() {
		setType("hawk");
		MAX_AGE = 12;
		MATURITY = 2;
		prey.add("mouse");
		prey.add("squirrel");
		prey.add("trutle");
		
	}

	@Override
	public boolean catchPrey(Animal target) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void move() {
		
	};

}
