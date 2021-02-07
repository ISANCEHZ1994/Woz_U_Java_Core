package israels.core_java.lesson01;

public class WorkingWithStrings {   
	public void inClassWork() {
		
		// methods and variables are ALWAYS lower case!
		
		System.out.println(this.getClass().getSimpleName() + " .inClassWork()");
		
		stringConcatenation();
		caseStudies(); 
		otherUsefulStringMethods();
		
		System.out.println();
	};
	
	private void stringConcatenation() {
		
		System.out.println("1. String concatenation");
		String y = "Sail";
		
		y = y + ' ' + "to the HIGH seas....or "; // Single '' ONLY ONE CHARACTER; DOUBLE "" ANYTHING;
		
		// += concatenates whatever is on the right with y and then reassigns the result to y
		// also known as a COMPOUND ASSIGNMENT OPERATOR
		y += "Atlantic";
		
		System.out.println("y = " + y);
		
		// Using the concat() method
		y = y.concat(" Ocean..whatever I'm just some text lol");
		System.out.println("y = " + y);
		
		// Strings can be concatenated with numbers
		String numTest = "number test";
		System.out.println(17 + 3 + numTest); // <= 20number test - 17 + 3 is ADDITION
		System.out.println(17 + numTest + 3); // <= 17number test3
		System.out.println(numTest + 17 + 3); // <= number test173 - this is String Concatenation
		
	};
	
	private void caseStudies() {
		System.out.println("2. Case Studies");
		
		String hobbit = "Bilbo Baggins";
		System.out.println("Original String = " + hobbit);
		System.out.println("UpperCASE = " + hobbit.toUpperCase());
		System.out.println("lowercase = " + hobbit.toLowerCase());
		
		String hobbit2 = "bilbo baggins";
		System.out.println(hobbit == hobbit2); // will NOT be equal!
		System.out.println(hobbit.equals(hobbit2)); // ALSO not equal!
		System.out.println(hobbit.equalsIgnoreCase(hobbit2)); // returns TRUE

	};
	
	private void otherUsefulStringMethods() {
		System.out.println("3. Other Useful Methods");
		String s = "Contentment!";
		String s2 = "";
		System.out.println("isEmpty() => " + s.isEmpty()); // => false
		System.out.println("isEmpty() => " + s2.isEmpty()); // => true
		System.out.println("contains() => " + s.contains("tent")); // => true
		System.out.println("endsWith() => " + s.endsWith("!")); // => true
		System.out.println("lenght() => " + s.length()); // => 12
		System.out.println("substring() => " + s.substring(4)); // => entment!
		 
		
	}
	
};
