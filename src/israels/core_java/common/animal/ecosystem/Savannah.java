package israels.core_java.common.animal.ecosystem;

import java.util.List;

import israels.core_java.common.animal.*;
import israels.core_java.common.animal.mammals.*;

public class Savannah extends Ecosystem {
// Variables Section
	List<Lion> lionPride = (List<Lion>) new RandomAnimalBuilder(Lion.class).build(6);
	List<Cheetah> cheetah = (List<Cheetah>) new RandomAnimalBuilder(Lion.class).build(6);
	
	
	@Override
	public void listPopulation() {
		// TODO Auto-generated method stub
		
	}
	// create a simulation of a pride of lion hunting 
	
	// create a simulation of a cheetah hunting
	
	// create a simulation of a gazelles finding a herd of larger animals to rample tall grass
	
	// so they can eat short grass
	
	//second cheetah is nearby, what happens?
	
}
