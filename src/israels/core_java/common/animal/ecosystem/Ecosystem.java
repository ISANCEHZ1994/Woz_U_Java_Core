package israels.core_java.common.animal.ecosystem;


import java.util.*;
import israels.core_java.common.animal.*;

public abstract class Ecosystem { // at least 5 animals that live in Yellowstone

	private EcosystemType ecosystemType = EcosystemType.UNKNOWN; // using the Enum EcosystemType
	public void setEcosystem(EcosystemType est) {
		ecosystemType = est;
	};
	public EcosystemType getEcosystem() { return ecosystemType;}
	
	
	List<Animal> nearbyAnimals = new ArrayList<>();
	
	
	
	
	public abstract void listPopulation();
	
}
