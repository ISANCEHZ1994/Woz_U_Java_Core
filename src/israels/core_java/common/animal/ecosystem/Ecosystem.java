package israels.core_java.common.animal.ecosystem;


import java.util.*;
import israels.core_java.common.animal.*;

public abstract class Ecosystem { // at least 5 animals that live in Yellowstone

	private EcosystemType ecosystemType = EcosystemType.UNKNOWN; // using the Enum EcosystemType
	public void setEcosystem(EcosystemType est) {
		ecosystemType = est;
	};
	public EcosystemType getEcosystem() { return ecosystemType;}
	
	
	protected List<Animal> nearbyAnimals = new ArrayList<>();
	public List<Animal> getNearbyAnimals() { return new ArrayList<Animal>(nearbyAnimals); }

	
	public String DESCRIPTION;
	public String getDescrip() { return DESCRIPTION; };
	
	public String WEATHER;
	public String getWeather() { return WEATHER; };
	
	public int ELEVATION;
	public int getElevation() { return ELEVATION; };
//	public int setElevation( int e ) { ELEVATION:e};
	
	
	
	public abstract void listPopulation();
	public abstract void findNearbyAnimals();
	
	
};
