package arrayExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueElementsInArray {
	
	public void searchunique()
	{

	int a[] = {6,7,8,9,10};
	int b[] = {6,7,12,13,10};
	//unique values from both arrays
	//common output to both arrays
	
	List<Integer> l1= new ArrayList<Integer>();
	
		for (int i=0;i<a.length;i++)
		{
			l1.add(a[i]);
		}

	List<Integer> l2= new ArrayList<Integer>();
		for (int j=0;j<b.length;j++)
		{
			l2.add(b[j]);
		}
		
		
	// combining both elements in array
	//	l1.addAll(l2);
	//	System.out.println("combination of both lists "+l1);
		
	//	Set<Integer> s1 = new HashSet<Integer>(l1);
	//	System.out.println("unique values in both lists is "+s1);
		
		l1.retainAll(l2);
		System.out.println("Common elements in both arrays "+l1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueElementsInArray ex = new UniqueElementsInArray();
		ex.searchunique();
		
	}
}
