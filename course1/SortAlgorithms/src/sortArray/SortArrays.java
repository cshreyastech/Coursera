package sortArray;

public class SortArrays {
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static void insertionSort(int[] arr) {
		int currInd;
		
		for(int pos = 1; pos < arr.length; pos++) {
			currInd = pos;
			while (currInd > 0 && arr[currInd] < arr[currInd - 1]) {
				int temp = arr[currInd];
				arr[currInd] = arr[currInd - 1];
				arr[currInd - 1] = temp;
				
				currInd --;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
