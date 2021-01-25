
/*
 * 	Top level Classes can only have public or default level of access
 * 	you CANNOT define with private nor protected - ONLY default or public
 * 
 * 
 * 	The only non-access modifiers you can use on top level classes are:
 * 	final - class CANNOT be extended (like String)
 * 	abstract - class MUST be extended in order for use
 * 
 * 	strictfp - follows IEEE754 for floating point - NOT GOING TO USE IN CLASS
 * 
 * 
 */	

package israels.core_java.lesson02;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.fish.*;
import israels.core_java.common.animal.mammals.*; 
// instead of importing everything separately
// this gets everything inside of mammals package

//import israels.core_java.common.animal.mammals.Elephant;
//import israels.core_java.common.animal.mammals.Gorilla;
//import israels.core_java.common.animal.mammals.Monkey;

public class Classes {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		//allClassesExtendObject(); // if this is commented out ALL work will NOT show in console
		creatingAnimals();
		
		System.out.println();
	};

	private void allClassesExtendObject() {
		System.out.println("1. All Classes Extend Object and Inherit Object Methods <----------------");
		Object obj = new Animal(); // 1 animal 
		Object obj2 = obj; 
		Object obj3 = new Animal(); // 2 animals
		
		Animal randomFurry = new Animal(); // 3 animals
		randomFurry.setAge(34);
		randomFurry.setWeight(12);
		obj3 = randomFurry;
		
		Animal animal = new Animal(); // 4 animals => Animal Count will equal: 4
		animal.setAge(25);
		animal.setWeight(130);
		obj2 = animal; // when printed out => Unknown Animal of age 25
		
		// Object Methods
		System.out.println("obj.toString() => " + obj.toString()); // returns =>  israels.core_java.common.animal.Animal@39ed3c8d
		System.out.println("obj.getClass() => " + obj.getClass()); // returns => class israels.core_java.common.animal.Animal
		System.out.println("obj.hashCode() => " + obj.hashCode()); // returns => 971848845
		
		System.out.println("obj2.toString() => " + obj2.toString());
		System.out.println("obj3.toString() => " + obj3.toString());
		
		System.out.println("obj.equals(obj2) => " + obj.equals(obj2));
		System.out.println("obj.equals(obj3) => " + obj.equals(obj3));
		
	};
	
	private void creatingAnimals() {
		System.out.println("2. Creating More Animal Classes <----------------");
		System.out.println("Animal Count = " + Animal.getCount());
		
		Animal unknown = new Animal();
		System.out.println("Animal Count = " + unknown.getCount()); // => The static method getCount() from the type Animal should be accessed in a static way  
		// You can still get it though! Use it!
		
		Elephant dumbo = new Elephant();
		System.out.println("Animal Count = " + Elephant.getCount());
		
		Monkey chip = new Monkey();
		System.out.println("Animal Count = " + Monkey.getCount());
		
		Gorilla joe = new Gorilla();
		System.out.println("Animal Count = " + Gorilla.getCount());
		
		Tuna flips = new Tuna();
		System.out.println("Animal Count = " + Tuna.getCount());
		
		Horse misterEd = new Horse();
		System.out.println("Animal Count = " + Horse.getCount());
		
		Animal[] zoo = new Animal[6];
		zoo[0] = dumbo;
		zoo[1] = chip;
		zoo[2] = joe;
		zoo[3] = flips;
		zoo[4] = new Lion();
		zoo[5] = misterEd;
		 
		for(int i = 0; i < zoo.length; i++) { 
		//System.out.println uses the 'toString' method for objects
			System.out.println(zoo[i]);
			zoo[i].eat();
			zoo[i].move();
			zoo[i].sleep();
		};
		
	};
	
	
	
}
