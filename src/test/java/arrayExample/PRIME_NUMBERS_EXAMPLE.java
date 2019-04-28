package arrayExample;

public class PRIME_NUMBERS_EXAMPLE {

	public void checkifprime(int n) {
		if (n < 2) {
			System.out.println(n + " is not a prime number");
		} else {
			int result; 
			boolean Flag = false;
			for (int i = 2; i < n; i++) {
				result = n % i;
				if (result == 0) {
					System.out.println(n + " is not a prime number");
					Flag = true;
					break;
				}
			}
			if (Flag == false){
				System.out.println(n + " is a prime number");
			}
		}

	}
	
	public void printallprimenumbers(int k){
		for (int m = 1; m < k; m++)
		{
			int n = m;
			if (n < 2) {
				System.out.println(n + " is not a prime number");
			} else {
				int result; 
				boolean Flag = false;
				for (int i = 2; i < n; i++) {
					result = n % i;
					if (result == 0) {
						System.out.println(n + " is not a prime number");
						Flag = true;
						break;
					}
				}
				if (Flag == false){
					System.out.println(n + " is a prime number");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PRIME_NUMBERS_EXAMPLE p = new PRIME_NUMBERS_EXAMPLE();
		p.checkifprime(13);
		p.checkifprime(1);
		p.checkifprime(4);
		p.printallprimenumbers(100);
	}

}
