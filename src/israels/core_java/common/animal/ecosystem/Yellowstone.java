/**
 * Project Requirements (Requirements Specification)
 * 1. Select an ecosystem to simulate. - CHECK
 * 		1a. The Ecosystem must be unique with regard to other classmates - CHECK
 * 		1b. The Ecosystem must be diverse enough to be able to create simulations - CHECK
 * 		1c. Take notes about the ecosystem and how it works. Include weather considerations 
 * 			food availability, seasonality, etc.
 * 2. Identify at least 5 animals to simulate in your ecosystem
 * 		2a. The animals must be chosen with regard to their interactions with each other
 * 		2b. The animals must all be active at the same time (night vs day vs twilight)
 * 		2c. Take notes about how the animals behave with regard to their species, 
 * 			predators or prey and competition with other species for scarce resources
 * 3. Tdentify at least two simulations to create
 *		3a. Each simulation must involve at least two species
 * 
 * Design Specification
 * 1.	Ecosystem
 * 		1a. EcosystemType must be unique in class.
 * 		1b. Your ecosystem may be given any name but must specify the unique EcosystemType
 * 		1c. Your ecosystem class must derive from this abstract class Ecosystem. 
 * 			The tech lead has sole responsibility for this class
 * 		1d.	Do not include a main() method. Your ecosystem must be called from outside the class
 * 2.	Animal
 * 		2a. The animal classes must derive from the Animal class in our hierarchy
 * 		2b. EcosystemType must be specified in each class
 * 		2c. Age related behaviors must be created for eating, moving and sleeping
 * 
 * @author Israel S. Sanchez
 * 
 * Animals:
 * carnivores={ 
 * (Gray) Wolf, 
 * (Grizzly) Bear, 
 * Cougar
 * },
 * herbivore={
 * Moose,
 * Bison, 
 * Elk
 * Notes on Animals - simulate REAL life events
 * },
 */

package israels.core_java.common.animal.ecosystem;
import java.util.List;
import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.mammals.*;

public class Yellowstone extends Ecosystem {
	
	
	{
		DESCRIPTION = "Yellowstone National Park is a nearly 3,500-sq.-mile wilderness recreation area atop a volcanic hot spot. "
				+ "Mostly in Wyoming, the park spreads into parts of Montana and Idaho too. "
				+ "Yellowstone features dramatic canyons, alpine rivers, "
				+ "lush forests, hot springs and gushing geysers, including its most famous, Old Faithful. "
				+ "It's also home to hundreds of animal species, including bears, wolves, bison, elk and antelope.";
		WEATHER = "Since most of the park lies at an elevation of 6,000 feet (1829 m) above sea level or higher, "
				+ "unpredictability characterizes Yellowstone's weather. "
				+ "Expect big temperature swings, rain, or snow during every month of the year. "
				+ "No matter when you visit, bring a warm jacket, rain gear, and lots of layers.";
		
	}
	
	public Yellowstone() {
		setEcosystem(EcosystemType.YELLOWSTONE);
		ELEVATION = 6_000;
	}

	@Override
	public void listPopulation() {
		List<Wolf> wolfPack = (List<Wolf>) new RandomAnimalBuilder(Wolf.class).build(6);
		List<Bear> bearSleuth = (List<Bear>) new RandomAnimalBuilder(Bear.class).build(3);
		List<Cougar> cougar = (List<Cougar>) new RandomAnimalBuilder(Cougar.class).build(3);
		List<Bison> bisonHerd = (List<Bison>) new RandomAnimalBuilder(Bison.class).build(20); // 1200
		List<Elk> elkGang = (List<Elk>) new RandomAnimalBuilder(Elk.class).build(20); //200
		List<Moose> mooseHerd = (List<Moose>) new RandomAnimalBuilder(Moose.class).build(3);
		
		System.out.println(wolfPack);
		
		System.out.println();
		System.out.println(bearSleuth);
		System.out.println();
		System.out.println(cougar);
		System.out.println();
		System.out.println(bisonHerd);
		System.out.println();
		System.out.println(elkGang);
		System.out.println();
		System.out.println(mooseHerd);
		System.out.println();
		
		System.out.println("=================================================================================================");
	};

	@Override
	public void findNearbyAnimal() {
			
	};
	
	public String escapeChance() {
		return null;
	};
	
	public void test() {
		
		Wolf singleWolf = new Wolf();
		singleWolf.setAge(5);
		singleWolf.setWeight(120);
		singleWolf.hunt();
		System.out.println(singleWolf);
	}
	
	
};
