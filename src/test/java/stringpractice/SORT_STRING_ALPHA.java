package stringpractice;

import java.util.Arrays;

public class SORT_STRING_ALPHA {

	public void alphasortstring() {

		char a[] = { 'V', 'A', 'R', 'S', 'h', 'a' };
		char temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < (a.length - i); j++) {

				temp = a[j - 1];
				a[j - 1] = a[j];
				a[j] = temp;

			}
		}

		System.out.println(Arrays.toString(a));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SORT_STRING_ALPHA s = new SORT_STRING_ALPHA();
		s.alphasortstring();
	}

}
