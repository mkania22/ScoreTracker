
public class Student implements Comparable<Student> {
	private String studentName;
	private int studentScore;
	
	public Student(String studentName, int studentScore) {
		super();
		this.studentName = studentName;
		this.studentScore = studentScore;
	}
	

	public int getStudentScore() {
		return studentScore;
	}

	

	public String getStudentName() {
		return studentName;
	}

	public int compareTo(Student o) {
		return studentName.compareTo(o.studentName);
	}

	@Override
	public String toString() {
		return studentName + " "  + studentScore;
	}
	
	
}
