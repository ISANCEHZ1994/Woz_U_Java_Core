package israels.core_java.lesson01;

import israels.core_java.lesson01.exercises.Dog;

public class Arrays {
	
	
	public void inClassWork(){
		System.out.println(this.getClass().getSimpleName() + ".inClassWork()");
		
		primitiveArrays();
		referenceVariableArrays();
		
	}; 
	
	private void primitiveArrays() {
		// First step is to declare the array
				int [] myArray;
				// Second step is to create (CONSTRUCT/DEFINE)
				myArray = new int[8];
				myArray[0] = 1;
				myArray[1] = 2;
				myArray[2] = 3;
				myArray[3] = 4;
				myArray[4] = 5;
				myArray[5] = 6;
				myArray[6] = 7;
				myArray[7] = 8;
//				System.out.println(myArray); will return => [I@5ccd43c2 but thats for later!
				
				// Arrays are type safe 
//				myArray[3] = true;     these would not work because we said it would be an int
//				myArray[3] = 3.14;
				
				// Declaration and definition on the same line
				double [] dollars = new double[12];
				
				// Declaration, definition and initialization in one statement
				int [] manyNums = { 1,2,3,4,5,6,7,8,9};
				
				
				// Arrays are IMMUTABLE - there is NOTHING you can do to change (grow or shrink) the array
				
				// Other legal array declarations that are NOT recommended
				int num []; // <= Legal NOT A GOOD IDEA
				
	}; 
	
	private void referenceVariableArrays() {
		Dog [] kennel;
		kennel = new Dog[3];
		kennel[0] = new Dog();
		kennel[1] = new Dog();
		kennel[2] = new Dog();
		
		// Arrays are type safe - this causes a complier error
		 //kennel[0]= new Cat();
		
		// Using the array
		kennel[0].name = "Lassie";
		kennel[1].name = "Snoopy";
		kennel[2].name = "Cerbrus";
		kennel[0].weight = 18;
		kennel[1].weight = 2;
		kennel[2].weight = 125;
		
		// Process the array we can use for-each loop
		for(Dog d : kennel ) {
			d.bark();
		}
	} 
	
};
