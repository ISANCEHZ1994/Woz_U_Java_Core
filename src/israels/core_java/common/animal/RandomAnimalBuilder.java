package israels.core_java.common.animal;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

import israels.core_java.common.animal.birds.*;
import israels.core_java.common.animal.domestic.Cat;
import israels.core_java.common.animal.domestic.Dog;
import israels.core_java.common.animal.domestic.Horse;
import israels.core_java.common.animal.fish.*;
import israels.core_java.common.animal.mammals.*;
import israels.core_java.common.animal.reptiles.*;

public class RandomAnimalBuilder {
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	private AnimalType type = null;
	private Class species = null;
	
	// Variables for file handling
	private Path parentDir = Paths.get("src", "israels","core_java", "common","animal");
	private String parentPkg = "israels.core_java.common.animal";
	private boolean debug = false;
	
// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	
	public RandomAnimalBuilder() {
		// TODO Auto-generated constructor stub
		
	};
	
	public RandomAnimalBuilder(Class cls) {
		species = cls;
	}
	
	// We are using this Constructor to build Random Animals of a specifc type
	public RandomAnimalBuilder(AnimalType t) {
		type = t;
	}
	
// --------------------------> METHOD SECTION <----------------------------------------------------------
	
	public List<? extends Animal> build(int count){
		List <Animal> result = new ArrayList<>(); // <> Diamond syntax
		
			for(int i = 1; i <= count; i++) {
			Animal a;
			
			if(type != null) {
				a = buildType(type);
			}else if(species != null){
				a = buildClass();	
			}else {
				a = buildRandom();
			}
			
			// Set the new animal to a random age based on it's age range
			int age = ThreadLocalRandom.current().nextInt(0, a.getMaxAge());
			a.setAge(age);
			// Set the new animal's sex, default is FEMALE, must set half to MALE
			if(ThreadLocalRandom.current().nextBoolean()) a.setSex(Sex.MALE);
			// Set weight based on Animals age and sex => BOOM now we can have both males and females 
			a.setRandomWeightByAge();
			
			result.add(a);
		}
			return result;
		}; 
		
		private Animal buildRandom() {
			Animal a = null;
			switch (ThreadLocalRandom.current().nextInt(6)){
			case 0:
				a = buildBird(); break; // Note: we havent written buildBird() yet! - NOTE Check below NOW we have!!
			case 1:
				a = buildReptile(); break;
			case 2: 
				a = buildFish(); break;
			case 3:
				a = buildDomestic(); break;
			default: 
				a = buildMammal();
			}
			return a;
		};
		
		private Animal buildType(AnimalType t) {
			Animal a = null;
			switch (t){
			default:
			case ZOO:
				a = buildZoo(); break;
			case MAMMAL:
				a = buildMammal(); break;
			case BIRD:
				a = buildBird(); break;
			case FISH:
				a = buildFish(); break;
			case REPTILE:
				a = buildReptile(); break;
			case DOMESTIC:
				a = buildDomestic(); break;
			}
			return a;
		};
		
		private Animal buildClass() {
			Animal newAnimal = null;
			String className = species.getCanonicalName();
			try {
				newAnimal = (Animal)Class.forName(className).newInstance();
			} catch (Exception e) {
			  e.printStackTrace();
			} 
			return newAnimal;
		};
		
		private Animal buildZoo() {
			Animal animal = new Animal();
			switch (ThreadLocalRandom.current().nextInt(6)){
			case 0:
				animal = buildBird(); break;
			case 1:
				animal = buildReptile(); break;
			default:
				animal = buildMammal(); break;
			}
			return animal;
		}
			
		
		private Mammal buildMammal() {
			Mammal newMammal = null;
			
			switch (ThreadLocalRandom.current().nextInt(5)){
				case 0:
					newMammal = new Elephant(); break;
				case 1:
					newMammal = new Monkey(); break;
				case 2:
					newMammal = new Lion(); break;
				case 3:
					newMammal = new Gorilla(); break;
				case 4:
					newMammal = new Gazelle(); break;
				case 5:
					newMammal = new Rhinoceros(); break;
				default: 
					newMammal = new Horse();	
			}
			return newMammal;
		};
		
		private Fish buildFish() {
			Fish newFish = null;
			
			switch (ThreadLocalRandom.current().nextInt(3)) {
				case 0:
					newFish = new Swordfish(); break;
				default:
					newFish = new Tuna(); 
				}
			return newFish;
			
		};
		
		private Reptile buildReptile() {
			Reptile newReptile = null;
			
			switch (ThreadLocalRandom.current().nextInt(3)) { // NOTE: the number doesn't matter LESS you add more!!
				case 0:
					newReptile = new Snake(); break;
				default:
					newReptile = new Crocodile(); 
				}
			return newReptile;
			
		};
		
		private Bird buildBird() {
			Bird newBird = null;
			
			switch (ThreadLocalRandom.current().nextInt(2)) {
				case 0:
					newBird = new Duck(); break;
				default:
					newBird = new Hawk(); 
				}
			return newBird;
			
		};
		
		private Animal buildDomestic() {
			Domesticatable newAnimal = null;
			
			switch (ThreadLocalRandom.current().nextInt(4)) {
				default:
				case 0:
					newAnimal = new Dog();
				case 1:
					newAnimal = new Cat();
				case 2:
					newAnimal = new Horse();
				}
				
			return (Animal)newAnimal;
			
		};
		
		private List<String> getClassList(String subDir){ // this will give us a file representation of the package name
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
		


};// closes class                             
	
