package israels.core_java.common.animal.ecosystem;

import java.util.ArrayList;
import java.util.List;

import israels.core_java.common.animal.*;
import israels.core_java.common.animal.mammals.*;
import israels.core_java.lesson09.dao.AnimalDAO;
import israels.core_java.lesson09.dao.AnimalDaoFactory;
import israels.core_java.lesson09.dao.DaoFactory;
import israels.core_java.lesson09.dao.DataStoreNotFoundException;

public class Savannah extends Ecosystem {
// Variables Section
	List<Lion> lionPride = new ArrayList<>(); //(List<Lion>) new RandomAnimalBuilder(Lion.class).build(6);
	List<Cheetah> cheetah = (List<Cheetah>) new RandomAnimalBuilder(Lion.class).build(6);
	
	public Savannah() {
		setEcosystem(EcosystemType.SAVANNAH);
		useFileDao();
		
	}
	
	
	@Override
	public void listPopulation() {
		// TODO Auto-generated method stub
		
	}
	// create a simulation of a pride of lion hunting 
	
	// create a simulation of a cheetah hunting
	
	// create a simulation of a gazelles finding a herd of larger animals to rample tall grass
	
	// so they can eat short grass
	
	//second cheetah is nearby, what happens?
	
	private void useFileDao() {
		DaoFactory factory = new AnimalDaoFactory();
		AnimalDAO dao = null;
		try {
			dao = factory.getDao("file");
		} catch (DataStoreNotFoundException e) {
			// works when we dont have this lol
			
			System.out.println(e);
			return;
			
		}
		dao.setDebug(false);
		
//			// Create a list of animals to use with the dao:
//				List<Animal> lionPride = (List<Animal>) new RandomAnimalBuilder(Lion.class).build(7);	
//				dao.setDebug(true);
//				
//				for(Animal lion : lionPride) {
//					dao.create(lion);
//				}
				
				System.out.println("--------------------------------------------------\n");
				//Retrieve the lions from the dao:
				for(Animal lion : dao.findAll()) {
					System.out.println(lion);
				}
				
//				//Delete all the files
//				for(Animal lion : dao.findAll()) {
//					dao.delete(lion);
//				}
		}


	@Override
	public void findNearbyAnimals() {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
	
	
}
