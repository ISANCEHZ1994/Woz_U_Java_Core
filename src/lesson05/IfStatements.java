package lesson05;

public class IfStatements {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		ifElseBasics();
		multipleBranches();
		
		System.out.println("=========================================================================\n\n");
	};
	
	public void ifElseBasics() {
		// Syntax: begins with if(boolean expression)
		boolean booleanExpression = true;
		
		if(booleanExpression) { //Curly braces are optional0
			System.out.println("Inside IF block <=======");
		}else {
			System.out.println("Inside ELSE block <=======");
		}
		if(true) {
			System.out.println("This always executes");
		}
		if(false) {
			System.out.println("This never executes");
		}
	};
	
	public String multipleBranches() {
		int score = 75;
		String grade;
		if(score >= 90) {
			grade = "A";
		}else if(score >= 80){
			grade = "B";
		}else if(score >= 70) {
			grade = "C";
		}else if(score >= 60) {
			grade = "D";
		}else {
			grade = "F";
		}
		System.out.println(grade); // returns => C
		return grade;
	};
	
	
}
