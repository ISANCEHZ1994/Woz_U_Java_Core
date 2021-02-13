package israels.core_java.common.animal.birds;

import java.util.List;

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
	
//	public Hawk[] reprodouce(int i) {
//		if(getAge() >= MATURITY && getSex() == sex.Female) {
//			
//		}
//	}

	@Override
	public boolean catchPrey(Animal target) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void move() {
		
	}

	@Override
	public boolean canRun() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void hunt(List<? extends Animal> nearbyAnimals) {
		if (getAge() > MAX_AGE) return;		// the hunter is dead
		hunt();
	}

//	@Override
//	public boolean canSwim() {
//		// TODO Auto-generated method stub
//		return false;
//	};

}
