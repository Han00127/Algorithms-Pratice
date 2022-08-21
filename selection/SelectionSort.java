package selection;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
        int[] nums = { 7,4,6,5,3};
        //System.out.println(Arrays.toString(nums));
        selectionSort(nums);
       // System.out.println(Arrays.toString(nums));
	}
	
	
	public static void selectionSort(int[] elements){
        //          n^2/2		
		for (int j=0; j< elements.length-1; j++){              //n
			int minIndex = j; // 
			
			for (int k= j+1; k<elements.length; k++){         // n/2
				if (elements [k] < elements[minIndex]) {
					minIndex = k;
					
				}
			}// end of inner for 
			
			// swaps 
			System.out.println("Before Swapping "+Arrays.toString(elements));
			int temp=elements[j];
			elements[j]=elements[minIndex];
			elements[minIndex]=temp;
			System.out.println("After Swapping "+Arrays.toString(elements));
			
		} // end of outer loop 
	}// end of selectionSort method

}
