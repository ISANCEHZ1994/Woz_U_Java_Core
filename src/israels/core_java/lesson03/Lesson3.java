/*
 * 
 * Overloading provides a way to perform an operation on different types of input.
 *
 * Rules for overloading a method
 *   1. The argument list must be different
 *   2. The return type may be different
 *   3. The access level may be different
 *   4. Must be in the same class or subclass
 *   (more overloading rules regarding exceptions later)
 * 
 * */


package israels.core_java.lesson03;

//import java.lang.reflect.Constructor;

public class Lesson3 {

	public static void main(String[] args) {
		
		// Parameters
		VariableCasting variable = new VariableCasting();
		variable.inClassWork();
		
		//Return Types
		ReturnTypes types = new ReturnTypes();
		types.inClassWork();
		
		// Overloading
		Overloading over = new Overloading();
		over.inClassWork();
		
		// Overloading Constructors
		Constructors con = new Constructors();
		con.inClassWork();
		
		// Override Instance Methods Polymorphism
		Polymorphism ploy = new Polymorphism();
		ploy.inClassWork();
		
	}

}
