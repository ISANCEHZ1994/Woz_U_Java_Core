package israels.core_java.common.animal.mammals;

import java.util.List;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.ecosystem.EcosystemType;

public class Wolf extends Carnivora {

// NOTES ABOUT GRAY WOLVES
	
	{
		MAX_AGE = 13;
		FEMALE_MATURITY = 2;
		MALE_MATURITY = 3; 
		BIRTH_WEIGHT = 1;
		ADULT_FEMALE_MIN_WEIGHT = 50;
		ADULT_FEMALE_MAX_WEIGHT = 85;
		ADULT_MALE_MIN_WEIGHT = 70;
		ADULT_MALE_MAX_WEIGHT = 110;
		TEETH = 42;
		
	};
	
	public Wolf() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("wolf"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		setEcosystem(EcosystemType.YELLOWSTONE);
		setMaxRunningSpeed(37);
		prey.add("deer");
		prey.add("elk");
		prey.add("bison");
		prey.add("moose");
		prey.add("beaver");
		prey.add("hare");
		
	};
	
	public Wolf(int age, int weight, Sex sex) {
		this();
		setAge(age);
		setWeight(weight);
		setSex(sex);
	};
	
	
	@Override
	public void sleep() {
		System.out.print(this + " sleeping with the pack ");
		while (getHealth() < 3) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(1);
		}
		System.out.println("Health: " + getHealth());
	};
	
	@Override
	public void move() {
		if(getAge() > MAX_AGE) {
			return;
		}else if(getAge() > MAX_AGE - 2) {
			System.out.println(getExtendedType() + "old wolf moves very slowly");
			changeHealth(-4);
		}else if(getAge() > MATURITY) {
			System.out.println(getExtendedType() + "moves swiftly and slient");
			changeHealth(-2);
		}else if(getAge() == 0) {
			 System.out.println("wolf cub plahing with siblings");
		}else {
			System.out.println("Young wolf learning to sneak up on prey");
		}
	};
	
	public void hunt(List<? extends Animal> nearbyAnimals) {
		if (getAge() > MAX_AGE) {
			return;
		} else if (getAge() == 0) {
			System.out.println("Wolf cub batting a stick");
			return;
		} else if (getAge() < 2) {
			System.out.println("Young wolf learning to sneak up on rabbit.");
			return;
		}
		
		if (getHealth() < 0 ) {
			System.out.println(this + " is too weak to hunt: " + getHealth());
			sleep();
		}
		System.out.println(this + " is hunting with a health of " + getHealth());
		// Conditions are met and the Cheetah looks for prey
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) { e.printStackTrace(); }
		Animal target = findPrey(nearbyAnimals);

		changeHealth(-1);
		if (target != null) {
			System.out.println(this.getExtendedType() + " is stalking a " + target.getExtendedType());
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(-1);
			
			if  (catchPrey(target)) {
				nearbyAnimals.remove(target);
//				eat();
			}
//    		eat();
		}
	};
	
	
	
	public void eat(String food) {
		System.out.println(getExtendedType() + " eats " + food);
	}
	

	
};
