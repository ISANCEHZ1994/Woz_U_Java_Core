package israels.core_java.common.animal.mammals;

import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.ecosystem.EcosystemType;

public class Cougar extends Carnivora {
	// NOTES ABOUT COUGARS
	
		{
			MAX_AGE = 12;
			FEMALE_MATURITY = 2;
			MALE_MATURITY = 2; 
			BIRTH_WEIGHT = 1;
			ADULT_FEMALE_MIN_WEIGHT = 64;
			ADULT_FEMALE_MAX_WEIGHT = 140;
			ADULT_MALE_MIN_WEIGHT = 120;
			ADULT_MALE_MAX_WEIGHT = 220;
			TEETH = 42;
		}
		
		public Cougar() {
			// remember private makes it invisible to other classes so we can't get the variable: type inside of Animal
			setType("cougar"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
			setEcosystem(EcosystemType.YELLOWSTONE);
			setMaxRunningSpeed(50);
			prey.add("deer");
			prey.add("elk");
			prey.add("moose");
			prey.add("moutain goat");
			prey.add("coyotes");
			prey.add("hare");
			
			
		};
		
		public Cougar(int age, int weight, Sex sex) {
			this();
			setAge(age);
			setWeight(weight);
			setSex(sex);
		}
		
		
		@Override
		public void sleep() {
			System.out.print(this + " sleeping by itself ");
			while (getHealth() < 3) {
				System.out.print(getHealth() + " ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) { e.printStackTrace(); }
				changeHealth(1);
			}
			System.out.println(getHealth());
		}
		
		@Override
		public void move() {
			if(getAge() > MAX_AGE) {
				return;
			}else if(getAge() > MAX_AGE - 2) {
				System.out.println(getType() + "old cougar moves very slowly");
				changeHealth(-4);
			}else if(getAge() > MATURITY) {
				System.out.println(getType() + " moves swiftly and slient");
				changeHealth(-2);
			}else if(getAge() == 0) {
				 System.out.println(" cougar cub plahing with siblings");
			}else {
				System.out.println("Young cougar learning to sneak up on prey");
			}
		};
}
