package israels.core_java.lesson01;
//import israels.core_java.Definitions; <--- it already knows because they are in the same place

public class Lesson1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Definitions def = new Definitions();
		def.inClassWork();
		
		Statements learnStatements = new Statements();
		learnStatements.inClassWork();
		
		ClassesAndObjects makeBark = new ClassesAndObjects(); // NOTE: this goes into ClassesAndObjects.java file 
		//then to Dog.java
		makeBark.inClassWork();
		
		Inheritance bothCatandDog = new Inheritance();
		bothCatandDog.inClassWork();
		
		Indentifier learnIndentifiers = new Indentifier();
		learnIndentifiers.inClassWork();
		
		// Lesson 1 Strings
		WorkingWithStrings concatenate = new WorkingWithStrings();
		concatenate.inClassWork();
		
		// Lesson 1 Primitives
		Primitives learningThings = new Primitives();
		learningThings.inClassWork();
		
		// Lesson 1 Reference Variables
		References carStuff = new References();
		carStuff.inClassWork();
		Arrays learnArrays = new Arrays();
		learnArrays.inClassWork();
		Initialization init = new Initialization();
		init.inClassWork();
		
		
		// Modifiers
		System.out.println(Modifiers.classVar);
		Modifiers mods = new Modifiers();
		mods.inClassWork();
		
	};

};
