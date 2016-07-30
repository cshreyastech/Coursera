package airports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MyBuilInSortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		List<Integer> numsToSort = new ArrayList();
		
		for(int i = 0; i < 5; i++) {
			numsToSort.add(random.nextInt(100));
		}
		
		Collections.sort(numsToSort);
		System.out.println(numsToSort.toString());
	}

}
