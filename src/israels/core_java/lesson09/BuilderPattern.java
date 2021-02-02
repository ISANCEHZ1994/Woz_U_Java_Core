package israels.core_java.lesson09;



import java.util.List;

import israels.core_java.common.animal.AnimalType;
import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.ecosystem.EcosystemType;
import israels.core_java.common.animal.Animal;

public class BuilderPattern {

	
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		
		List<Animal> animals = (List<Animal>)new RandomAnimalBuilder(AnimalType.MAMMAL).build(10);
		System.out.println("Displaying List of Animals without filtering");
		displayResults(animals);
		
		System.out.println("-------------------------------------\n");
		
		List<Animal> animals2 = (List<Animal>)new RandomAnimalBuilder(AnimalType.MAMMAL)
																	.setDebug(true)
																	.setEcosystem(EcosystemType.SAVANNAH)
																	.build(10);
		System.out.println("Displaying List of Animals WITH filtering");
		displayResults(animals2);
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void displayResults(List<Animal> animalList) {
		for(Animal a : animalList) {
			System.out.println(a);
		}
	}
	
	
}
