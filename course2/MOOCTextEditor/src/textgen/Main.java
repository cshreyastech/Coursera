package textgen;

public class Main {
	public static void main(String[] args) {
		MyLinkedList<Integer> longList = new MyLinkedList<Integer>();
		longList.add(10);
		longList.add(20);
		longList.add(30);
		longList.add(40);
		longList.add(50);
		
		System.out.println("size: " + longList.size);
		longList.print();
		longList.printReverse();
		int index = 2;
//		System.out.println("\nValue at index " + index + ": " + longList.get(index));
		
//		longList.add(index, 1);
		
//		System.out.println("\nValue replaced: " + longList.set(index, 10));
		
		System.out.println("\nValue removed: " + longList.remove(index));
		longList.print();
		longList.printReverse();
	}

}
