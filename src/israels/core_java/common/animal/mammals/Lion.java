

package israels.core_java.common.animal.mammals;
import israels.core_java.common.animal.Sex;

//import israels.core_java.common.animal.mammals;

public class Lion extends Carnivora{
	
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	
	private String name; // <= Follow encapsulation convention (that's why its private)!!
	public String getName() {  return name; };
	public void setName(String s) { name = s; };
	// NOTE: we need these variables for the Interface.java in Lesson02

// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	
	public Lion() {
		// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
		setType("lion"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
		MAX_AGE = 14;
		MATURITY = 5; 
		BIRTH_WEIGHT = 200;
		ADULT_FEMALE_MIN_WEIGHT = 250;
		ADULT_FEMALE_MAX_WEIGHT = 400;
		ADULT_MALE_MIN_WEIGHT = 330;
		ADULT_MALE_MAX_WEIGHT = 550;
		setMaxRunningSpeed(50);
		prey.add("gazelle");
		prey.add("wildebeast");
		prey.add("impala");
		prey.add("monkey");
		prey.add("gnu");
		prey.add("baboon");
	};
	
	public Lion(int age, int weight, Sex sex) {
		this();
		setAge(age);
		setWeight(weight);
//		setWeight(setRandomWeightByAge(weight));
		setSex(sex);
	}
	
	
// --------------------------> METHOD SECTION <----------------------------------------------------------
	
	@Override
	public void eat() {
		System.out.println(getType() + " devouring zebras");
	};
	
	
	@Override
	public void move() {
		if(getAge() > MAX_AGE) {
			return;
		}else if(getAge() > MAX_AGE - 2) {
			System.out.println(getType() + "old lion moves very slowly");
			changeHealth(-4);
		}else if(getAge() > MATURITY) {
			System.out.println(getType() + " is majestically prowling the pridelands");
			changeHealth(-2);
		}else if(getAge() == 0) {
			 System.out.println(" lion cub plahing with siblings");
		}else {
			System.out.println("Young lion learning to sneak up on prey");
		}
	};
	
	@Override
	public void sleep() {
		System.out.println(getType() + " sleeping with the pride");
	};
	
	
};
