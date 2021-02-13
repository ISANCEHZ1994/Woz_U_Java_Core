package israels.core_java.common.animal.reptiles;

import java.util.List;

import israels.core_java.common.animal.Animal;

public class Crocodile extends Reptile {
	
	public Crocodile() {
		setType("Crocodile");
		MAX_AGE= 100;
		MATURITY =10;
		prey.add("swans");
		prey.add("snakes");
		prey.add("rat");
		prey.add("fish");
	};
	
	
	@Override
	public void hunt(List<? extends Animal> nearbyAnimals) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}
	
}
