/*
 * DAO design pattern implementation classes should NOT be public. We hide the implementation details from
 * the user. 
 * 
 */
package israels.core_java.lesson09.dao;

import java.util.Collection;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Sex;

class RdbmsAnimalDAO implements AnimalDAO {

	@Override
	public void create(Animal a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Animal find(String type, int age, int weight, Sex sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Animal> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Animal a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Animal a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDebug(boolean in) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDebug() {
		// TODO Auto-generated method stub
		
	}

}
