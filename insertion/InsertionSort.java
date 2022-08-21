package insertion;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 7,4,6,5,3 };
		System.out.println(Arrays.toString(arr));
		insertionSort(arr);
		//System.out.println(Arrays.toString(arr));
	}

	public static void insertionSort(int[] elements) {
		for (int i = 1; i < elements.length; i++) {
			int next = elements[i];
			
			int j = i;
			// Moves the larger elements up to insert next into correct spot
			while (j > 0 && elements[j - 1] > next) {
				elements[j] = elements[j - 1];  // move larger number up
				j--; // since j is decremented, we need to put while(j > 0 ...
			} // end of while
			// Inserts the element 
			elements[j] = next;
			System.out.println(Arrays.toString(elements));
		} // end of for
	}

}