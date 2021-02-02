package israels.core_java.common;

public class Light {
// When launching something and you only want ONE copy - think System.out.println() 
	// one copy used ONLY when/where you want
	
	public static int count = 0;
	
	// We need a static reference variable to hold the address of the one and ONLY SINGLETON
	// This creates a 'LAZY SINGLETON' which does not instantiate the object until needed
	private static volatile Light LightInstance = null;
	
	// This creates an 'EAGER' SINGLETON
//	 private static volatile Light LightInstance = new Light(); // instead of null
	
	// private constructor so the compiler will not add a default constructor
	// This will prevent the users from using the 'new' keyword to instantiate an object
	
//	private Light() {
//		count++;
//	}
	
	// We need a static method to retrieve the single instance of this class
	// It needs to be synchronized to prevent more than one thread from accessing it at any given time
	public static synchronized Light getLightInstance() {
		// This test not needed for eager singleton
		if(LightInstance == null) {
			LightInstance = new Light();
		}
		return LightInstance;
	}

	
	

	
}
