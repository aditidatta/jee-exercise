package sorting;

public class Sort {
	public void insertionSort(int[] arr){
		for(int i = 0; i<arr.length; i++){
			arr[i] = i;
		}
	}
	
	public void quickSort(int[] arr, int left, int right){
		int i = left;
		int j = right;
		int temp;
		int pivot = arr[(left+right)/2];
		
		while(i <= j){
			while(arr[i] < pivot){
				i++;
			}
			while(arr[j] > pivot){
				j--;
			}
			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
	
		
		if(left < j){
			quickSort(arr,left,j);
		}
		
		if(i < right){
			quickSort(arr,i,right);
		}
	}
}
