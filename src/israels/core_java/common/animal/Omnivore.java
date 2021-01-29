package israels.core_java.common.animal;

public interface Omnivore {

	public abstract boolean isOmnivorous();
	
	public abstract void hunt();
	public abstract String findPrey();
	public abstract boolean catchPrey(Animal target);
	
	public abstract void gather();
	public abstract String findPlants();
	public abstract boolean foundPlants();
}
