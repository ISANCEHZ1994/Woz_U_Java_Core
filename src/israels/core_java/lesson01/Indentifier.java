package israels.core_java.lesson01;

// import israels.core_java.lesson01.exercises.Dog;

/*
 * Rules for INDENTIFER:
 * 
 *  MUST start with a letter, dollar sign or underscore
 *  MAY CONTAIN letters, numbers, underscore and dollar sign
 *  NO limit to length
 *  CAN'T use a Java keyword
 *  INDENTIFER are case SENSITIVE
 *  
 */

public class Indentifier {
	String test = "instance variable";
	
	public void inClassWork() { // anything inside is considered LOCAL VARIABLES 
		System.out.println(this.getClass().getSimpleName() + " .inClassWork()");
		
	//  legal identifiers
		int fasdfajoeifndklfksjLTHISisweridlyRIGHT;
		int _a;
		int $c;
		int ______2ser;
		int _$;
		byte e7 = 10;
		String Class = "Bad Indentifer"; // <= Just because you CAN, DOESN'T mean you should!
		
		
	//	illegal identifiers
		
	//	byte 7e = 10;
	//	short default;
		
		String test = "1st String";
		String Test = " 2nd String"; // DOESN'T FOLLOW CONVENTIONS!! - again you CAN, BUT you shouldn't
		System.out.println( test + Test);
		
		// WITHOUT an IMPORT STATEMENT, must put path name
		israels.core_java.lesson01.exercises.Dog myDog = new israels.core_java.lesson01.exercises.Dog();
		myDog.sleep();
		
	}
	

	
}
