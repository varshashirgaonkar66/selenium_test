package arrayExample;

public class example1 {
	
	public void printarray()
	{
		int a[] = {6,7,8,9,10};
		for (int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}

		
	}
	
	public void multidimarray(){
		int a[][] = new int[5][8];
		a[0][0]=10;
		a[0][1]=11;
		a[1][1]=12;
		a[4][5]=50;
		for (int i = 0 ; i < a.length ; i++){
			for (int j = 0 ; j < a[i].length ; j ++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println(" ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		example1 ex = new example1();
		ex.printarray();
		//ex.multidimarray();
		
	}
	

}
