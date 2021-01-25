package israels.core_java.lesson03;

import israels.core_java.common.animal.fish.Swordfish;

public class InitBlocks {  // Check out Animal and Swordfish for init blocks (just before constructors)

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		whenInitializationRuns();
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void whenInitializationRuns() {
		Swordfish sword = new Swordfish();
	};

}
