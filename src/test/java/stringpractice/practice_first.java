package stringpractice;


public class practice_first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//length of string
		String name = "Akanksha";
		int len = name.length();
		System.out.println("The length of "+name+"is " +len);


		//to read a character one by one
		char pos1 = name.charAt(0);
		char pos2 = name.charAt(1);
		System.out.println("The position 1 is "+ pos1);
		System.out.println("The position 2 is "+pos2);

		//read character using for loop
		for (int i=0; i< name.length();i++)
		{
			System.out.println(name.charAt(i));
		}

		//reverse string
		String name1 ="madam";
		String revString1 = "";
		for(int i=0;i<name1.length();i++)
		{
			revString1 = name1.charAt(i) + revString1;
			//A + "" =A
		}
		System.out.println(revString1);

		//palindrome
		if(name1.equals(revString1))
		{
			System.out.println("palindrome");
		}
		else
		{
			System.out.println("not a palindrome");
		}

		//reverse string method
		//	String revna = "varsha";
		//	reverseString(revna);

		//find character count -- k in akanksha
		int counterValue = 0;
		for (int j = 0;j<name.length();j++)
		{
			char s= name.charAt(j);

			if (s == 'k')
			{
				counterValue++;
			}

		}
		System.out.println("The count of k in Akanksha is "+ counterValue);	

	}
}
