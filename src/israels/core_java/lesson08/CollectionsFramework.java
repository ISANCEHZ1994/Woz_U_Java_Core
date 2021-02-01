/* The collections framework was added in Java 1.2
 * Interfaces:
 *		Collection
 *		List extends Collection
 *		Set extends Collection
 *		Queue extends Collection
 *		Deque extends Queue
 *		Map
 *		Comparable
 *		Comparator
 *		Iterator
 * Utility classes:
 *		Arrays
 *		Collections
 * Ordered means you can iterate through a collection in a predictable way
*/
package israels.core_java.lesson08;
import java.util.*;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.RandomAnimalBuilder;

public class CollectionsFramework {

	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		collectionsOverView();
		usingComparable();
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void collectionsOverView() {
		System.out.println("1. Collections Overview");
		
		System.out.println("1a. Lists are ordered by index");
		// ArrayList: fast iteration and fast random access, slow insertion and removal
		List<String> aList = new ArrayList<>();
		aList.add("France");
		aList.add("Thailand");
		aList.add(0, "Nigeria");
		System.out.println(aList);
		Collections.sort(aList); // sort them out!
		System.out.println(aList);
		
		// Vector is synchronized ( for multithreading) but slower than ArrayList
		
		// LinkedList good for adding elements at the ends -
		// Slower random access, faster insertion and removal at the ends
		System.out.println("\n LinkedList are good for adding elements at the ends.");
		List<String> bList = new LinkedList<>();
		bList.add("France");
		bList.add("Thailand");
		bList.add(0, "Nigeria");
		System.out.println(bList);
		Collections.sort(bList); // sort them out!
		System.out.println(bList);
		
		
		System.out.println("\n2. Sets are Collections of unique things, unordered");
		System.out.println("HashSet fast access, provides no ordering");
		
		Set<String> aSet = new HashSet<>();
		aSet.add("Canada"); // adds are insertion order!
		aSet.add("Jamaica");
		aSet.add("Japan");
		System.out.println(aSet);
		
		System.out.println("\n LinkedHashSet not as fast, iterates on insertion order");
		Set<String> bSet = new LinkedHashSet<>();
		bSet.add("Jamaica");
		bSet.add("Canada");
		bSet.add("Japan");
		System.out.println(bSet);
		
		System.out.println("\n TreeSet no duplicates, ordered on insertion using Comparable");
		Set<String> cSet = new TreeSet<>();
		cSet.add("Jamaica");
		cSet.add("Canada");
		cSet.add("Japan");
		System.out.println(cSet);
		
		System.out.println("\n3. Maps are collections of key value pairs, keys are unique");
		System.out.println("HashMaps are very fast for updates, allows one null key, many null vaules");
		Map<Integer, String> aMap = new HashMap<>();
		aMap.put(1, "Singapore");
		aMap.put(3, "Brazil");
		aMap.put(7, "Singapore");
		System.out.println(aMap);
		
		System.out.println("\nLinkedHashMaps faster iteration by key insertion or last accessed");
		Map<Integer, String> bMap = new LinkedHashMap<>();
		bMap.put(1, "Brazil");
		bMap.put(3, "Singapore");
		bMap.put(7, "Singapore");
		System.out.println(bMap);
		
		System.out.println("\nTreeMaps have keys sorted on insertion");
		Map<Integer, String> cMap = new TreeMap<>();
		cMap.put(3, "Brazil");
		cMap.put(7, "Singapore");
		cMap.put(1, "Singapore");
		System.out.println(cMap);
 		
		System.out.println("\nPriorityQueue: a to-do list ordered by user defined priority");
		Queue<String> aQue = new PriorityQueue<>();
		aQue.offer("India");
		aQue.add("Saudi Arabia");
		aQue.offer("Poland");
		aQue.add("Germany");
		System.out.println(aQue);
		
		System.out.println("=================================================================");
	}
	
	private void usingComparable() {
		System.out.println("2. Using Comparable to sort");
		List<Animal> animals = (List<Animal>)new RandomAnimalBuilder().build(10);
		for(Animal a : animals) { // ENCHANCED FOR LOOP
			System.out.println(a);
		}
		
		System.out.println();
//		Collections.sort(animals);
		for(Animal a : animals) { // ENCHANCED FOR LOOP
			System.out.println(a);
		}
	};
	
}
