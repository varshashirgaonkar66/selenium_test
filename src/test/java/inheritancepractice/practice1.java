package inheritancepractice;

	class X
	{
	    int m = 1111;
	    int n;
	   	 
	    {
	        m = m++; //first assigned so m = 1111 ; its is incremented but not assigned
	 
	        System.out.println(m);
	        
	        n=m+5;
	        
	    }
	    
	    X()
	    {
	    	System.out.println(m);
	    }
	    
	    public static void testMethod()
	    {
	    	
	    }
	}
	
		 
	class Y extends X
	{
	    {
	        System.out.println(methodOfY());
	    }
	 
	    int methodOfY()
	    {
	        return m-- + --m; // 1111 + 1109 = 2220
	    }
	}
	 
	public class practice1 {
		public static void main(String[] args)
	    {
	        Y y = new Y();
	    }
	}

