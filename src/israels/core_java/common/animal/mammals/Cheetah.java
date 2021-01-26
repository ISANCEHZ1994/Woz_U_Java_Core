package israels.core_java.common.animal.mammals;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.AnimalType;
import israels.core_java.common.animal.RandomAnimalBuilder;


public class Cheetah extends Carnivora {

	//**************************** VARIABLES SECTION ******************************​
	//*************************** CONSTRUCTOR SECTION *****************************
		public Cheetah() {
			setType("cheetah");
			MAX_AGE = 15;
			MATURITY = 4;
			prey.add("gazelle");
			prey.add("baby wildebeest");
			prey.add("impala");
			prey.add("rabbit");
			prey.add("warthog");
			setMaxRunningSpeed(75);
		}
//****************************** METHOD SECTION *******************************​
		// Object overrides
		@Override
		public boolean equals(Object other){
			boolean result = false;
			if (other instanceof Cheetah) {
				result = super.equals(other);
			}
			return result;
		}
		// Animal overrides
		@Override
		public void eat() {
			if (getAge() < 2) {
				if (preyCaught == null && Math.random() > .7) {
					preyCaught = "rabbit";
					System.out.println("Mother brings a " + preyCaught);
				}
			}
			super.eat();
		}
		@Override
		public void move() {
			changeHealth(-1);
			if (getAge() > MAX_AGE) 
				return;
			else if (getAge() > MAX_AGE-2)
				System.out.println("Old cheetah moves very slowly.");
			else if (getAge() > MATURITY) 
				System.out.println(getType() + " charging a herd of " + findPrey());
			else if (getAge() == 0)
				System.out.println("Cheetah cub batting a stick");
			else
				System.out.println("Young cheetah learning to sneak up on rabbit.");
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
		@Override
		public void setRandomWeightByAge () {
			// Female adults are between 50 and 140 lbs
			// Male adults are between 88 and 150 lbs
			// Cheetah cubs are born at about 10 lbs
			setRandomWeightByAge(50, 140, 88, 150, 10);
		}
		
		@Override
		public Cheetah reproduce() {
			if (getAge() >= MATURITY && getSex() == Sex.FEMALE) 
				return new Cheetah();
			else {
				System.out.println(getType() + " not old enough or is male");
				return null;
			}
		}
		
		// Carnivore override
		@Override
		public void hunt() {
			List<Animal> nearbyAnimals = (List<Animal>)new RandomAnimalBuilder(AnimalType.MAMMAL)
					.build(ThreadLocalRandom.current().nextInt(3, 10));
			hunt(nearbyAnimals);
		}
		
		// Carnivore overload
		public void hunt(List<? extends Animal> nearbyAnimals) {
			
			if (getAge() > MAX_AGE) {
				return;
			} else if (getAge() == 0) {
				System.out.println("Cheetah cub batting a stick");
				return;
			} else if (getAge() < 2) {
				System.out.println("Young cheetah learning to sneak up on rabbit.");
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
				System.out.println(this.getType() + " is stalking a " + target.getType());
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) { e.printStackTrace(); }
				changeHealth(-1);
				
				if  (catchPrey(target)) {
					nearbyAnimals.remove(target);
					eat();
				}
	    		eat();
			}
		}
		
		// Cheetah methods
		public boolean catchPrey(Animal target) {
			int age = getAge();
			double probability = Math.random();
			if (age > MAX_AGE) return false;
			
			if (target != null) {
				System.out.println(this + " chasing a " + target + " with a health of " + target.getHealth());
				target.move();
				changeHealth(-1);
				target.changeHealth(-1);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) { e.printStackTrace(); }
				if (target.isTargeted() && age > 2
					&& ((age < 5 && probability > .7)
					|| (age < 12 && probability > .4)
					|| (age >= 12 && probability > .5) ) ) {
					System.out.println(this +  " caught a " + target.getType() + " in the grass!");
					this.preyCaught = target.getType();
					return true;
				} else {
					System.out.println(this + " could not catch the " + target.getType());
					this.preyFound = null;
					target.setTargeted(false);
				}
			} else {
				this.preyFound = null;
				System.out.println(this + " could not find prey!");
			}
			return false;
		}
	
}
