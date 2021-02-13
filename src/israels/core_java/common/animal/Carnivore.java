package israels.core_java.common.animal;

import java.util.List;

public interface Carnivore {
	
	
	public abstract void hunt();
	
	public abstract void hunt(List<? extends Animal> targets);
	
	public abstract String findPrey();
	public abstract boolean catchPrey(Animal target);
	
}
