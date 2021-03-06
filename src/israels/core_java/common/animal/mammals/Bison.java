package israels.core_java.common.animal.mammals;

import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.ecosystem.EcosystemType;

public class Bison extends Mammal {
	
	{
		MAX_AGE = 20;
		FEMALE_MATURITY = 4;
		MALE_MATURITY = 4; 
		BIRTH_WEIGHT = 1;
		ADULT_FEMALE_MIN_WEIGHT = 790;
		ADULT_FEMALE_MAX_WEIGHT = 1200;
		ADULT_MALE_MIN_WEIGHT = 1000;
		ADULT_MALE_MAX_WEIGHT = 2200;
		TEETH = 42;
	}
	
	public Bison() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("bison"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		setEcosystem(EcosystemType.YELLOWSTONE);
		setMaxRunningSpeed(35);

	};
	
	public Bison(int age, int weight, Sex sex) {
		this();
		setAge(age);
		setWeight(weight);
		setSex(sex);
	}
	
	@Override
	public void sleep() {
		System.out.print(this + " sleeping with herd ");
		while (getHealth() < 3) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(1);
		}
		System.out.println( "Health: " +  getHealth());
	}
	
	@Override
	public void move() {
		if(getAge() > MAX_AGE) {
			return;
		}else if(getAge() > MAX_AGE - 2) {
			System.out.println(getExtendedType() + "old bear moves very slowly");
			changeHealth(-4);
		}else if(getAge() > MATURITY) {
			System.out.println(getExtendedType() + " is roaming around the forest");
			changeHealth(-2);
		}else if(getAge() == 0) {
			 System.out.println(" bear cub playing with siblings");
		}else {
			System.out.println("Young bear learning to sneak up on prey");
		}
	};
	
//	public void somethingHere() {
//		if( getAge() )
//	}
	
}
