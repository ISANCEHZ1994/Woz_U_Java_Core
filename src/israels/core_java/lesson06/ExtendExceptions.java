package israels.core_java.lesson06;

import israels.core_java.common.animal.AgeException;
import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.mammals.Elephant;
import israels.core_java.common.animal.mammals.Lion;

public class ExtendExceptions {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		Elephant elle = new Elephant();
		elle.sleep();
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void testAgeException() {
		try {
			Animal a = new Animal(200, Sex.FEMALE);
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}
		try {
			Lion leo = new Lion(-1,300, Sex.FEMALE); // NOTE: even with negative 1 
			// still runs with no error - may be missing code?
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}
	};
	
}
