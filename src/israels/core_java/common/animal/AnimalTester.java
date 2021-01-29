package israels.core_java.common.animal;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import israels.core_java.common.animal.birds.Bird;
import israels.core_java.common.animal.fish.Fish;
import israels.core_java.common.animal.mammals.Mammal;
import israels.core_java.common.animal.reptiles.Reptile;
public class AnimalTester {
	
	public static AnimalTester at = new AnimalTester();
	
	private boolean debug = false;
	
	private String parentPkg = "israels.core_java.common.animal";
	
	static private Path parentDir = Paths.get("src", "israels","core_java", "common","animal");
	
	public static void main(String[] args) {
		
//		at.testRandomAnimalBuilder();
		
		at.testAnimalTypes(AnimalType.MAMMAL, 10);
		at.checkAnimalFile(Paths.get(parentDir.toString(), "mammals", "Lion.java"));
		at.testAnimalTypes(AnimalType.FISH, 6);
//		at.testSpecificAnimalClass();
		
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
	
	
	private void checkAnimalFile(Path targetFile) {
		String data = null;
		try (BufferedReader br = Files.newBufferedReader(targetFile)) {
		boolean eatMethodFound=false, sleepMethodFound=false, moveMethodFound=false;
			while((data = br.readLine()) != null) {
				if (data.contains("public void eat()")) eatMethodFound = true;
				if (data.contains("public void sleep()")) sleepMethodFound = true;
				if (data.contains("public void move()")) moveMethodFound = true;
			}			
			if (!eatMethodFound) {
				System.out.println("You need to override the eat method");
			}
			if (!sleepMethodFound) {
				System.out.println("You need to override the sleep method");
			}
			if (!moveMethodFound) {
				System.out.println("You need to override the move method");
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
	}
	
	private List<String> getClassList(String subDir){ 
		// this will give us a file representation of the package name
		Path dir = Paths.get(parentDir.toString(), subDir);
		List<String> classes = new CopyOnWriteArrayList<>();
		String pkg = parentPkg + "." + subDir; // has to be a DOT - NOT anything else!!
		if(debug) {
			System.out.println(dir);
			System.out.println(pkg);
		}
		File entry = dir.toFile(); // just a convertion function
		if(entry.isDirectory()) {
			String[] entryNames = entry.list();
			for(String fileName : entryNames) {
					String clsName = pkg + '.' + fileName.substring(0, fileName.indexOf("."));
					if(debug) System.out.println("Found: " + clsName);
					classes.add(clsName);
			}
		}
		// Loop through the list and attempt to instantiate the class
		for(String clsName : classes) {
			Animal a = null;
			try {
				a = (Animal)Class.forName(clsName).newInstance();
			}catch(ClassNotFoundException | IllegalAccessException e) {
				e.printStackTrace();
				System.exit(1);
			}catch(InstantiationException ie) {
				// Remove abstract classes or interfaces
				if(debug) System.out.println("Removing " + clsName + " from class list");
				classes.remove(clsName);
			}
		}
		
		return classes;
	}; // getClassList
	
	
	public void testGetClassList(String subDir) {
		debug = true; // this will show the file path in the console - turn on
		List<String> classes = getClassList(subDir);
		for( String s : classes ) {
			System.out.println(s);
		}
		debug = false; // turn off
	}; // closes testGetClassList

};