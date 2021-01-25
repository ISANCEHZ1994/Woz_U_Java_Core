
/*
 * Local Variables declared in a method are NOT automatically initialized
 * 
 * instance variables declared at the class level WITHOUT the static keyword
 * class variables declared at the class level WITH the static keyword
 */
package israels.core_java.lesson01;
import israels.core_java.lesson01.exercises.Dog;

public class Initialization {
	// Below all will be AUTOMATICALLY initialized~
	Dog topDog;
	int instantInt;
	double instantDouble;
	boolean instantBoolean;
	char instantChar;
	
	public void inClassWork(){
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
		// Local Variables are not initialized
		// int x;
		// System.out.println(x); // => Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		// The local variable x may not have been initialized
		
		 Dog aDog;
		 
		// Reference variables that are at the class level are automatically initialized to null
		System.out.println(topDog); // => returns null 
		System.out.println(instantInt); // => returns 0
		System.out.println(instantDouble); // => 0.0
		System.out.println(instantBoolean); // => false
		System.out.println(instantChar); // returns nothing because there is no CHARACTER 
		
		// Arrays, even local arrays are initialized using default values
		
		int [] nums = new int[4];
		for( int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		};
		
		Dog[] pets = new Dog[4];
		for (int i = 0; i < pets.length; i++ ) {
			System.out.println(pets[i]);
		}
		
	}
	
	
}
