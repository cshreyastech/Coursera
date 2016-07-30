package inheritancepkg2;

public class Student extends Person {
	public void method1() {
		System.out.println("Student 1");
		super.method1();
		this.method2();
	}

	public void method2() {
		System.out.println("Student 2");
	}
}
