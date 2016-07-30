package inheritancepkg;

public class Student extends Person{
	private int studentID;
	public Student(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int studentID) {
		super(name);
		this.studentID = studentID;
	}

	
	public int getSID() {
		return this.studentID;
	}
	
	public String toString() {
		return "" + this.getSID() + ": " + super.toString();
	}
}
