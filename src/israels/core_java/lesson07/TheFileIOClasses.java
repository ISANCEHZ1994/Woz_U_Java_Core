/* Overview:
 *     File - checking, creating and deleting files and directories
 *     FileInputStream - reads in bytes
 *     FileReader - reads in characters
 *     FileOutputStream - writes out bytes
 *     FileWriter - writes out characters
 *     BufferedReader - reads text streams and stores them in a buffer
 *     BufferedWriter - writes text streams
 *     PrintWriter - easy to use class for writing files
 *
 * File I/O in Java follows the Decorator design pattern
 *
 * FileWriter key methods
 *     constructors using File or String
 *     write() - writes characters out to a file
 *     flush()
 *     close()
 * FileReader key methods
 *     constructors using File or String
 *     read(char []) - reads characters from a file and puts the in a char[]
 *     close()
 *
 * BufferedReader key methods
 *     constructor using Reader
 *     read()
 *     readLine()
 *     close()
*/

package israels.core_java.lesson07;

import java.io.*;


public class TheFileIOClasses {

	
	public void inClassWork() {
		System.out.println("We are in => " + this.getClass().getSimpleName() + ".inClassWork()");
		
		File fileToTest = useFileWriter();
		useFileReader(fileToTest);
//		useBufferedReader();
		
		System.out.println();
		System.out.println("=========================================================================\n\n");
	};
	
	
	
	private static final String file1Line1 = "Forescore and seven years ago our fathers brought forth\n";
	private static final String file1Line2 = "on this continent a new nation, conceived in liberty and dedicated\n";
	private static final String file1Line3 = "to the proposition that all men are created equal.";
	
	private File useFileWriter() {
		System.out.println("1. FileWriter writes out characters to a file");
		
		File myFile = new File("Gettysburg.txt");
		
		
		// Java 7 way using try-with-resources
		try(FileWriter fw = new FileWriter(myFile, false)) { // NOTE: this boolean means APPEND  
			// will keep adding the same thing if true
			
			fw.write(file1Line1);
			fw.write(file1Line2);
			fw.write(file1Line3);
			fw.flush();
		}catch(IOException e){
			System.out.println(e);
		}
		return myFile;
	};
	
	
	private void useFileReader(File inFile) {
		System.out.println("2. FileReader in Characters From a File");
		char[] buffer = new char[(int)inFile.length()];
		System.out.println("Size of the file to read in: " + inFile.length());
		
		// try with resources => NO Finally required!
		
		try(FileReader fr = new FileReader(inFile)){
			int size = fr.read(buffer);
			System.out.println("Size of the file actually read in: " + size);
			// NOTE: Below are same: for loop and ENCHANCED For Loop
			
//			for(int i = 0; i < buffer.length; i++) {
//				System.out.print(buffer[i]);
//			}
			for(char c : buffer) {
				System.out.print(c);
			}
			
			
		}catch(IOException e) {
			System.out.println(e);
		}

	};
	
	
	private void useBufferedReader(File inFile) {
		System.out.println("2. FileReader reads in characters from  " + inFile);
		String textFromFile = null;
		try(BufferedReader br = new BufferedReader(new FileReader(inFile))){
			while((textFromFile = br.readLine()) != null) {
				System.out.println(textFromFile);
			}
		}catch(IOException e) {
			System.out.println(e);
		}
		
	};
	
	
};
