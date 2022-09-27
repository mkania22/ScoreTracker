import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;


public class ScoreTracker {
	private ArrayList<Student> studentsList;  //Should be students 
	String firstName;
	String lastName;
	String fullName;
	String fileName;
	String score;
	
	Student student;
	
	int intScore;
	private String[] listFiles = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	// This method takes in an input file checking that it exists and reads each line storing the name and score of the student in an array
	public void loadDataFile(String inputFile) throws FileNotFoundException {  
		studentsList = new ArrayList<Student>();
		
		FileReader reader = null;   
		reader = new FileReader(inputFile);
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()) {
			firstName = in.next();
			lastName = in.next();
			fullName = firstName + " " + lastName; 
			score = in.next(); 
			
			// Checks to make sure that the score given is an integer, if not it gives and error message
			try {
				intScore = Integer.parseInt(score);
				studentsList.add(new Student(fullName, intScore));
			} catch (NumberFormatException e) {
				System.out.println("Inccorrect format or " + fullName + " not a valid score: " + score);  
				System.out.println();
			}
			  
		}
	}
	
	// This method sorts the array by name and then prints it in order
	public void printInOrder(){
		Collections.sort(studentsList);
		
		System.out.println("Student Score List");
		for(Student student : studentsList) {
			System.out.println(student.getStudentName() + " " + student.getStudentScore());
		}
		System.out.println();
			
	}
	
	// This method goes through a loop of files and executes the loadDataFile and printInOrder method if the file exists
	public void processFiles() throws FileNotFoundException {
		for(String fileName : listFiles) {
			// Checks to see if the file exists, if it doesn't it will display a message instead
			try {
				loadDataFile(fileName);  
				printInOrder();
		} catch (FileNotFoundException e){
			System.out.println("Can't open file: " + fileName);
			}
		}

	}
	
	// Main calls the rest of the code
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTracker scoreTrackerOne = new ScoreTracker();
		scoreTrackerOne.processFiles();
	}

}
