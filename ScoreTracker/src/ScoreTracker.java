import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTracker {
	private ArrayList<Student> studentsList;  //Should be students 
	String line;
	
	public void loadDataFile(String inputFile){
		FileReader reader = new FileReader(inputFile);
		
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()) {
			line = in.nextLine();
			studentsList.add(line);   //idk why this doesnt work
		}
	}
	
	public void printInOrder(){
		
		
	}
	
	public void processFiles() {
		loadDataFile(file);  //need to pass in a file but how?
		printInOrder();
	}
	
	
	public static void main(String[] args) {
		ScoreTracker scoreTrackerOne = new ScoreTracker();
		scoreTrackerOne.processFiles();
	}

}
