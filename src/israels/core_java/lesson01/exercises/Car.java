package israels.core_java.lesson01.exercises;

public class Car {
	public String make = "Ford";
	public String color = "Green";
	
	public void drive() {
		String s = color;
		s += " + make";
		s += " rattling down the road";
		System.out.println(s);
	}
	
}


