/*
 * DAO design pattern implementation classes should NOT be public. We hide the implementation details from
 * the user. 
 * 
 */
package israels.core_java.lesson09.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import israels.core_java.common.animal.Animal;
import israels.core_java.common.animal.Sex;

class MemoryCacheAnimalDAO implements AnimalDAO {
	private static List<Animal> animalListCache = new ArrayList<>();
	private boolean debug = false;
	
	@Override
	public void setDebug(boolean in) {
		debug = in;
	}
	
	@Override
	public void create(Animal a) {
		System.out.println("Adding " + a + " to a memory cache");
		animalListCache.add(a);		
	}

	@Override
	public Animal find(String type, int age, int weight, Sex sex) {
		for (Animal a : animalListCache) {
			if (a.getExtendedType().toLowerCase() == type.toLowerCase() &&
								a.getAge() == age &&
								a.getWeight() == weight &&
								a.getSex() == sex )	
			{
				return a;
			}
		}
		return null;
	}

	@Override
	public Collection<Animal> findAll() {
		// Bad encapsulation:
//		return animalListCache;
		return new ArrayList<Animal>(animalListCache);
	}

	@Override
	public boolean update(Animal a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(Animal a) {
		animalListCache.remove(a);		
	}

	@Override
	public void close() { }
	
	@Override
	public void setDebug() {
		// TODO Auto-generated method stub
		
	}

}
