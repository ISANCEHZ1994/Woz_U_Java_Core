package israels.core_java.common.animal.mammals;

import israels.core_java.common.animal.Sex;

public class Bear extends Carnivora {

	
	
	{
		MAX_AGE = 30;
		MATURITY = 5; 
		BIRTH_WEIGHT = 1;
		ADULT_FEMALE_MIN_WEIGHT = 290;
		ADULT_FEMALE_MAX_WEIGHT = 440;
		ADULT_MALE_MIN_WEIGHT = 400;
		ADULT_MALE_MAX_WEIGHT = 790;
		TEETH = 42;
	}
	
	public Bear() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("bear"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		
		setMaxRunningSpeed(35);
		prey.add("");
		
	};
	
	public Bear(int age, int weight, Sex sex) {
		this();
		setAge(age);
		setWeight(weight);
		setSex(sex);
	}
	
	
	@Override
	public void sleep() {
		System.out.print(this + " sleeping: ");
		while (getHealth() < 3) {
			System.out.print(getHealth() + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			changeHealth(1);
		}
		System.out.println(getHealth());
	}
	
}
