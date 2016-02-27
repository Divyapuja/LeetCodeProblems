
public class Bits {
	
	
	public boolean isPowerOfTwo(int n) {

			if((n & (n-1)) ==0) return true;
			return false;
	    }
	
	public int reverseBits(int n)
	{
		int res=0;
		int count = 31;
		while(n!=0)
		{
			if((n & 1) == 1)
			{
				res = res + (1<< count);
			}
			n = n>>1;
			count--;
		}
		
	return res;	
	}
	// the following is a faster solution than the above
	public int reverseBits1(int n)
	{
		int res=0;
		int count=0;
		for(int i=0; i<32; i++)
		{
			res = (res<<1) | (n&1);
			n = n>>1;
			
		}
	return res;	
	}
	
	//we clear all the bits other than bit at i
	int getBit(int num, int i)
	{
		int res=0;
		res = (num & (1<<i))!=0?1:0;
		return   res;
	}
	
	int setBit(int num, int i)
	{
		return num |(1<<i);
	}
	
	int clearBit(int num, int i)
	{
		return num & ~(1<<i);
	}
	//clear all bits from the MSB through i
	int clearBitsMSBthroughI(int num, int i)
	{
		int mask = (1<<i)-1;
		return num & mask;
	}
	//clear all bits from i through 0
	int clearBitsMSBthrough0(int num, int i)
	{
		int mask = ~((1<<(i+1))-1);
		return num & mask;
	}
	int updateBits(int n, int m, int j, int i)
	{
		//clear all the bits from j to i
		for(int k=i; k<=j;k++)
		{
			n = clearBit(n,k);
		}
		m = m<<i;
		
		//combine or merge
		return n|m;
		
	}
	int updateBits1(int n, int m, int j, int i)
	{
		//clear all the bits from j to i
		int allones = ~0;
		int left = allones<<(j+1);
		int right = (1<<(i+1)-1);
		int mask = left | right;
		
		n = n & mask;
		m = m<<i;
		
		//combine
		return n|m;
		
	}
	String printRealNumber(double num)
	{
		if(num>=1 || num<=0) return "ERROR";
		String res = new String();
		
		while(num>0)
		{
			if(res.length()>=32) return "ERROR";
			
			double n= num * 2;
			if(n-1>0)
			{
				res = res+1;
				num = n-1;
			}
			else
			{
				res = res+0;
				num=n;
			}
		}
		
		return res;
	}
	int[] printNextSmallestAndBiggest(int n)
	{
		int l_index=0;
		int h_index=0;
		int[] res=new int[2];
		for(int i=0; i<32;i++)
		{
			//System.out.print(getBit(n,i));
			if(getBit(n,i) == 1)
			{
				if(l_index==0 & h_index==0)
				{
					l_index=i;
					h_index=i;
				}
				else
				{
					h_index=h_index+1;
				}
				
			}
		}
		res[0] =  n<<(32-h_index);
		res[1] = n>>l_index;
		
		return res;
	}
	
	public static void main(String args[])
	{
		Bits obj = new Bits();
		//System.out.println(obj.isPowerOfTwo(-2147483648));
		//System.out.println(obj.reverseBits1(4));
		//System.out.println(obj.getBit(4, 0));
		//System.out.println(obj.clearBit(4, 2));
		//System.out.println(obj.setBit(4, 8));
		//System.out.println(obj.clearBitsMSBthroughI(4, 2));
		//System.out.println(obj.clearBitsMSBthrough0(10, 1));
		//System.out.println(obj.updateBits1(1024,19,6, 2));
		//System.out.println(obj.printRealNumber(0.4));
		System.out.println(obj.printNextSmallestAndBiggest(4)[0]);
		System.out.println(obj.printNextSmallestAndBiggest(4)[1]);
		System.out.println(4>>3);
	}
	
}
