package arrayExample;

import java.util.*;

public class SORT_EXAMPLE {

	public void sortarray() {
		int a[] = { 15, 1, 4, 6, 7, 8, 9, 10 };
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		Arrays.sort(a);
		System.out.println("The sorted array is:");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

	public void sortarraymanually() {
//bubble sort
		int a[] = { 9, 5, 4, 1, 7, 8 };
		int temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < (a.length - i); j++) {
				if (a[j - 1] > a[j]) {
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;

				}
			}
		}
		
		System.out.println(Arrays.toString(a));
		
		/*System.out.println("The sorted array is :");
		for(int i = 0 ; i < a.length; i++){
			System.out.println(a[i]);
		}*/
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SORT_EXAMPLE s = new SORT_EXAMPLE();
		//s.sortarray();
		s.sortarraymanually();
	}

}
