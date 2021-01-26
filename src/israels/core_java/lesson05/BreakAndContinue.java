//   break - causes the program to stop execution of the innermost loop
// * labeled break - causes the program to stop execution of the labeled for loop
// * continue - causes the program to skip to the next iteration of the loop
// * labeled continue - causes the program to skip to the next iteration of the labeled loop

package israels.core_java.lesson05;

public class BreakAndContinue {

	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		
		breakingInfiniteLoops();
		unlabeledBreakAndContinue();
		labeledBreakAndContinue();
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void breakingInfiniteLoops() {
		System.out.println("=========> 1a. Break Infinite While Loop <=========");
		int count = 0; 
		
		while(true) {
			System.out.println(count++);
			if(count > 5) break;
			System.out.println("Run next iteration of while loop");
		}
		System.out.println("Outside while loop");
		
		System.out.println("=========> 1b. Break in Infinite For Loop <=========");
		for(;;) {
			System.out.println(count++);
			if(count > 8 ) break;
			System.out.println("Run next iteration of For loop");
		}
		System.out.println("outside For Loop");
		System.out.println();
	};
	
	private void unlabeledBreakAndContinue() {
		System.out.println("=========> 2a. Unlabeled break operates on innermost Loop <=========");
		
		for (int i = 0; i < 3; i++) {
			System.out.print("i=" + i + ":\t");
			for (int j = 0; j < 5; j++) {
				// Add a break statement here
				if (j == 2) {
					System.out.print("break hit");
					break; 
				}
				System.out.print("j="+j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
		
		System.out.println();
		
		System.out.println("=========> 2b. Unlabeled continue operates on innermost Loop <=========");
		for (int i = 0; i < 3; i++) {
			System.out.print("i=" + i + ":\t");
			for (int j = 0; j < 5; j++) {
				// Add a break statement here
				if (j == 2) {
					System.out.print("break hit");
					continue; 
				}
				System.out.print("j="+j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
	};
	
	private void labeledBreakAndContinue() {
		System.out.println("=========> 3a. Labeled break operates on innermost Loop <=========");
		
		breakTest:
		for (int i = 0; i < 3; i++) {
			System.out.print("i=" + i + ":\t");
			for (int j = 0; j < 5; j++) {
				// Add a break statement here
				if (j == 2) {
					System.out.print("break hit ");
					break breakTest; 
				}
				System.out.print("j="+ j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
		
		System.out.println();
		
		System.out.println("=========> 3b. Labeled continue operates on innermost Loop <=========");
		
		continueTest:
		for (int i = 0; i < 3; i++) {
			System.out.print("i=" + i + ":\t");
			for (int j = 0; j < 5; j++) {
				// Add a break statement here
				if (j == 2) {
					System.out.print("continue hit ");
					continue continueTest; 
				}
				System.out.print("j="+j + " ");
			}
			System.out.println("\t next outer loop");
		}
		System.out.println("Outside outer loop");
	};
	
}
