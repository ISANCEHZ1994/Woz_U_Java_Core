/*
* 	A functional interface is an interface with one and only one abstract
 * 		method
 *  A functional interface can have multiple static or default methods
 *		(see Predicate in the Java 8 API)
 */
package israels.core_java.lesson10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.Sex;
import israels.core_java.common.animal.birds.Bird;
import israels.core_java.common.animal.birds.Emu;
import israels.core_java.common.animal.domestic.Dog;

public class FunctionalPrograming {
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");

		lambdaSyntax();
		passingLambdasIntoMethods();
		compareLambdasAndMethodsReference();
		testSupplier();

		System.out.println("=========================================================================\n\n");
	};

	List<Dog> pack = (List<Dog>) new RandomAnimalBuilder(Dog.class).build(10);

	private List<Dog> dogQ(Predicate<Dog> expression) { // Q short for => Querier
		List<Dog> result = new ArrayList<>();
		for (Dog d : pack) { // we are testing each dog in the pack

			if (expression.test(d)) { // if its true

				result.add(d);
			}
		}

		return result;
	};
	
	private void passingLambdasIntoMethods() {
		System.out.println();
		
		System.out.println("====> Passing lambdas into the dogQuerier method: ");
		
		System.out.println("Minimum age of 17: " + dogQ(d -> d.getAge() >= 12));
		System.out.println("Maximum weight of 20: " + dogQ(d -> d.getWeight() <= 20)); // all of them have more weight thus no matches
		System.out.println("Dogs like Buddy: " + dogQ(d -> {
											boolean b = d.getAge() > 12;
											b &= d.getWeight() < 30;
											b &= d.getSex() == Sex.MALE;
											return b;
											})
										); // closes printout 
	};

	private void lambdaSyntax() {
		System.out.println("====> lambdaSyntax: ");
		
		System.out.println("Dogs in pack: ");

		for (Dog d : pack) {
			System.out.println(d);
		}
		System.out.println();

		System.out.println("1. Find dogs older than 9");
		Predicate<Dog> pred = d -> d.getAge() > 9; // 'd' is implied from <Dog>
		for (Dog d : pack) {
			if (pred.test(d)) {
				System.out.println(d);
			}

		}
		System.out.println();

		System.out.println("2. Find dogs younger than 5");
		Predicate<Dog> pred2 = (d) -> d.getAge() < 5; // Parenthesis are optional
		for (Dog d : pack) {
			if (pred2.test(d)) {
				System.out.println(d);
			}

		}
		System.out.println();

		System.out.println("3. Find dogs heavier than 50");
		Predicate<Dog> pred3 = (Dog d) -> d.getWeight() > 50; // Parenthesis are REQUIRED if Explicitly declaring d
		for (Dog d : pack) {
			if (pred3.test(d)) {
				System.out.println(d);
			}
		}

		System.out.println();

		System.out.println("4. Find dogs lighter than 20");
		Predicate<Dog> pred4 = (Dog d) -> {
			return d.getWeight() < 20;
		};// <=== you have to close this!!
		for (Dog d : pack) { // Using curly braces around expression to right of arrow
			if (pred4.test(d)) { // curly braces REQUIRE return statement and ending semicolon
				System.out.println(d);
			}
		}
		System.out.println();

		System.out.println("5. Find female dogs over 9 weighting < 20");
		Predicate<Dog> pred5 = d -> {
			boolean result = d.getAge() > 9 && d.getWeight() > 20;
			result &= d.getSex() == Sex.FEMALE;
			return result;
		}; // <=== you have to close this!!
		for (Dog d : pack) {
			if (pred5.test(d)) {
				System.out.println(d);
			}
		}

	};
	
	private void compareLambdasAndMethodsReference() {
		System.out.println("=========> Predicate interface with method references vs lambdas <=========");
		
		String str = "asdfasdf";
		
		// LAMBDA
		Predicate<String> pred1Lambda = s -> str.startsWith(s);
		System.out.println("Starts with 'A': " + pred1Lambda.test("A")); // false
		System.out.println("Starts with 'a': " + pred1Lambda.test("a")); // true
		
		System.out.println();
		
		// :: METHOD REFERENCE
		Predicate<String> pred1MethodRef = str::startsWith; // notice no parameter - Java knows what you are trying to use
		System.out.println("Starts with 'A': " + pred1MethodRef.test("A")); // false
		System.out.println("Starts with 'a': " + pred1MethodRef.test("a")); // true
		
		Dog dog = new Dog("Snoopy");
		
		dog.setAge(15);
		dog.setWeight(27);
		dog.setBreed("Pug");
		
		System.out.println("\n Using Dog Class: ");
		Predicate<Dog> pred2Lambda = d -> dog.getAge() > 12;
		System.out.println("Snoopy over 12? " + pred2Lambda.test(dog));
		
		
		Predicate<Emu> pred2MethodRef = Bird::canFly;
		System.out.println("Can Emus fly? " + pred2MethodRef.test(new Emu())); // false
		Predicate<Emu> pred3MethodRef = Bird::canRun;
		System.out.println("Can Emus run? " + pred3MethodRef.test(new Emu()));	// true
				
	};
	
	private void testSupplier() {
		System.out.println("The Supplier Functional Interface");
		
		Supplier<LocalDate> mRefSupp = LocalDate::now;
		System.out.println("Today: " + mRefSupp.get());
		
		Supplier<LocalDate> lambSupp = () -> LocalDate.of(1776, 7, 4);
		System.out.println("Independence Day: " + lambSupp.get());
		
	};
	

};
