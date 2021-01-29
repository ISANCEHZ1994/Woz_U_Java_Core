package israels.core_java.lesson06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import israels.core_java.common.animal.Sex;
//import israels.core_java.common.animal.mammals.Lion;

public class TryWithResources {
	
	private Path parentDir = Paths.get("src", "israels","core_java", "common","animal");
	// this is literally our file path as a variable
	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		//Try With Resources
		
		// Java 6 way
		java6way();
		
		//Java 7 way  
		java7way();
		
		
		System.out.println("=========================================================================\n\n");
	};
	
	
	
	private void java6way() { // NOTE: This will print out the entire Gazelle class in console
		System.out.println("======> 1. Print out Gazelle.java using the Java 6 (earlier) way <==========");
		Path targetFile = Paths.get(parentDir.toString(), "mammals", "Gazelle.java");
//		Reader reader = null;
		String data = null;
		BufferedReader br = null;// safer class(BufferedReader) to use than Reader
		try {
			br = Files.newBufferedReader(targetFile);
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException ioe) {
			System.out.println(ioe);
			
		}finally {
			try {
				br.close();
			} catch (IOException ioe) {
				System.out.println(ioe);
			}
		}
		
	};
	
	private void java7way() {
		System.out.println("==========> 2. Print out Snake.java using the Java 7 way <=============");
		Path targetFile = Paths.get(parentDir.toString(), "reptiles", "snake.java");
		String data = null;
	
		try(BufferedReader br = Files.newBufferedReader(targetFile)){
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
		// NOTE: Hella easier to use!
	};
	
}
