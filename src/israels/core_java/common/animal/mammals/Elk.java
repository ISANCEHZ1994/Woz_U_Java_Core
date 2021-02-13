package israels.core_java.common.animal.mammals;

import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.ecosystem.EcosystemType;

public class Elk extends Mammal{

	{
		MAX_AGE = 13;
		FEMALE_MATURITY = 4;
		MALE_MATURITY = 4; 
		BIRTH_WEIGHT = 1;
		ADULT_FEMALE_MIN_WEIGHT = 290;
		ADULT_FEMALE_MAX_WEIGHT = 400;
		ADULT_MALE_MIN_WEIGHT = 400;
		ADULT_MALE_MAX_WEIGHT = 790;
		TEETH = 42;
	}
	
	public Elk() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("elk"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		setEcosystem(EcosystemType.YELLOWSTONE);
		setMaxRunningSpeed(45);

	};
	
	public Elk(int age, int weight, Sex sex) {
		this();
		setAge(age);
		setWeight(weight);
		setSex(sex);
		
	}
	
	@Override
	public void sleep() {
		System.out.print(this + " sleeping with gang ");
		while (getHealth() < 3) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(1);
		}
		System.out.println( "Health: " +  getHealth());
	}
	
//	@Override
//	public void move() {
//		if(getAge() > MAX_AGE) {
//			return;
//		}else if(getAge() > MAX_AGE - 2) {
//			System.out.println(getExtendedType() + "old elk moves very slowly");
//			changeHealth(-4);
//		}else if(getAge() > MATURITY) {
//			System.out.println(getExtendedType() + " is roaming around the forest");
//			changeHealth(-2);
//		}else if(getAge() == 0) {
//			 System.out.println(" baby elk playing with siblings");
//		}else {
//			System.out.println("Young elk stomps gailiantly thru the forest");
//		}
//	};
	
	@Override
	public void move() {
		if(isRunning()) {
			super.move();
			System.out.println(getExtendedType() + " running for its life!!");
			changeHealth(-3);
		}else {
			System.out.println(getExtendedType() + " walking slowly with the herd to find new grazing lands");
			changeHealth(-1);
		}
	}
	
	
}
