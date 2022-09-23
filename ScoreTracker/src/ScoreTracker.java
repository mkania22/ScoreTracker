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
	Student student;
	int score;
	
	public void loadDataFile(String inputFile) throws FileNotFoundException{  //will have to change it later
		studentsList = new ArrayList<Student>();
		
		FileReader reader = new FileReader(inputFile);
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()) {
			firstName = in.next();
			lastName = in.next();
			fullName = firstName + " " + lastName;
			score = in.nextInt();  //or should we cast it later
			
			//Student newStudent = new Student(fullName, score);
			studentsList.add(new Student(fullName, score));   //idk why this doesnt work
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
