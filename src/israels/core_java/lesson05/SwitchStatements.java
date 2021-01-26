//  switch statements are branching statements that check for discrete values
// 			All versions of Java switch works with ins
//          As of Java 5 switch works with enums
// 			As of Java 7 switch works with Strings
//  switch statements only check for equality
//	each case branch 
//  the default case is optional and can be placed anywhere in the switch statement

package israels.core_java.lesson05;

public class SwitchStatements {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		basicSwitchStatement();
		// See switch on enum AnimalType in RandomAnimalBuilder
		
		breakAndFallThrough();
		switchOnStrings();
		
		System.out.println("=========================================================================\n\n");
	}
	
	public void basicSwitchStatement() {
		System.out.println("1. Switching on ints <== ");
		
		int x = 1;
		//short x = 2;  these can easily fit into int!
		//byte x = 2;
		int total = 0;
		
		switch(x) {
		case 1:
			System.out.println("x is 1");
			total += x;
			break;
		case 2:
			System.out.println("x is 2");
			total += x;
			break;
		case 3:
			System.out.println("x is 3");
			total += x;
			break;
		default:
			System.out.println("x is something else");
			total += x;
			break;
		}
		
		System.out.println("Total = " + total);
		System.out.println();
	}

	private void breakAndFallThrough() { // with not breaks - ALL methods will execute
System.out.println("2. Break and Fall Through <== ");
		
		int x = 1;
		int total = 0;
		
		switch(x) {
		case 1:
			System.out.println("x is 1");
			total += x;
		case 2:
			System.out.println("x is 2");
			total += x;
		case 3:
			System.out.println("x is 3");
			total += x;
		default:
			System.out.println("x is something else");
			total += x;
		}
		
		System.out.println("Total = " + total);
		System.out.println();
	}
	
	private void switchOnStrings() {
		System.out.println("3. Switch on Strings (as of Java 7) <====");
		
		String dow = "Tuesday";
		
		switch (dow.toLowerCase()) { // our string has capital letters
		case "monday":
			System.out.println("I really hate MONDAYS...");
			break;
		case "tuesday":
			System.out.println("TACO TUESDAY, LET'S GOOOOOOOooOooOoOOOOO");
			break;
		case "wednesday":
			System.out.println("HUMP DAYYYY");
			break;
		case "thursday":
			System.out.println("Close to Friday - JUST ONE MORE DAY");
			break;
		case "friday":
			System.out.println("PARTY TIMEEEEEEEE!");
			break;
		default: 
			System.out.println("Its the weekend!");	
			
		}
		
	}
	
}
