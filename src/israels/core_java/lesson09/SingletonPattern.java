package israels.core_java.lesson09;

import israels.core_java.common.Light;

public class SingletonPattern {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		// Can't use new to instantiate Light()
		//Light newLight = new Light(); // when commenting out the constructor in Light(common) File 
		//we can now instantiate
		System.out.println("Calling Light.getLightInstance(), Light Count: " + Light.count);
		Light newLight = Light.getLightInstance();
		System.out.println("Light count: " + Light.count);
		
		System.out.println("Calling Light.getLightInstace() a second time: ");
		Light light2 = Light.getLightInstance();
		System.out.println("Light count: " + Light.count);
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	
}
