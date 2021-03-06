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
import israels.core_java.common.animal.ecosystem.EcosystemType;
import israels.core_java.common.animal.mammals.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class RdbmsAnimalDAO implements AnimalDAO {

	private boolean debug = false;
	
	
	public void setDebug (boolean in) {
		debug = in;
	}
	
	private Connection mySQLConnection = null;
	private String url = "jdbc:mysql://127.0.0.1:3306";
	private String username = "ecosystem";
	private String password = "Is092094$";

	public RdbmsAnimalDAO() {
		try {
			mySQLConnection = DriverManager.getConnection(url,username,password);
			System.out.println("MySQL connection established!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private int count = 1000;
	
	@Override
	public void create(Animal a) {
		int key = ++count;
		a.setAnimalId(key);
		create(key,a);

	}
	
	private void create(int key, Animal a) {
		try (Statement stmt = mySQLConnection.createStatement()) {
            // Create a string that is a SQL query
			StringBuilder insert = new StringBuilder("INSERT INTO ecosystem.animals VALUES(");
			insert.append(key + ", '");
			insert.append(a.getType() + "', ");
			insert.append(a.getAge() + ", ");
			insert.append(a.getWeight() + ", '");
			insert.append(a.getSex() + "', ");
			insert.append(a.getHealth() + ", '");
			insert.append(a.getEcosystem() + "');");
            // Execute the query and wait for the result set
			int result = stmt.executeUpdate(insert.toString());
			if (result == 1) {
				System.out.println(result + " rows inserted: " + a);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	};

	@Override
	public Animal find(String type, int age, int weight, Sex sex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Animal> findAll() {
		System.out.println("Finding all the animals in the database");
		List<Animal> animalList = new ArrayList<>();
		try (Statement stmt = mySQLConnection.createStatement()) {
            // Create a string that is a SQL query
			String query = "SELECT * FROM ecosystem.animals";
            // Execute the query and wait for the result set
			ResultSet rs = stmt.executeQuery(query);
            // Iterate throw the result set printing out the desired information
			while (rs.next()) {
				Animal a = createAnimalClass(rs.getString("animal_type"));
				a.setAnimalId(rs.getInt("animal_id"));
				a.setAge(rs.getInt("age"));
				a.setWeight(rs.getInt("weight"));
				a.setSex(Sex.valueOf(rs.getString("sex")));
				a.setHealth(rs.getByte("health"));
				a.setEcosystem(EcosystemType.valueOf(rs.getString("ecosystem")));
				animalList.add(a);
			}
		} catch (SQLException se) {se.printStackTrace(); }
		return animalList;
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
	public void close(){
		try {
			mySQLConnection.close();
			if(debug) System.out.println("MySQL connection closed..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void setDebug() {
		
	}
	
	private Animal createAnimalClass(String type) {
		Animal newAnimal = null;
		switch(type) {
		case "wolf": newAnimal = new Wolf(); break;
		default: newAnimal = new Animal();
		}
		return newAnimal;
	}

}
