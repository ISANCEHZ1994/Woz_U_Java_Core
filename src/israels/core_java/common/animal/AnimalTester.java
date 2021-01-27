package israels.core_java.common.animal;
import java.util.List;
import israels.core_java.common.animal.birds.Bird;
import israels.core_java.common.animal.fish.Fish;
import israels.core_java.common.animal.mammals.Mammal;
import israels.core_java.common.animal.reptiles.Reptile;
public class AnimalTester {
	public static AnimalTester at = new AnimalTester();
	public static void main(String[] args) {
		
//		at.testRandomAnimalBuilder();
		at.testAnimalTypes(AnimalType.MAMMAL, 10);
	}
	private void testRandomAnimalBuilder() {
		System.out.println("1. Test RandomAnimalBuilder:");
		List<Animal> animals = (List<Animal>)new RandomAnimalBuilder().build(6);
		for (Animal a : animals) {
			System.out.println(a);
//			a.eat();
//			a.move();
//			a.sleep();
			System.out.println();
		}
		System.out.println();
	}
	private void testAnimalTypes(AnimalType typeToTest, int numToTest) {
		System.out.println("2. Overloaded RandomAnimalBuilder");
		List<? extends Animal> displayResults;
		switch (typeToTest) {
		case FISH:
			List<Fish> fishes = (List<Fish>) new RandomAnimalBuilder(AnimalType.FISH).build(numToTest);
			displayResults = fishes;
			break;
		case BIRD:
			List<Bird> birds = (List<Bird>) new RandomAnimalBuilder(AnimalType.BIRD).build(numToTest);
			displayResults = birds;
			break;
		case MAMMAL:
			List<Mammal> mammals = (List<Mammal>) new RandomAnimalBuilder(AnimalType.MAMMAL).build(numToTest);
			displayResults = mammals;
			break;
		case REPTILE:
			List<Reptile> lizards = (List<Reptile>) new RandomAnimalBuilder(AnimalType.REPTILE).build(numToTest);
			displayResults = lizards;
			break;
		case DOMESTIC:
			List<Animal> domestics = (List<Animal>) new RandomAnimalBuilder(AnimalType.DOMESTIC).build(numToTest);
			displayResults = domestics;
			break;
		case ZOO:
		default:
			List<Animal> animals = (List<Animal>)new RandomAnimalBuilder(AnimalType.ZOO).build(6);
			displayResults = animals;
			break;
		}
		for(Animal a : displayResults) {
			System.out.println(a);
		}
		System.out.println();
	};

};