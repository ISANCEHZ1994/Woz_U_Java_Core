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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Carnivore;
import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.mammals.*;
import israels.core_java.lesson09.dao.AnimalDAO;
import israels.core_java.lesson09.dao.AnimalDaoFactory;
import israels.core_java.lesson09.dao.DaoFactory;
import israels.core_java.lesson09.dao.DataStoreNotFoundException;

public class Yellowstone extends Ecosystem {
	
	List<Wolf> wolfPack = (List<Wolf>) new RandomAnimalBuilder(Wolf.class).build(6);
	List<Bear> bearSleuth = (List<Bear>) new RandomAnimalBuilder(Bear.class).build(3);
	List<Cougar> cougar = (List<Cougar>) new RandomAnimalBuilder(Cougar.class).build(3);
	List<Bison> bisonHerd = (List<Bison>) new RandomAnimalBuilder(Bison.class).build(20); // 1200
	List<Elk> elkGang = (List<Elk>) new RandomAnimalBuilder(Elk.class).build(20); //200
	List<Moose> mooseHerd = (List<Moose>) new RandomAnimalBuilder(Moose.class).build(3);
	
	
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
		ELEVATION = 6_000;
	}
	
	public Yellowstone() {
		setEcosystem(EcosystemType.YELLOWSTONE);
		System.out.println("Yellowstone Park Created!");
		System.out.println("=========================");
		
//		useFileDao();
		findNearbyAnimals();
//		dawnBreak();
		
	}

	@Override
	public void listPopulation() {
		System.out.println("Total Population of Yellowstone: ");
		System.out.println();
		System.out.println(wolfPack);
		System.out.println(bearSleuth);
		System.out.println(cougar);
		System.out.println(bisonHerd);
		System.out.println(elkGang);
		System.out.println(mooseHerd);
		System.out.println("========================================================================================================================");
	};

	
	@Override
	public void findNearbyAnimals() { // ArrayList<Animal>
		int[] alreadyAdded = new int[4];
		
			for(int i = 0; i < 4; i++) { // we only want at least 4 animals nearby not ALL the animals - NO predators!
				
				int probability = ThreadLocalRandom.current().nextInt(1,6);
				if(Arrays.binarySearch(alreadyAdded, 0, 2, probability) >= 0 ) {
					i--;
					continue;
				}
				switch(probability) {
				case 1:
					nearbyAnimals.addAll(elkGang);
					break; // BREAK or else we FALL
				case 2:
					nearbyAnimals.addAll(bisonHerd);
					break;
				default:
					nearbyAnimals.addAll(mooseHerd);
					break;
				}
				alreadyAdded[i] = probability;
			}
			
	};

	
	public void dawnBreak() {
		System.out.println("It's now dawn at Yellowstone Park...");
		
		for( Elk e : elkGang) {
			if(e.getAge() < 18) { // NOTE: For some reason this sets the LIMIT for age
				// since it will never reach that 18 FOR SOME REASON - we don't see the below text
				System.out.println(e + ": ");
				e.sleep();
			}else if( e.getSex() == Sex.MALE && e.getWeight() > 650) {
				System.out.println(e + " standing watch over the gang");
			}
		}
		
		System.out.println("Mother and baby bear");
		for(Bear b : bearSleuth) {
			b.sleep();
		}
		
		System.out.println("\nDawn is BROKEN");
		for(Moose m : mooseHerd) {
			m.move();
		}
	};
	
	
	public String escapeChance() {
		return null;
	};
	
//	public void test() {
//		
//		Wolf singleWolf = new Wolf();
//		singleWolf.setAge(5);
//		singleWolf.setWeight(120);
//		singleWolf.hunt();
//		System.out.println(singleWolf);
//	}
	
	private class HuntingThread implements Runnable{ // creating another class WITHIN a class
		
		Carnivore hunter = null;
		List<? extends Animal> hunted = null;
		
		HuntingThread(Carnivore c, List<? extends Animal> targets){
			hunter = c;
			hunted = targets;
			
		};
		
		@Override 
		public void run() {
			hunter.hunt(hunted); // 
		};
		
		
	};
	
	public void theWolfsAreHungry() { // multithreaded
		Wolf cub = wolfPack.get(0);
		Wolf mother = wolfPack.get(1);
		
		mother.move();
		cub.move();
		
		Thread t = new Thread(new HuntingThread(mother, elkGang));
		t.start();
		System.out.println();
		
		for(Elk e : elkGang ) {
			e.setRunning(true);
			e.move();
		}
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		String food = mother.getPreyCaugth();
		if(food != null) {
			cub.eat(food);
		}
		
	};
	
	private void useFileDao() {
		DaoFactory factory = new AnimalDaoFactory();
		AnimalDAO dao = null;
		try {
			dao = factory.getDao("file");
		} catch (DataStoreNotFoundException e) {
			// works when we dont have this lol
			
			System.out.println(e);
			return;
			
		}
		dao.setDebug(false);
		
//			// Create a list of animals to use with the dao:
//				List<Animal> lionPride = (List<Animal>) new RandomAnimalBuilder(Lion.class).build(7);	
//				dao.setDebug(true);
//				
//				for(Animal lion : lionPride) {
//					dao.create(lion);
//				}
				
				System.out.println("--------------------------------------------------\n");
				//Retrieve the lions from the dao:
				for(Animal lion : dao.findAll()) {
					System.out.println(lion);
				}
				
//				//Delete all the files
//				for(Animal lion : dao.findAll()) {
//					dao.delete(lion);
//				}
		}
	
};
