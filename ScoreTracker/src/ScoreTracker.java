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
	int score;
	String fullName;
	Student student;
	
	public void loadDataFile(String inputFile) throws FileNotFoundException{  //will have to change it later
		FileReader reader = new FileReader(inputFile);
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()) {
			firstName = in.next();
			lastName = in.next();
			fullName = firstName + " " + lastName;
			score = in.nextInt();  //or should we cast it later
			
			Student newStudent = new Student(fullName, score);
			studentsList.add(newStudent);   //idk why this doesnt work
		}
	}
	
	public void printInOrder(){
		Collections.sort(studentsList);
		
		for(Student student : studentsList) {
			System.out.println(student.getStudentName() + " " + student.getStudentScore());
		}
			
	}
	
	public void processFiles() throws FileNotFoundException {
		loadDataFile("scores.txt");  
		printInOrder();
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTracker scoreTrackerOne = new ScoreTracker();
		scoreTrackerOne.processFiles();
	}

}
