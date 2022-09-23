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
	
	public void loadDataFile(String inputFile) throws Exception {  
		studentsList = new ArrayList<Student>();
		
		FileReader reader = null;   //do we need the null?
		
		try {
			reader = new FileReader(inputFile);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());  //what is get message
		}
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()) {
			firstName = in.next();
			lastName = in.next();
			fullName = firstName + " " + lastName;
			
			score = in.nextInt();  
			
			if(score != int) {
				throw new Exception("Inccorrect format or " + fullName + "not a valid score: " + score);  //this is not quite right
			}
			
			//Student newStudent = new Student(fullName, score);
			studentsList.add(new Student(fullName, score));   
		}
		
		in.close();
	}
	
	public void printInOrder(){
		Collections.sort(studentsList);
		
		System.out.println("Student Score List");
		for(Student student : studentsList) {
			System.out.println(student.getStudentName() + " " + student.getStudentScore());
		}
			
	}
	
	public void processFiles() {
		loadDataFile("scores.txt");  
		printInOrder();
		
		loadDataFile("badscore.txt");  //testing exception
	
	}
	
	public static void main(String[] args) {
		ScoreTracker scoreTrackerOne = new ScoreTracker();
		scoreTrackerOne.processFiles();
	}

}
