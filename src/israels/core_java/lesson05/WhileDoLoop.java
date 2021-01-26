package israels.core_java.lesson05;

import israels.core_java.common.animal.mammals.Lion;

public class WhileDoLoop {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		whileAndDoLoopBasics();
		testWhileWithLion();
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void whileAndDoLoopBasics() {
		System.out.println("1a. While Loop");
		
		int count = 3;
		while(count < 6) {
			System.out.println(count + " ");
			count++;
		}
		System.out.println();
		
		System.out.println("1b. Do Loop");
		
		count = 3;
		do {
			System.out.println(count + " ");
			count++;
		}while(count < 6);
		System.out.println();
		
		//Infinite loops:
		// while(true){}
		
		// do {} while(true);
		
	};
	
	private void testWhileWithLion() {
		System.out.println("==============> Growning lion: <==============");
		Lion savage = new Lion();
		
		
		while ( savage.getAge() < savage.getMaxAge()) {
			savage.eat();
			savage.grow();
			System.out.println();
		}
		
	};
	
	
}
