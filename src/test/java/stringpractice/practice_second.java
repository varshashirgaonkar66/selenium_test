package stringpractice;

public class practice_second {

		public static int characterCount(String name,char s1) {
		int counterValue = 0;
		
		//convert charecter to string
		String s2 = Character.toString(s1); // string a
		
		
		for (int j = 0; j < name.length(); j++) {
			char s = name.charAt(j);
			String s3 = Character.toString(s);
			if (s3.equalsIgnoreCase(s2)) {
				counterValue++;
			}

		}
		System.out.println("The count of k in Akanksha is " + counterValue);
		return counterValue;
	}
		
		public static String convertToUpperCase(String name){
			String upper = name.substring(1, 4);
			
			System.out.println(upper.toUpperCase());
			return name;
			
		}
		
		public static void firstLetterOfWorfCapital(String sentence)
		{
			String a[] = sentence.split(" ");//returns character one by one if we use only double quotes without space
			
			String newString = "";
			for (int i = 0; i < a.length; i++){
				String word = a[i];
				//System.out.println(word);
				String test = word.substring(0, 1).toUpperCase().concat(word.substring(1,word.length()));
				System.out.println(test);
				newString  = newString +" "+ test ;
			}
			System.out.println(newString);
			
			// ArrayIndexOutOfBoundsException --> unchecked exceptions i <= 
		
		}
		
		public static void convertFirstwordUsingArray(){
			
		}
		
		//replace specific character -- eg replace k with s
		public static void replaceCharacterExample(String name,char a)
		{
			String name1 = name.replace(a, 'm');
			String remove = name.replace(a, ' ');
			System.out.println(name1);
			System.out.println(remove);
		}

	public static void main(String args[]) {
		
		int counterval=characterCount("Akanksha",'a');
		System.out.println(counterval);
		System.out.println();
		convertToUpperCase("Akanksha");
		firstLetterOfWorfCapital("my name is himanshu");
		replaceCharacterExample("varsha",'a');
	}
	
	//static method within a class can be used directly without object 
	
	//"my name is himanshu"
	
	
}