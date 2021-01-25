package israels.core_java.common.animal.reptiles;

import java.util.ArrayList;
import java.util.List;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Carnivore;

public abstract class Reptile extends Animal implements Carnivore {
	
	protected List<String> prey = new ArrayList<>();
	
	protected String preyFound = null;
	protected String preyCaught = null;

	@Override
	public void hunt() {
		// TODO Auto-generated method stub

	}

	@Override
	public String findPrey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean catchPrey(Animal target) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
