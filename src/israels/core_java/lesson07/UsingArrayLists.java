/* 	ArrayList class is part of the collection API. They are:
 * 		1. dynamic and can grow and shrink as needed
 * 		2. implement the List interface
 * 		3. uses a zero based index to maintain order
 * 		4. not sized when first created
 *	 	5. can have duplicate values
 *
 * Some ArrayList methods:
 *     add(element) - Adds an element to the END of the ArrayList
 *     add(index, element) - Add an element at the index location shifting other elements
 *     clear() - removes all the elements of an ArrayList
 *     contains(element) - returns whether or not an ArrayList contains that element
 *     get(index) - Returns the element at the specified index in the list. Does not remove it.
 *     indexOf(Object) - returns the index location of the object or -1 if not found
 *     iterator() - returns an iterator
 *     remove(index) - removes the element at that index shifts later elements down
 *     remove(object) - removes the first occurrence of the object if it exists
 *     set(index, object) - replaces the existing element t the specified index
 *     size() - returns the number of elements in the ArrayList
 */

package israels.core_java.lesson07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.domestic.Dog;

public class UsingArrayLists {
	
	List<String> cityList = new ArrayList<>(); // <= Instantce Variable
	
	List<Dog> dogList;
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		
		creatingArrayList();
		compareArraysToArrayList();
		convertingArrayToList();
		convertingListToArray();
		usingAnInterator();
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	private void creatingArrayList() {
		// Java 5's && Java 6's
		List<String> list = new ArrayList<String>();
		
		// Java 7
		List<String> list3 = new ArrayList<>();
		
		
		List<String> list4 = new ArrayList<>(list3);
		
	};
	
	private void compareArraysToArrayList() {
		String[] cityArray = new String[3];
//		List<String> cityList = new ArrayList<>(); <= Local Variable
		
		cityArray[0] = "Oslo";
		cityArray[1] = "Paris";
		cityArray[2] = "Rome";
		
		cityList.add("Oslo"); 
		cityList.add("Paris");
		cityList.add("Rome");
		
		System.out.println("Size of the array is: " + cityArray.length); // NOTE: Both are 3!
		System.out.println("Size of the ArrayList is: " + cityList.size());
		
		// Say we want to add an element between Oslo and Paris
		String [] al = new String[4];
		al[0] = cityArray[0];
		al[1] = "London";
		al[2] = cityArray[1];
		al[3] = cityArray[2];
		cityArray = al;
		
		cityList.add(1,"London");
//		cityList.add(2,"New York");
		
		// Note: this needs a For Loop to show in Console - for now .length
		System.out.println("Array: " + cityArray.length);
		
		System.out.println("ArrayList: " + cityList.size());
		
		for(String city : cityArray) {
			System.out.println(city + " ");
		}
		System.out.println();
		System.out.println(cityList);
	};
	
	private void convertingListToArray() {
		dogList = (List<Dog>) new RandomAnimalBuilder(Dog.class).build(5);
		
		Dog[] dogArray = new Dog[dogList.size()];
		dogArray = dogList.toArray(dogArray);
		
		System.out.println("dogArray: " + Arrays.toString(dogArray));
		
	};
	
	private void usingAnInterator() {
		cityList.add("Naples");
		cityList.add("Rome");
		
		// Before Java 5 we had to use an iterator
		Iterator<Dog> it = dogList.iterator();
		
		while(it.hasNext()) { // returns true or false => will be true until false
			Dog d = (Dog)it.next();
			System.out.println(d);
		}
	};
	
	private void convertingArrayToList() {
		String [] sa = { "hobbit", "wizard", "elf", "dwarf"};
		List<String> listFromArray = Arrays.asList(sa);
		System.out.println(listFromArray);
		
	};
	
}
