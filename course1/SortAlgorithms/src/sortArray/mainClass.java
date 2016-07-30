package sortArray;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = { 7, 16, 66, 43, 97, 51 };
//		SortArrays.insertionSort(arr);
		Random random = new Random();
		List<Integer> numsToSort = new ArrayList();
		
		for (int i = 0; i < 5; i++) {
			numsToSort.add(random.nextInt(100));
		}
		
		Collections.sort(numsToSort);
		System.out.println(numsToSort.toString());
	}
}
