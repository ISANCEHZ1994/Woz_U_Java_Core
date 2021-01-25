package israels.core_java.common.animal.birds;
import israels.core_java.common.animal.Animal;



public abstract class Bird extends Animal {
		
	protected BirdFood food;
	public String getFood() {
		return food.toString().toLowerCase(); // enum would return CAPital case
	};
	
	
	public Bird() {
		setType("UNKNOWN BIRD");
		
		
	};
}
