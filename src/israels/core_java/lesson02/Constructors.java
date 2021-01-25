/*
 *  A constructor is a special method that is used to instantiate an object 
 *  1. Must have EXACTLY the same name in its class 
 *  2. Must NOT have a return type
 *  3. CANNOT be final, abstract, or static
 *  4. Can have any access modifier including private
 *  5. The first statement in a constructor must be a call to this() or super() - if you do 
 *  not write this statement, the compiler will insert a call to super
 *  
 *  Every Class MUST have a Constructor, if one is not written, one will be created via the Compiler
 *  ALSO known as DEFAULT Constructor
 *  
 *  Default Constructor looks like this:
 *  
 *  public ClassName(){
 *  	super();
 *  };
 *  
 * DEFAULT constructors follow all the above rules plus
 *  6. Has the save access level as the class
 *  7. Has no arguments
 *  8. Has the call to super()
 *  
 *   Constructor has same name as class, same level of access
 */

package israels.core_java.lesson02;

import java.util.List;
import israels.core_java.common.animal.*;
import israels.core_java.common.animal.fish.Swordfish;
import israels.core_java.common.animal.mammals.*;


public class Constructors {
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		testOverloadedConstructors();
		testRandomAnimalBuilder();
	}; // closes inClassWork()
	
	private void testOverloadedConstructors() {
		System.out.println("1. Test Constructor Overloading <------------------------------------");
		Animal[] zoo = new Animal[4];
		zoo[0] = new Lion(6, 0, null); // added variables to match the constructor in Lion.java!!
		zoo[1] = new Elephant(10);
		zoo[2] = new Swordfish(); // USING the NO ARGUMENT Constructor in Swordfish.java
		zoo[3] = new Swordfish(20); // USING ARGUMENT Constructor in Swordfish.java
		
		for(Animal a: zoo) {
			System.out.println(" Here is an animal from zoo array <--------");
			a.eat();
			a.move();
			a.sleep();
			System.out.println(a);
		};
	}; // closes testOverLoadConstructors()
	
	private void testRandomAnimalBuilder() {
		System.out.println("2. Test RandomAnimalBuilder <-------------------------------------------");
		List <Animal> animals = (List <Animal>) new RandomAnimalBuilder().build(6);
		for(Animal a: animals) {
			System.out.println( a + " <= Here is an ANIMAL FROM THE LIST ANIMAL ARRAY <-----------------------");
			a.eat();
			a.move();
			a.sleep();
			System.out.println();
		};
	};
	
};
