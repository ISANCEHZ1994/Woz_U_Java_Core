package israels.core_java.common.animal.reptiles;

import java.util.List;

import israels.core_java.common.animal.Animal;

public class Snake extends Reptile {

	public Snake() {
		setType("snake");
		MAX_AGE= 100;
		MATURITY = 4;
		prey.add("swans");
		prey.add("snakes");
		prey.add("rat");
		prey.add("squirels");
	}
	
//	@Override
//	public void eat() {
//		System.out.println(" is found eating a mouse");
//	}
//	@Override
//	public void move() {
//		System.out.println(" can move at 22mph");
//	}
	
	@Override
	public void hunt(List<? extends Animal> nearbyAnimals) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}

}
