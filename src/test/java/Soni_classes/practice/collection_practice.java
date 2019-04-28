package Soni_classes.practice;

import java.util.*;


public class collection_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List
		List <String> l = new ArrayList <String>();
		l.add("Soni");
		l.add("Sandeep");
		l.add("varsha");
		
		
		for(int i=0; i<l.size();i++){
		 System.out.println(l.get(i));
		}
		
		//set example
		Set<String> s = new HashSet<String>(); //no indexing in set so cannot retrive value using for loop 
		s.add("Soni");
		s.add("lucky");
		s.add("Sandeep");
		s.add("varsha");
				
		Iterator <String> Itr= s.iterator();//iterator is an interface 
		while (Itr.hasNext()){
			String val = Itr.next();
		    System.out.println(val);
			
		}
	}

}
