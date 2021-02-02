package israels.core_java.common.animal.birds;
import java.util.*; 
import israels.core_java.common.animal.*;
import israels.core_java.common.animal.mammals.Mammal;

public abstract class Raptor extends Bird implements Carnivore{
	
	protected List<String> prey = new ArrayList<>();
	
	protected String preyFound = null;
	protected String preyCaught = null;
	

	public Raptor() {
		setType("UNKNOWN RAPTOR");
		food = BirdFood.MEAT;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(this == other) { return true;}
		boolean result = false;
		if(other instanceof Raptor) {
			result = super.equals(other)
					&& prey.equals(((Raptor)other).prey);
		}
		return result;
	}
	
	@Override
	public void hunt() {
		
	}
	
	@Override
	public String findPrey() {
		if(preyFound == null) {
			int x = (int)(Math.random() * prey.size()); // we use .size() because it is a COLLECTION of ArrayLists
			// ArrayLists you can CHANGE but Arrays are STATIC - you CANNOT
			preyFound = prey.get(x);
		}
		return null;
	}
	
	public boolean canSwim() { return false; };

}
