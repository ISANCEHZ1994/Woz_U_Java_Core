package israels.core_java.common.animal.fish;

public class Swordfish extends Fish {
	// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	

	// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
		
		{
			System.out.println("In the Swordfish initialization block <=============");
			setType("swordfish"); // THIS IS WHY WE USE PROTECTED in Animal Class!!
			MAX_AGE = 70;
			MATURITY = 15;
			// prey.add("squid"); cant use prey because i have to make it carnivore
		}
		
		public Swordfish() { // No argument Constructor! - NOT a Default Constructor
		//	super(); // super runs any init blocks from the top down => you don't need to write super it automatically does it!
//			System.out.println("IN SWORDFISH CONSTUCTOR (no arg) Constructor");
		};
		
		
		public Swordfish(int a) { // Argument Constructor!
			System.out.println("IN SWORDFISH CONSTUCTOR (int a) Constructor");
			setAge(a);
			setWeight(setRandomWeightByAge(a));
		}
		
		
	// --------------------------> METHOD SECTION <----------------------------------------------------------
		
		// Class Animal OVERRIDES
		@Override
		public void eat() {
			System.out.println(getExtendedType() + " eating krill");
		};
		@Override
		public void move() {
			System.out.println(getExtendedType() + " swims like a torpedo");
		};
		@Override
		public void sleep() {
			System.out.println(getExtendedType() + " - what is sleep?");
		};
		

}
