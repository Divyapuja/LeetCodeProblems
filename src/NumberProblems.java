import java.util.HashSet;


public class NumberProblems {
		
	public boolean canWinNim(int n) {
        if(n==0){
            return false;
        }
        else if(n==1){
            return true;
        }
        else if(n>1)
        {
            if(n%2 == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else{
        	return false;
        }
    }
	
	public static int hammingWeight(int n) {
		int bits =0;
		int i=0;
		while(i<32)
		{
			if((n & 1) == 1)
			{
				bits++;
			}
			n=n>>1;
			i++;
		}
        
        return bits;
    }
	
	public static int climbStairs(int n) {
        int count=0;
       int x=0;
        int y=0;
        for(int i=0;i<n+1;i++)
        {
        	x=i;
        	if((n-x)%2 ==0)
        	{
        		y = (n-x)/2;
        		count = count + (fact(x+y)/(fact(y)*fact(x)));
        	}
        }
        return count;
    }
 
	 public static int fact(int n)
	 {
		 if(n==0)
		 {
			 return 1;
		 }
		 
			 return n*fact(n-1);
		 
	 }
 
	 public static int climbStairs1(int n) {
	      	int count =0;
	      	int[] dp=new int[n+1];
	      	if(n == 0)
	      	{
	      		dp[0]=0;
	      	}
	      	if(n == 1)
	      	{
	      		dp[0]=0; dp[1]=1;
	      	}
	      	if(n >= 2)
	      	{
	      		dp[0]=0; dp[1]=1; dp[2]=2;
	      	
		      	for(int i=3; i<=n; i++)
		      	{
		      		dp[i]=dp[i-2]+dp[i-1];
		      	}
	      	}
	      	return dp[n];
	    }
	 
	 public boolean isPowerOfThree(int n) {
		 double num = Math.log(n)/Math.log(3);
	        return Math.abs(num - Math.round(num)) <=10e-15;
	        
	    }
	 //power of three 3^32 1162261467
	    public boolean isPowerOfThree1(int n) {
	        return n > 0 && (1162261467 % n == 0);
	        
	    }
	 
	 public static boolean isUgly(int num) {
	        if(num == 1)
	        {
	        	return true;
	        }
	        if(num == 0)
	        {
	        	return false;
	        }
	        boolean flag=true;
	        while(num!=1)
	        {
	        	if(num%2 == 0)
	        	{
	        		num = num/2;
	        		flag = true;
	        	}
	        	else if(num%3 == 0)
	        	{
	        		num = num/3;
	        		flag = true;
	        	}
	        	else if(num%5 ==0)
	        	{
	        		num=num/5;
	        		flag=true;
	        	}
	        	else
	        	{
	        		num =1;
	        		flag = false;
	        	}
	        }
	       return flag;
	    }
	 public static boolean isHappy(int n) {
	        
		 double sum=0;
		 int a=0;
		 while(n!=0)
		 {
			 a=n%10;
			 sum = sum + Math.pow(a, 2);
			 n=(n-a)/10;
			 
			 if(n==0)
			 {
			 	 if(sum==1)
				 {
					 return true;
				 }
				 else
				 {
					 n=(int) sum;
					 sum=0;
					 a=0;
				 }
			 }
		 }
		 
		 return false;
	    }
	 
	 public static boolean isHappy1(int n) {
	        
		 if (n <= 0) return false;
		    HashSet<Integer> set = new HashSet<Integer>();
		    while(n !=1 && !set.contains(n)) {
		        set.add(n);
		        int m = n;
		        n = 0;
		        while(m != 0) {
		            n += (m%10)*(m%10);
		            m = m/10;
		        }
		    }
		    if (n == 1) return true;
		    else return false;
	    }
	 public static boolean isPowerOfTwo(int n) {
		 double num = Math.log(n)/Math.log(2);
	        return Math.abs(num - Math.round(num)) <=10e-15;
	        
	    }
}
