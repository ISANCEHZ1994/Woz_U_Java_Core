package israels.core_java.lesson02;

import israels.core_java.common.animal.mammals.Elephant;
import israels.core_java.common.animal.mammals.Lion;

public class Encapsulation { // information hiding

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		 Elephant ellie = new Elephant();
		 ellie.setAge(-1); // testing to see if it returns wrong
		 System.out.println(ellie + " age set to -1");
		 
		 ellie.setAge(71);
		 System.out.println(ellie + " age set to 71");
		 
		 
		 ellie.grow();
		 System.out.println(ellie + " after one .grow()");
		 
		 Lion simba = new Lion();
		 simba.setAge(-1);
		 System.out.println(simba + " age set to -1");
		 
		 simba.setAge(0);
		 System.out.println(simba + " age set to 0");
		 
		 simba.grow();
		 simba.grow();
		 simba.grow();
		 simba.grow();
		 simba.grow();
		 simba.grow();
		 System.out.println(simba + " <= after multiple .grow()");
		 
		 System.out.println("=========================================================================\n\n");
	};

}
