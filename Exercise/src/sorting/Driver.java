package sorting;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort sorter = new Sort();
		int arr[] = {8,3,4,5,7,6,9,1,2};
		sorter.quickSort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
