
public class Student implements Comparable<Student> {
	private String studentName;
	private int studentScore;
	
	// Constructor for students
	public Student(String studentName, int studentScore) {
		super();
		this.studentName = studentName;
		this.studentScore = studentScore;
	}
	
	// gets the students score
	public int getStudentScore() {
		return studentScore;
	}

	// gets the students name
	public String getStudentName() {
		return studentName;
	}

	// Helps to sort the list by comparing the students to one another by name, implementing comparable 
	public int compareTo(Student o) {
		return studentName.compareTo(o.studentName);
	}

	@Override
	public String toString() {
		return studentName + " "  + studentScore;
	}
	
	
}
