package inheritancepkg;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Person p = new Person("Tim");
		// System.out.println(p);
		// Student s = new Student("Clara", 1234);
		// System.out.println(s);

		// Person s = new Student("Clara", 1234);
		// System.out.println(s);

		// Person p[] = new Person[3];
		// p[0] = new Person("Tim");
		// p[1] = new Student("Cara", 1234);
		// p[2] = new Faculty("Mia", "ABCD");
		//
		// for(int i = 0; i < p.length; i++) {
		// System.out.println(p[i]);
		// }

		// Person s = new Student("Cara", 1234);
		// ( (Student)s ).getSID();
		// System.out.println(s);

		
		Person s = new Person("Tim");
		if (s instanceof Student) {
			((Student) s).getSID();
		}
	}

}
