package arrayExample;

public class NUMBER_EXAMPLE2 {

	public void swaptwonumbers(int num1, int num2)
	{
		System.out.println("initially num1 = "+num1+" num2 = "+ num2);
		num1 = num1 + num2;//23+12 = 35
		num2 = num1 - num2;//35-12 = 23
		num1 = num1 - num2;//35-23 = 12
		System.out.println("initially num1 = "+num1+" num2 = "+ num2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NUMBER_EXAMPLE2 s = new NUMBER_EXAMPLE2();
				s.swaptwonumbers(12, 23); // take the bigger value first
	}

}
