package Soni_classes.practice;

import java.util.*;

public class map_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String,Integer> m = new HashMap<String,Integer>();
		m.put("varsha", 7);//like set
		m.put("varsha",11);//if key is not unique value will be overwritten, since key is unique in java
		m.put("Soni", 6);
		m.put("sandeep", 2);
		
		System.out.println(m.get("Soni"));
		System.out.println(m.get("varsha"));
		
		Iterator<String> Itr = m.keySet().iterator();//using iterator to retrieve all values
		while (Itr.hasNext())
		{
			String key = Itr.next();
			System.out.println(key + "||" + m.get(key));
		}
		
		
		//store map in map
		Map <String,LinkedHashMap<String,String>> m1 
		= new HashMap <String,LinkedHashMap<String,String>>();
		
		LinkedHashMap<String, String> L1 = new LinkedHashMap<String,String>();
		L1.put("Soni1", "s");
		L1.put("varsha1", "v");
		L1.put("sandeep1", "p");
		
		m1.put("soniclasses", L1);
		
		System.out.println(m1.get("soniclasses"));
						
	}

}
