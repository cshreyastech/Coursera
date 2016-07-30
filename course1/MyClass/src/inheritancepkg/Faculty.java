package inheritancepkg;

public class Faculty extends Person{
	private String employeeID;
	
	public Faculty(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Faculty(String name, String employeeID) {
		super(name);
		this.employeeID = employeeID;
	}
	public String getEID() {
		return this.employeeID;
	}
	
	public String toString() {
		return "" + this.getEID() + ": " + super.toString();
	}
}
