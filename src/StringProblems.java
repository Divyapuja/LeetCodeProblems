import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;


public class StringProblems {
	public static boolean isAnagram(String s, String t) {

	    int count1[] = new int[26];
	    int count2[] = new int[26];

	    if(s.length()!=t.length())
	    return false;

	   for(int i=0;i<s.length();i++){
	       count1[(s.charAt(i) - 'a')]++;
	       count2[(t.charAt(i)-'a')]++;
	   }

	   if(Arrays.equals(count1,count2))
	   return true;
	   else
	   return false;

	}
	
	public static boolean isAnagram1(String s, String t) {
        if(s.length() == t.length())
        {
            char[] s1 = s.toCharArray();
            Arrays.sort(s1);
            s = new String(s1);

            char[] t1 = t.toCharArray();
            Arrays.sort(t1);
            t = new String(t1);
            
            if(s.equals(t))
            {
	            return true;
            }
            else
            {
	            return false;
            }
        }
        else
        {
            return false;
        }
    }
	public static int titleToNumber(String s) {
        if(s.length() == 0)
        {
            return 0;
        }
        else
        {
            int sum=0;
            int val=0;
            for(int i=s.length(); i>0; i--)
            {
                val = ((int)s.charAt(i-1)-'A')+1;
                sum = (int) (sum + Math.pow(26,(s.length()-i))*val);
            }
            return sum;
        }
    }
	
	public static int romanToInt(String s) {
        HashMap<String, Integer> romans=new HashMap<String, Integer>();
        romans.put("I",1);
        romans.put("V",5);
        romans.put("X",10);
        romans.put("L",50);
        romans.put("C",100);
        romans.put("D",500);
        romans.put("M",1000);
        
        int val=0;
        
        if(s.length()==1)
        {
        	return val+romans.get(String.valueOf(s.charAt(0)));
        }
        
        for(int i=0;i<s.length();i++)
        {
            if(i+1 < s.length())
            {
            	if(romans.get(String.valueOf(s.charAt(i))) >= romans.get(String.valueOf(s.charAt(i+1))))
            	{
            		val = val+romans.get(String.valueOf(s.charAt(i)));
            	}
            	else
            	{
            		val = val-romans.get(String.valueOf(s.charAt(i)));
            	}
            }
        }
        if(s.length()-1>0)
        {
        	val = val+romans.get(String.valueOf(s.charAt(s.length()-1)));
        }
        
        return val;
    }
	
	public boolean isPalindrome(String s) {
        if(s.equals(""))
        {
            return true;
        }
        
        String forward = new String("");
        String backward = new String("");
        
        s=alphaNumericValue(s);
        
        int mid = s.length()/2;
        
        for(int i=0; i<mid; i++)
        {
            forward+=s.charAt(i);
        }
        for(int i=s.length()-1; i>mid; i--)
        {
            backward+=s.charAt(i);
        }
        if(forward.toLowerCase().equals(backward.toLowerCase()))
        {
            return true;
        }
        
        return false;
    } 
	
	public boolean isPalindrome1(String s) {
        if(s == null)
        {
        	return false;
        }
        String forward = new String("");
        String backward = new String("");
        
        int left=0;
        int right=s.length()-1;
        int i=0;
        while(left<right)
        {
        	if(!isAlphaNumericValue(s.charAt(left)))
        	{
        		left++;
        	}
        	else if(!isAlphaNumericValue(s.charAt(right)))
        	{
        		right--;
        	}
        	else if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))
        	{
        		return false;
        	}
        	else
        	{
        		left++;
        		right--;
        	}
        }
        
        
        return true;
    } 

	public String alphaNumericValue(String s)
	{
		String s1=new String("");
		for(int i=0; i<s.length(); i++)
		{
			if( (s.charAt(i) >= 48 && s.charAt(i)<=57) || 
				(s.charAt(i) >= 65 && s.charAt(i)<=90) || 
				(s.charAt(i) >= 97 && s.charAt(i)<=122))
			{
				s1+=s.charAt(i);
			}
		}
		
		return s1;
	}

	public boolean isAlphaNumericValue(char c)
	{
			if( (c >= 48 && c<=57) || 
				(c >= 65 && c<=90) || 
				(c >= 97 && c<=122))
			{
				return true;
			}
		
		
		return false;
	}
	//{"a", "a", "b"} return "a"
	//{"a","a"} return "a"
	//{"ac", "ac", "a", "a"} return "a"
	public String longestCommonPrefix(String[] strs) {
		String result = new String("");
		if(strs.length == 0)
		{
			return "";
		}
		if(strs.length == 1)
		{
			return strs[0];
		}
		if(strs.length>1)
		{
			Arrays.sort(strs);
			//compare the first and the last string
			String first = new String(strs[0]);
			String last = new String(strs[strs.length-1]);
			
			if(first.length()>last.length())
			{
				String temp =first;
				first = last;
				last = temp;
			}
			
			for(int i=0;i<first.length();i++)
			{
				if(first.charAt(i)==last.charAt(i))
				{
					result = result+String.valueOf(first.charAt(i));
				}
				else
				{
					break;
				}
			}
			
		}
    	return result;
    }
	public String addBinary(String a, String b) {
    
		if(a.length()==0 && b.length()==0)
		{
			return "";
		}
		else if(a.length()==0 && b.length()>0)
		{
			return b;
		}
		else if(a.length()>0 && b.length()==0)
		{
			return a;
		}
		else
		{
			int dec1 = conversionBinaryToDecimal(Integer.parseInt(a));
			int dec2 = conversionBinaryToDecimal(Integer.parseInt(b));
			return String.valueOf(conversionDecimalToBinary(dec1+dec2));
			
		}
		
	}
	public int conversionBinaryToDecimal(int bin)
	{
		int dec=0;
		int i=0;
		while(bin!=0)
		{
			int mod = bin%10;
			dec = dec+ mod*(int)Math.pow(2, i);
			i++;
			bin = bin/10;
		}
		return dec;
	}
	public int conversionDecimalToBinary(int dec)
	{
		int bin=0;
		int i=0;
		while(dec!=0)
		{
			int mod = dec%2;
			bin = bin + mod*(int)Math.pow(10, i);
			i++;
			dec = dec/2;
		}
		return bin;
	}
	public String addBinary1(String a, String b) {
		
		if(a.length()==0 && b.length()==0)
		{
			return "";
		}
		else if(a.length()==0 && b.length()>0)
		{
			return b;
		}
		else if(a.length()>0 && b.length()==0)
		{
			return a;
		}
		else
		{
			String result = new String("");
			int carry =0;
			int aLen = a.length();
			int bLen = b.length();
			int aNum=0;
			int bNum=0;
			int cNum =0;
			while(Math.max(aLen, bLen)>0)
			{
				if(aLen>0)
				{
					aNum = a.charAt(aLen-1)-'0';
					aLen--;
				}
				else
				{
					aNum=0;
				}
				if(bLen>0)
				{
					bNum = b.charAt(bLen-1)-'0';
					bLen--;
				}
				else
				{
					bNum =0;
				}
				cNum = aNum + bNum +carry;
				result = result+String.valueOf(cNum%2);
				carry = cNum/2;
			}
			if(carry ==1)
			{
				result = result+String.valueOf(1);
			}
			
			String result1 = new String("");
			for(int i=result.length()-1; i>=0;i--)
			{
				result1=result1+String.valueOf(result.charAt(i));
			}
			
			return result1;
		}
	}
	
	public boolean isValid(String s) {
		Stack<String> arr = new Stack<String>();
		int errCount=0;
        if(s.length()>0)
        {
        	for(int i=0; i<s.length();i++)
        	{
        		if(s.charAt(i)== '(' || s.charAt(i)== '[' ||s.charAt(i)== '{')
        		{
        			arr.push(String.valueOf(s.charAt(i)));
        		}
        		else if(s.charAt(i)== ')')
        		{
        			errCount++;
        			if(!arr.empty())
        			{
	        			if(arr.peek().equals("("))
	        			{
	        				arr.pop();
	        				errCount--;
	        			}
        			}
        		}
        		else if(s.charAt(i)== ']' )
        		{
        			errCount++;
        			if(!arr.empty())
        			{
	        			if(arr.peek().equals("["))
	        			{
	        				arr.pop();
	        				errCount--;
	        			}
        			}
        		}
        		else if(s.charAt(i)== '}')
        		{
        			errCount++;
        			if(!arr.empty())
        			{
	        			if(arr.peek().equals("{"))
	        			{
	        				arr.pop();
	        				errCount--;
	        			}
        			}
        		}
        	}
        }
    	if(arr.empty() && errCount == 0)
    	{
    		return true;
    	}
    	return false;
    }
	//compare version 0.1, 0.0.1, 0.0.0.2
	public int compareVersion(String version1, String version2) {
    
		
		if(version1.length()>0 && version2.length()>0)
		{
			StringTokenizer st1 = new StringTokenizer(version1,".");
			StringTokenizer st2 = new StringTokenizer(version2,".");
			while(st1.hasMoreElements() || st2.hasMoreElements())
			{
				int token1=0, token2=0;
				if(st1.hasMoreElements())
				{
				token1 = Integer.parseInt((String) st1.nextElement());
				}
				else
				{
					token1=0;
				}
				
				if(st2.hasMoreElements())
				{
					token2 = Integer.parseInt((String) st2.nextElement());
				}
				else
				{
					token2=0;
				}
				
				if(token1>token2) return 1;
				if(token1<token2) return -1;
			}
		}
		return 0;
    }
	public String longestPalindrome(String s) {
	    if (s == null || s.length() == 0)
	        return s;
	    String longest = s.substring(0, 1);
	    for (int i = 0; i < s.length(); i++) {
	        if(s.length()-i <longest.length()/2)
	            break;
	        String oddPal = findLengthofPalindrome(s, i, i);
	        if (longest.length() < oddPal.length()) {
	            longest = oddPal;
	        }

	        String evenPal = findLengthofPalindrome(s, i, i + 1);
	        if (longest.length() < evenPal.length()) {
	            longest = evenPal;
	        }
	    }
	    return longest;

	}

	private String findLengthofPalindrome(String s, int left, int right) {
	    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	        left--;
	        right++;
	    }
	    return s.substring(left + 1, right);
	}
	public static void main(String args[])
	{
		StringProblems obj = new StringProblems();
		
		/*String test1 = "A man, a plan, a canal: Panama";
		String test2="race a car";
		
		System.out.println(obj.alphaNumericValue(test1));
		System.out.println(obj.isPalindrome1(test1));
		
		String[] arr = {"pot","pottery","potato"};
		System.out.println(obj.longestCommonPrefix(arr));*/
		//System.out.println(obj.conversionBinaryToDecimal(11));
		//System.out.println(obj.conversionDecimalToBinary(3));
		//System.out.println(obj.addBinary1("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101","110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
		//System.out.println(obj.isValid("(])"));
		//System.out.println(obj.compareVersion("0.0.0.0.1", "0.0.1"));
		System.out.println(obj.longestPalindrome("abaaaabaa"));
		
		
	}
}