package israels.core_java.common.animal.mammals;

public class Gazelle extends Mammal {

	public Gazelle() {
		
		setType("gazelle");
		setMaxRunningSpeed(50);
		MAX_AGE = 15;
		MATURITY = 2;
		BIRTH_WEIGHT = 5;
		ADULT_FEMALE_MIN_WEIGHT = 33;
		ADULT_FEMALE_MAX_WEIGHT = 55;
		ADULT_MALE_MIN_WEIGHT = 44;
		ADULT_MALE_MAX_WEIGHT = 77;
	}
	
	
	// Animal Override
	public void sleep() {
		
		
		System.out.println(getType() + " sleeps for 5 mins.");
		
		
	};
	
	public void eat() {
	
		System.out.println(getType() + " eats peacefully on the plains..");
	};

}
