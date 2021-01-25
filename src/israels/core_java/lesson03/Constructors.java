package israels.core_java.lesson03;

import java.util.List;

import israels.core_java.common.animal.AnimalType;
import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.birds.Bird;
import israels.core_java.common.animal.fish.Fish;
import israels.core_java.common.animal.fish.Swordfish;
import israels.core_java.common.animal.mammals.Mammal;
import israels.core_java.common.animal.reptiles.Reptile;

public class Constructors {
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		testConstructorChaining();
		testOverloadedRandomAnimalBuilderConstructor();
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void testConstructorChaining() {
		
		System.out.println("1. Constructor Chaining <===");
		
		Swordfish fish = new Swordfish(10);
		System.out.println();
		
	}; // closes testConstructorChaining
	
	private void testOverloadedRandomAnimalBuilderConstructor() {
		System.out.println("2. Overloaded RandomAnimalBuilder <====");
		
		List<Fish> fish = (List<Fish>) new RandomAnimalBuilder(AnimalType.FISH).build(3);
		System.out.println(fish);
		System.out.println();
		
		List<Bird> bird = (List<Bird>) new RandomAnimalBuilder(AnimalType.BIRD).build(3);
		System.out.println(bird);
		System.out.println();
		
		List<Mammal> mammal = (List<Mammal>) new RandomAnimalBuilder(AnimalType.MAMMAL).build(3);
		System.out.println(mammal);
		System.out.println();
		
		List<Reptile> reptile = (List<Reptile>) new RandomAnimalBuilder(AnimalType.REPTILE).build(3);
		System.out.println(reptile);
		System.out.println();
	}; // closes testOverloadedRandomAnimalBuilderConstructor
	
	
}
