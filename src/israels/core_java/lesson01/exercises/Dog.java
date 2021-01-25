package israels.core_java.lesson01.exercises;

public class Dog extends Animal{ // Animal is the PARENT CLASS 
	// The dog will now INHERIT all properties of Animal
	
	public String name;
	public int weight;
	
	public Dog() {
		type = "dog";
	}
	
	public void bark() {
		String bark = name + " says "; // name is what we put in ClassesAndObjects
		
		if (weight > 60) {
			bark += "Bark! Bark!";
		}else if (weight > 14) {
			bark = bark + "Woof! Woof!"; // same as above - just explained (+=)
		}else {
			bark += "Yip! Yip!";
		}
		System.out.println(bark); // syso CTRL && SPACE => System.out.println();
		
	}
}
