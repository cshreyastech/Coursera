package constructorspkg;

public class Person {
	private String name;
	public Person() {
		
	}
	public Person(String n) {
		super();
		this.name = n;
	}
	public void setName(String n) {
		this.name = n;
		System.out.println(this.name);
	}
}
