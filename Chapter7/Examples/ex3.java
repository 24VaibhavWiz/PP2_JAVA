package chapter7;
import java.util.Random;

public class ex3
{
	private static Random rand = new Random();
	
	public void sort(int[] v){

    QuickSort(v, 0, v.length-1);
	}

	private void QuickSort (int[] v, int first, int last) {

		if (first >= last)
			return;
		else {
			if (last - first < 15) {
				InsertionSort(v, first, last);
				return;
				}
			int[] pivotLoc = partitionArray(v, first, last, makePivot(v,first,last));
			QuickSort(v, first, pivotLoc[1]);
			QuickSort(v, pivotLoc[0], last);
			}

	}

	private int[] partitionArray (int[] v, int first, int last, int pivot) {

		while(last <= first) {

			while(v[first] < pivot) first++;
			while(v[last] > pivot) last--;
				if (first > last) break;
					swap(v, first, last);
					first++;
					last--;
		}
    return new int[] {first, last};
	}

	private void swap(int[] v, int first, int last) {
		int temp = v[first];
		v[first] = v[last];
		v[last] = temp;
	}
	public void InsertionSort(int[] v, int first, int last) {
		int temp;
		for (int i=first + 1; i <= last; i++) {
			int j = i;
			while (j > 0 && v[j-1] > (v[j]) ) {
				temp = v[j];
				v[j] = v[j-1]; 
				v[j-1] = temp; 
				j--;
        	}
    	}
	}
	
	private int makePivot (int[] v, int first, int last){
		return v[rand.nextInt(last-first+1)+first];
	}

}