package israels.core_java.common.animal;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import israels.core_java.common.animal.ecosystem.EcosystemType;

public class Animal implements Serializable {
	
// --------------------------> VARIABLES SECTION <----------------------------------------------------------
	// Variables with GETTERS && SETTERS
	// static variables first
	
	
	
	// This is a static or class primitive variable
	private static int count = 0; // static means there's only ONE copy of it 
	public static int getCount() { return count; };
	
	// This is an INSTANCE REFERENCE VARIABLE
	private String type;
	public String getType(){ return type; }
	final protected void setType( String t) { type = t; };
	// we use protected - means that not only those from package 
	// but ones that are extended to it - SUCH AS ELEPHANT Class! - ENCAPSOLATION
	
	private int age;
	public int getAge() { return age; };
	public void setAge(int a) { // replaced age with a
		// this.age = age; // this is called shadowing - NEVER DO THIS!!!
		// its not obvious so the scope will be hard to detect
		if(a < 0) {
			age = 0;
			throw new AgeException(a, MAX_AGE, this.getClass());
		}else if(a > MAX_AGE) {
			age = a + 1;
			System.out.println(this.toString() + " has passed ");
			throw new AgeException(a, MAX_AGE, this.getClass());
		} else {
			age = a;
		}
	};
	
	protected int MATURITY = 12;
	protected int FEMALE_MATURITY = 2;
	protected int MALE_MATURITY = 3;
	protected int MAX_AGE = 50;
	protected int BIRTH_WEIGHT = 10;
	protected int ADULT_FEMALE_MIN_WEIGHT = 100;
	protected int ADULT_FEMALE_MAX_WEIGHT = 150;
	protected int ADULT_MALE_MIN_WEIGHT = 120;
	protected int ADULT_MALE_MAX_WEIGHT = 180;
	protected int TEETH = 32;
	
	public int getMaxAge() {return MAX_AGE;};

	private int weight; // <= REMINDER: private means its only visible to itself!
	public int getWeight() { return weight; };
	public void setWeight(int w) { // REMINDER: void doesn't return a type
		if(w >= 0) { weight = w; }
	};
	
	private Sex sex = Sex.FEMALE; // From the Sex Enum inside common.animal (Sex.java)
	public Sex getSex() {
		return sex;
	};
	public void setSex(Sex s) {
		sex = s;
	}
	
	private byte health = 10;
	public byte getHealth() {
		return health;
	};
	public void setHealth(byte b) {
		if(b <= 10 && b >= -10) {
			health = b;	
		}else{ // this is if you try to set the health 
			throw new IllegalArgumentException("Health must be between -10 and +10 incluisve");
		};
	};
	
	private transient boolean targeted = false; //(transient) this variable will NOT be saved into the Animal Files folder - DAOPattern
	public boolean isTargeted() { return targeted;};
	public void setTargeted(boolean b) { targeted = b;};
	
	private EcosystemType ecosystemType = EcosystemType.UNKNOWN;
	public void setEcosystem(EcosystemType est) { ecosystemType = est;}
	public EcosystemType getEcosystem() { return ecosystemType;}
	
	private int animalId = 0;
	public void setAnimalId(int id) {
		animalId = id;
	}
	public int getAnimalId() {
		return animalId;
	}
	
// --------------------------> CONSTRUCTOR SECTION <----------------------------------------------------------
	static {
//		 System.out.println("In the Animal STATIC initialization Block"); // static - it only runs the FIRST TIME it is loaded
	};
	
	{ // this is an INITIALIZATION Block
//		System.out.println("In the animal initialization block <=============");	
		++count;
		type = "UKNOWN ANIMAL ";
	};
	
	
	public Animal () { 
//		System.out.println("IN animal no-arg constructor"); // this had both ++count; type = "UKNOWN ANIMAL ";
	};
	
	// This is OVERLOADING THE CONSTRUCTOR
	public Animal(int a) {
		this();
		setAge(a);
		setWeight(setRandomWeightByAge(a));
	};
	
	// Rewriting the top Overloading Constructor
	public Animal(int a, Sex s) { // NOTE: You can make it easier by just having the sex variable here!
		this();
		setAge(a);
		setSex(s);
		setWeight(setRandomWeightByAge(a));
	};
	

// --------------------------> METHOD SECTION <----------------------------------------------------------
	// Override Object Methods
	@Override
	public String toString() { // this will change the outcomes of what was written in Classes.java file
		String result = type + " Age: " + age + " Weight: " + weight;
		result += " Sex: " + getSex().toString().charAt(0) + ") "; // All this does is return a CAPITAL F - because that's the only thing we set
		return result;
	};
	
	
	@Override
	public boolean equals(Object other) { // if you use Animal as a parameter 
		// you are Overloading NOT Overriding
		if(this == other)return true;
		if(other == null) return false; // its to test if this variable is pointing to something
		boolean result = false;
		if(other.getClass() == this.getClass()) {
			Animal aRef = (Animal)other;
			result = this.type.equalsIgnoreCase(aRef.type) &&
					this.age == aRef.age &&
					this.weight == aRef.weight &&
					this.sex == aRef.sex &&
					this.ecosystemType == aRef.ecosystemType;
		}
		return result;
	};
	
	
	@Override
	public int hashCode() {
		int code = type.toLowerCase().hashCode();
		// ^= is the bitwise XOR assignment operator
		 code ^= (age * 17);
		 code ^= (weight * 31);
		 code += sex.toString().hashCode();
		 code += ecosystemType.toString().hashCode();
		return code;
	}
	
	// Class Animal Methods
	
	public String getExtendedType() {
		String t = type;
		if (this.getAge() == 0 ) {
			t = "baby " + type;
		} else if (this.getAge() < MATURITY) {
			t = "young " + type;
		} else if (this.getAge() > MAX_AGE) {
			t = "dead " + type;
		}
		return t;
	};
	
	public void eat() {
		System.out.println("a " + type + " is found eating");
	};
	public void move() {
		System.out.println("a " + type + " is found moving");
	};
	public void sleep() {
		System.out.println("a " + type + " is found sleeping");
	};
	
	public void setRandomWeightByAge() { // <== added this to test the overloading in Overloading.java
	 setRandomWeightByAge( // NOTE: REMOVED The getAge(); method INSIDE OF setRandomWeightByAge 
		ADULT_FEMALE_MIN_WEIGHT,
		ADULT_FEMALE_MAX_WEIGHT, 
		ADULT_MALE_MIN_WEIGHT,
		ADULT_MALE_MAX_WEIGHT,
		BIRTH_WEIGHT);
	};
	
	protected int setRandomWeightByAge(int a) {
		int result;
		if(a < 5) {
			result = a * 2;
		}else {
			result = ThreadLocalRandom.current().nextInt(12,200);
		}
		return result;
	};
	
	
	
	// This is overloading because we are using the same name and changing the argument list
	public void setRandomWeightByAge( // passing all these variables!
	int femaleMinWeight, 
	int femaleMaxWeight,
	int maleMinWeight, 
	int maleMaxWeight, 
	int birthWeight) {
		
	int adultMinWeight, adultMaxWeight;
		
	if(this.sex == sex.FEMALE) {
		adultMinWeight = femaleMinWeight;
		adultMaxWeight = femaleMaxWeight;
	}else {
		adultMinWeight = maleMinWeight;
		adultMaxWeight = maleMaxWeight;
	}
	
	if(getAge() == 0) {
		setWeight(birthWeight);
	}else if (getAge() <= MATURITY) {
		double proportion = getAge()/(double)MATURITY; 
		setWeight((int)(adultMinWeight * proportion)); // Must be downcasted! setWeight recieves an int not a double!
	}else {
		setWeight(ThreadLocalRandom.current().nextInt(adultMinWeight,adultMaxWeight));
	}
	
	}; // closes setRandomWeightByAge
	
	
	public void grow() {
		setAge(age + 1);
		int oldWeight = weight; // this will reset weight
		setRandomWeightByAge();
		if( weight < oldWeight) {
			weight = oldWeight;
		}
	};
	
	public Animal reproduce() {
		if (sex == Sex.MALE) {
			System.out.println("Male " + getExtendedType() + " looks for female " + getExtendedType());
			return null;
		}
		if(age > MATURITY){
			return new Animal(0); // By default its ZERO but no harm in specifiying
		}else {
			System.out.println("Female " + getExtendedType() + " is not old enough.");
			return null;
		}
	};
	
	public void changeHealth(int x) { 
		int newHealth = health + x;
		if(newHealth > 10) {
			health = 10;
		}else if(newHealth < -10) {
			health = -10;
		}else {
			health = (byte)newHealth; // remember that we have it set as byte all the way up
		}
	};
	
//	@Override
//	public int compareTo(Animal otherAnimal) {
//		int result = 0;
//		
//		result = type.compareToIgnoreCase(otherAnimal.type);
//		if(result == 0) {
//			result += new Integer(age).compareTo(new Integer(otherAnimal.age));
//			if(result == 0) {
//				result += new Integer(weight).compareTo(new Integer(otherAnimal.weight));
//			}if(result == 0) {
//					result += sex.compareTo(otherAnimal.sex);
//			}
//		}
//		
//		return result;
//	};
	
};
