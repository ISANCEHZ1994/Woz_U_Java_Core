package israels.core_java.lesson09;

import java.util.List;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.mammals.Lion;
import israels.core_java.lesson09.dao.AnimalDAO;
import israels.core_java.lesson09.dao.AnimalDaoFactory;
import israels.core_java.lesson09.dao.DaoFactory;
import israels.core_java.lesson09.dao.DataStoreNotFoundException;

public class DAOPattern {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		useMemoryDAO();
		useFileDao();	
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	private void useMemoryDAO(){
		
		// MemoryCacheAnimalDAO is package level access and is not visible
		// AnimalDAO dao = new MemoryCacheAnimalDAO();
		
		DaoFactory factory = new AnimalDaoFactory();
		AnimalDAO dao = null;
		try {
			 dao = factory.getDao("memory");
		}catch(DataStoreNotFoundException e) {
			System.out.println(e);
			return;
		}
		
		// Create a list of animals to use with the dao:
		List<Animal> lionPride = (List<Animal>) new RandomAnimalBuilder(Lion.class).build(7);	
		dao.setDebug(true);
		
		for(Animal lion : lionPride) {
			dao.create(lion);
		}
		
		System.out.println("--------------------------------------------------\n");
		//Retrieve the lions from the dao:
		for(Animal lion : dao.findAll()) {
			System.out.println(lion);
		}
		
		System.out.println("--------------------------------------------------\n");
	}

		
	private void useFileDao() {
		DaoFactory factory = new AnimalDaoFactory();
		AnimalDAO dao = null;
		try {
			dao = factory.getDao("files"); // reference to AnimalDAOFacotry.java
		} catch (DataStoreNotFoundException e) {
			e.printStackTrace();
		}
		
			// Create a list of animals to use with the dao:
				List<Animal> lionPride = (List<Animal>) new RandomAnimalBuilder(Lion.class).build(7);	
				dao.setDebug(true);
//				
//				for(Animal lion : lionPride) {
//					dao.create(lion);
//				}
				
				System.out.println("--------------------------------------------------\n");
				//Retrieve the lions from the dao:
				for(Animal lion : dao.findAll()) {
					System.out.println(lion);
				}
				
				//Delete all the files
				for(Animal lion : dao.findAll()) {
					dao.delete(lion);
				}
		
	}
	
}
