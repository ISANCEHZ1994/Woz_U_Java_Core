package israels.core_java.lesson04;

public class LogicOperators {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		testAnd();
		testOr();
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void testAnd() {
		boolean result;
		System.out.println("1. AND Results:  ");
		
		result = (5 > 3) && (9 > 6);
		System.out.println(result); // TRUE
		
		result = (5 > 3) && (9 < 6);
		System.out.println(result); // FALSE
		
		result = (5 < 3) && (9 > 6);
		System.out.println(result); // FALSE
		
		result = (5 < 3) && (9 < 6);
		System.out.println(result); // FALSE
	}
	
	private void testOr() {
		boolean result;
		System.out.println("2. OR Results  ");
		
		result = (5 > 3) || (9 > 6);
		System.out.println(result); // TRUE
		
		result = (5 > 3) || (9 < 6);
		System.out.println(result); // TRUE
		
		result = (5 < 3) || (9 > 6);
		System.out.println(result); // TRUE
		
		result = (5 < 3) || (9 < 6);
		System.out.println(result); // FALSE
	}
	
}
