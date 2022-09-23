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
	
	public void loadDataFile(String inputFile){
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
	
	public void processFiles() {
		loadDataFile();  //need to pass in a file but how?
		printInOrder();
	}
	
	
	public static void main(String[] args) {
		ScoreTracker scoreTrackerOne = new ScoreTracker();
		scoreTrackerOne.processFiles();
	}

}
