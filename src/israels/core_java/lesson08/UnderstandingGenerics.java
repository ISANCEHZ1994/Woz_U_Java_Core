package israels.core_java.lesson08;

import java.util.ArrayList;
import java.util.List;

import israels.core_java.common.animal.domestic.Dog;

public class UnderstandingGenerics {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		genericTyping();
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void genericTyping() {
		List<String> strList = new ArrayList<>();
		
		strList.add("A String Literal");
		strList.add(new Integer(42).toString());
		strList.add(new Dog("Buddy").toString());
		strList.add(this.getClass().toString());
		
		for(String s : strList) {
			System.out.println(s);
		}
		
		// Can't create a collection using primitives
		// List<int>
		List<Integer> intList = new ArrayList<>();
		
		// These examples use auto-boxing
		intList.add(46);
		intList.add(35);
		// Can't add a list of Strings to a list of Integers
		//inList.addAll(strList);
		
		System.out.println(intList.get(0).getClass());
		
	}
	
	
}
