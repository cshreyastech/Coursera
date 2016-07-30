package inheritancepkg;

public class Person {
	private String name;
	public Person(String name){
		this.name = name;
	}
	private String getName() {
		return this.name;
	}
	public String toString() {
		return this.getName();
	}
}
