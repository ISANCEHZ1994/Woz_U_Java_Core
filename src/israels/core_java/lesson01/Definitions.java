package israels.core_java.lesson01;

/*
 * This is a class declaration. Everything after the curly brace is the definition of the 
 * class and includes code that models state and behavior. Behavior is modeled in Java by
 * methods. State is modeled by variables.
 * The name of this class is the same as the name of the file.
 * 
 * public means everyone can access it
 * class means you are declaring a class definition
 */
public class Definitions 
{  /* This is an opening curly brace { and indicates the start of a code block that defines the class
    * We say that a code block is delineated by curly braces
    * This is a method. It models behavior in a class definition and consists of a series of
    * statements. Each statement ends in a semicolon ;
	* The main method is a very special method that the JVM looks for in order to start running
	* your code. It must look just like this.
	*/
	public void inClassWork()
	
	{ // This curly brace indicates the beginning of the block of code that defines the method.
		System.out.println(this.getClass().getSimpleName() + " .inClassWork()");
	    // methods are made up of statements. We will learn different types of statements
	    // in another exercise. Statements end in a semicolon ;
	    
	    // These are variables. There are two types: primitives and reference.
		int x;     // This is a primitive variable and uses keywords (in purple)
		boolean b;   // Another primitive that can be either true or false
		String s1;   // This is a reference variable and is defined by a class String

        s1 = "Java Rocks!"; // "Java Rocks" is a String literal
		
        // Statement to print something out in the console window. i
        System.out.println(s1);
	} // This is a closing curly brace and indicates the end of a block of code
	  // This one is for the end of the main method. How do you know this?

} // This curly brace indicates the end of the block of code that defines the class. 
