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
	
	public void loadDataFile(String inputFile) throws FileNotFoundException {  
		studentsList = new ArrayList<Student>();
		
		FileReader reader = null;   //do we need the null?
		reader = new FileReader(inputFile);
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()) {
			firstName = in.next();
			lastName = in.next();
			fullName = firstName + " " + lastName; 
			score = in.next(); 
			
			try {
				intScore = Integer.parseInt(score);
				studentsList.add(new Student(fullName, intScore));
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println("Inccorrect format or " + fullName + " not a valid score: " + score);  //what is get message 
			}
			
			//Student newStudent = new Student(fullName, score);
			  
		}
	}
	
	public void printInOrder(){
		Collections.sort(studentsList);
		
		System.out.println("Student Score List");
		for(Student student : studentsList) {
			System.out.println(student.getStudentName() + " " + student.getStudentScore());
		}
			
	}
	
	public void processFiles() throws FileNotFoundException {
		//array for loop
		for(String fileName : listFiles) {
			try {
				loadDataFile(fileName);  
				printInOrder();
		} catch (FileNotFoundException e){
			System.out.println("Can't open file: " + fileName);
			}
		}

	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTracker scoreTrackerOne = new ScoreTracker();
		scoreTrackerOne.processFiles();
	}

}
