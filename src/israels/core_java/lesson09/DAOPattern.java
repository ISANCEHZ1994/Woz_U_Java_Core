package israels.core_java.lesson09;

import java.util.List;
import java.util.Scanner;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.RandomAnimalBuilder;
import israels.core_java.common.animal.mammals.Lion;
import israels.core_java.lesson09.dao.*;

public class DAOPattern {

	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		useMemoryDAO();
		useFileDao();	
		transferFilesToMySqlDb();
		
		
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
	
	private void transferFilesToMySqlDb() {
		DaoFactory factory = new AnimalDaoFactory();
		AnimalDAO fileDao = null;
		AnimalDAO dbDao = null;
		try {
			fileDao = factory.getDao("files");
			dbDao = factory.getDao("rdbms");
			dbDao.setDebug(true);
		} catch (DataStoreNotFoundException e) {
			System.out.println(e);
			return;
		}
		
        Scanner sc = new Scanner(System.in);
        String answer;
  		System.out.println("In MySQL Workbench, drop the animals table and recreate it.");
		System.out.println("After recreating the table, type 'yes' and hit 'enter' to continue");
		answer = sc.nextLine();
		if (!answer.equalsIgnoreCase("yes")) {
			System.out.println("Operation aborted!");
			return;
		}
		System.out.println("Is MySQL Workbench closed? Type 'yes' and hit 'enter' to continue");
		answer = sc.nextLine();
		if (!answer.equalsIgnoreCase("yes")) {
			System.out.println("Operation aborted!");
			return;
		}
		// Retrieve the lions from the dao:
		for (Animal animal : fileDao.findAll()) {
			dbDao.create(animal);
		}
		sc.close();
		dbDao.close();
	}
	
	private void useRdbmsDAO() {
		DaoFactory factory = new AnimalDaoFactory();
		AnimalDAO dao = null;
		try {
			dao = factory.getDao("rdbms");
		} catch (DataStoreNotFoundException e) {
			System.out.println(e);
			return;
		}
		// Retrieve the animals from the dao:
		for (Animal animal : dao.findAll()) {
			System.out.println(animal);
		}
		// Delete all the files
//		for (Animal lion : dao.findAll()) {
//			dao.delete(lion);
//		}
		// Find a specific file
//		Animal animalToFind = dao.find("lion", 12, 381, Sex.MALE);
//		
//		System.out.print("Dao find method returned: ");
//		System.out.println(animalToFind);
		
	}





	
}
