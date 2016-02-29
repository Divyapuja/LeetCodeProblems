import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	/*----------------------------13. ROMAN TO INTEGER--------------------------*/
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
	/*------------------------------------125. VALID PALINDROME------------------------*/
	public boolean isPalindrome1(String s) {
        if(s == null)
        {
        	return false;
        }
        int left=0;
        int right=s.length()-1;
        int i=0;
        while(left<right)
        {
        	//ignore alphanumeric characters from the left side
        	if(!isAlphaNumericValue(s.charAt(left)))
        	{
        		left++;
        	}
        	//ignore alphanumeric characters from the right side
        	else if(!isAlphaNumericValue(s.charAt(right)))
        	{
        		right--;
        	}
        	//compare alphanumeric chars from left and right. if they are unequal return false: not a valid palindrome
        	else if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))
        	{
        		return false;
        	}
        	else
        	{
        		//keep incrementing from left and decrementing from right
        		left++;
        		right--;
        	}
        }
        //returns true if everything matches
        return true;
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
	/*--------------------------14. LONGEST COMMON PREFIX----------------------------*/
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
			
			//swap if the first string is larger than the second string
			if(first.length()>last.length())
			{
				String temp =first;
				first = last;
				last = temp;
			}
			//compare characters from two string..same chars append to a new string..on mismatch return the new string
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
	/*---------------------------67. ADD BINARY----------------------------------*/
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
			String result = new String("");
			int carry =0;
			int aLen = a.length();
			int bLen = b.length();
			int aNum=0;
			int bNum=0;
			int cNum =0;
			//continue till the longer string finishes..hence max of a and b is chosen
			while(Math.max(aLen, bLen)>0)
			{
				//get a digit from a
				if(aLen>0)
				{
					aNum = a.charAt(aLen-1)-'0';
					aLen--;
				}
				else
				{
					aNum=0;
				}
				//get a digit from b
				if(bLen>0)
				{
					bNum = b.charAt(bLen-1)-'0';
					bLen--;
				}
				else
				{
					bNum =0;
				}
				//add both the digits with a carry over
				cNum = aNum + bNum +carry;
				//put the resultant value without carry over
				result = result+String.valueOf(cNum%2);
				//store the updated carry over
				carry = cNum/2;
			}
			if(carry ==1)
			{
				result = result+String.valueOf(1);
			}
			
			//reverse the value to get the actual result
			String result1 = new String("");
			for(int i=result.length()-1; i>=0;i--)
			{
				result1=result1+String.valueOf(result.charAt(i));
			}
			
			return result1;
		}
	}
	/*-----------------------------20. VALID PARENETHESIS---------------------------------*/
	public boolean isValid(String s) {
		Stack<String> arr = new Stack<String>();
		int errCount=0;
        if(s.length()>0)
        {
        	for(int i=0; i<s.length();i++)
        	{
        		//push all openings into a stack
        		if(s.charAt(i)== '(' || s.charAt(i)== '[' ||s.charAt(i)== '{')
        		{
        			arr.push(String.valueOf(s.charAt(i)));
        		}
        		//if a closing comes, check if the top of the stack has the same kind of opening
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
	/*-------------------------165. COMPARE VERSION NUMBERS-------------------------------------*/
	//compare version 0.1, 0.0.1, 0.0.0.2
	public int compareVersion(String version1, String version2) {
    
		
		if(version1.length()>0 && version2.length()>0)
		{
			StringTokenizer st1 = new StringTokenizer(version1,".");
			StringTokenizer st2 = new StringTokenizer(version2,".");
			//compare each integer from two string..if one is larger return 1 else return -1
			//if same return 0
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
	/*--------------------38. COUNT AND SAY------------------------------------*/
	//1, 11, 21, 1211, 111221,
	//do a DP
	 public String countAndSay(int n) {
		 	String seq = new String("1");
			for(int i=1;i<n;i++)
			{
				//DP
				seq = genNextSequence(seq);
			}
		 	return seq;
	    }
	 public String genNextSequence(String num)
	 {
		 	int[] count = new int[10];
	        String seq = new String();
	        int i=0;
	        while(i<num.length())
	        {
	        	char curr = num.charAt(i);
	        	int curr1 = Integer.parseInt(String.valueOf(curr));
	        	char next = '\0';
	        	if(i+1<num.length())
	        	{
	        		next = num.charAt(i+1);
	        	}
	        	//keep counting till curr char is same as next
	            if(curr == next)
	            {
	                count[curr1]=count[curr1]+1;
	            }
	            else
	            {
	            	//if curr char is not the same as next
	            	//update the string
	            	count[curr1]=count[curr1]+1;
	                if(count[curr1]>1)
	                {
	                    seq=seq+count[curr1]+curr1;
	                }
	                else
	                {
	                	//if singular or just one number
	                    seq=seq+("1"+curr1);
	                }
	                //update the char value
	                count[curr1]=0;
	            }
	            i++;
	        }
	        return seq;    
	 }
	 /*---------------------------58. LENGTH OF THE LAST WORD------------------------*/
	 public int lengthOfLastWord(String s) {
	        s= s.trim();
	        int count=0, temp=0;
	        int i = s.length()-1;
	        if(i>=0)
	        {
	        	//start from the last character
		        while(i>=0)
		        {
		        	if(s.charAt(i)==' ')
		        	{
		        		temp=count;
		        		break;
		        	}
		        	count++;
		            i--;
		        }
	        }
	        return temp = (temp>0)?temp:count;
	}
	
	
	/*----------------------------6. ZIGZAG CONVERSION------------------------------*/
	 //"PAYPALISHIRING"
	 //P   A   H   N
	 //A P L S I I G
	 //Y   I   R
	 //output: "PAHNAPLSIIGYIR"
	 //pattern is for numRows 3 is 4, 2, 4
	public String convert(String s, int numRows) {
        //initialize
		if(numRows==1) return s;
		String seq = new String();
    	//first row
    	int k=(numRows-1)*2;
		int j=0;
    	while(j<s.length())
    	{
    		seq=seq+s.charAt(j);
    		j=j+k;
    	}
    	//middle rows
    	k=(numRows-1)*2;
    	int p1=k; int p2=0; int l=0;
    	for(int i=1; i<numRows-1;i++)
        {
    			//create 2 partitions
    			p1=p1-2;p2=p2+2;
    			j=i;l=0;
    			while(j<s.length())
    			{
    				seq=seq+s.charAt(j);
    				l++;
    				j=l%2==1?j+p1:j+p2;
    			}
        }	
    	//lastrow
    	k=(numRows-1)*2;
		j=numRows-1;
    	while(j<s.length())
    	{
    		seq=seq+s.charAt(j);
    		j=j+k;
    	}
        return seq;
    }
    public int[] updateArray(int len, int row, int numRows)
    {
    	//get the value to be incremented;
    	int k=row==0||row==numRows-1?(numRows-1)*2:2;
    	//get the size of the array
    	int size=len/k;
    	//initialize array
    	int[] array = new int[size+1];
    	//intialize first value
    	array[0]=row;
    	
        for(int i=1; i<array.length;i++)
        {
           if(row==0 || row==numRows-1)
           {
               array[i]=array[i-1]+(numRows-1)*2;
           }
           else
           {
        	   k=row%2==0&&i%2==0?k+4:k+2;
        	   array[i]=array[i-1]+k;            
           }
        }
        
        return array;
    }
    /*---------------8. STRING TO INTEGER (ATOI)----------------------------*/
    public int myAtoi(String str) {
        
    	str = str.trim();
        if(str.length()==0) return 0;
        
        int sign=1;
        boolean posSign=false;
        int j=0;
        //first identify the sign
        if(str.charAt(0)=='-') {sign=-1;j=1;}
        if(str.charAt(0)=='+') {sign=1;j=1;}
        
        //then compute the integer
        long n=0,i=str.length()-1;
        while(j<str.length())
        {
        	if(!(str.charAt(j)>='0' && str.charAt(j)<='9'))
        	{
        		return (int) ((int) sign*n);
        	}
        	n= n*10 + str.charAt(j)-'0';
        	
        	 if(sign*n>Integer.MAX_VALUE)
             {
                 return Integer.MAX_VALUE;
             }
             if(sign*n<Integer.MIN_VALUE)
             {
                 return Integer.MIN_VALUE;
             }
            j++;
        }
     return (int) ((int) sign*n);      
    }
    //naive method of finding substring
	//O(mn)
	public int strStr1(String haystack, String needle) {
	        
	        haystack = haystack.trim();
	        needle = needle.trim();
	        if(haystack.length()==0 && needle.length()==0) return 0;
	        if(haystack.length()> 0 && needle.length()==0) return 0;
	        
	        //haystack.
	        int i=0, j=0; int count=0; int index=0;
	        while(i<haystack.length())
	        {
	        	index=0;
	        	if(j<needle.length())
	        	{
		            if(haystack.charAt(i) == needle.charAt(j))
		            {
		                        index=i;
		                        while(j<needle.length())
		                        {
		                        	if(i<haystack.length())
		                        	{
			                            if(haystack.charAt(i) == needle.charAt(j))
			                            {
			                                count++;
			                            }
		                        	}
		                        	j++; i++;
		                        }
		                        if(count==needle.length())
		                        {
		                            return index;
		                        }
		                        else
		                        {
		                        	i=index;
		                        }
		                        
		            }
	        	}
	            
	            i++;
	            j=0;
	            count=0;
	        }
	        
	        return -1;
	    }
	/*----------------------------------28. IMPLEMENT strSTR()-----------------------------------*/
    //finding substring using KMP algorithm
	//O(m+n)
	public int strStr(String haystack, String needle) {
		if(haystack.length()==0 && needle.length()==0) return 0;
        if(haystack.length()> 0 && needle.length()==0) return 0;
		//compute the prefix array
		int[] prefixArray = computePrefixArray(needle);
		//search the haystack using the prefix array to determine a match
		int i=0; int j=0;
		while(i<haystack.length() && j<needle.length())
		{
			//start comparing haystack with needle, for every character matched increment i and j
			if(haystack.charAt(i) == needle.charAt(j))
			{
				
				i++; j++;
				if(j==needle.length())
				{
					return i-j;//return the index of the first occurence
				}
			}
			else
			{
				if(j!=0)
				{
					j=prefixArray[j-1];
				}
				else
				{
					i++;
				}
			}
		}
		return -1;
	}
	public int[] computePrefixArray(String needle)
	{
		int[] array = new int[needle.length()];
		int index=0;//first element is 0
		for(int i=1; i<needle.length();)
		{
			if(needle.charAt(i) == needle.charAt(index))
			{
				array[i]=index+1;
				index++;
				i++;
			}
			else
			{
				if(index!=0)
				{
					if(index-1>=0)
					{
						index = array[index-1];
					}
				}
				else
				{
					array[i]=0;
					i++;
				}
			}
		}
		
		return array;
	}
	/*--------------------------------------------REVERSE A STRING----------------------------------------*/    
	    public String reverse(String str)
	    {
	    	char[] array = str.toCharArray();
	    	int i=0;
	    	int j=str.length()-1;
	    	while(i<j)
	    	{
	    		char temp=array[i];
	    		array[i]=array[j];
	    		array[j]=temp;
	    		i++;
	    		j--;
	    	}
	    	return new String(array);
	    }
	
	    /*------------------------------43. MULTIPLY STRINGS-----------------------------*/
	    public String multiply1(String num1, String num2)
	    {
	    	int len1=num1.length();
	    	int len2=num2.length();
	    	int[] array = new int[len1+len2];
	    	int sum=0, mul=0;
	    	for(int i=len1-1; i>=0;i--)
	    	{
	    		for(int j=len2-1; j>=0;j--)
	    		{
	    			//last but 1 digit
	    			int p1=i+j;
	    			//last digit
	    			int p2=i+j+1;
	    			
	    			mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
	    			
	    			sum = mul + array[p2];
	    			
	    			//carry over
	    			array[p1]+=sum/10;
	    			//last digit
	    			array[p2]=sum%10;
	    		}
	    	}
	    	
	    	StringBuilder sb = new StringBuilder();
	        for(int p : array) 
	        	if(!(sb.length() == 0 && p == 0)) 
	        		sb.append(p);
	        return sb.length() == 0 ? "0" : sb.toString();
	    }
	    
	    /*--------------------------3. LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS-----------------------------*/
	    //length of the longest substring without duplicates
	    public int lengthOfLongestSubstring(String s) {
	    	if(s.length()==0) return 0;
	        if(s.length()==1) return 1;
	        ArrayList<String> array = new ArrayList<String>();
	        int max=0;
	        int slow=0; int fast=0;
	        while(fast<s.length())
	        {
	        	if(!array.contains(String.valueOf(s.charAt(fast))))
	        	{
	        		array.add(String.valueOf(s.charAt(fast)));
	        		max = Math.max(max,array.size());
	        		fast++;
	        	}
	        	else
	        	{
	        			array.remove(String.valueOf(s.charAt(slow)));
	        			slow++;
	        	}
	        }
	        return max;
	    }
	    
	    /*-----------------------93. RESTORE IP ADDRESSES-----------------------------*/
	    public List<String> restoreIpAddresses(String s) {
	    	List<String> res=new ArrayList<String>();
	    	
	    	//need to construct 4 strings: s1, s2, s3, s4
	    	//s1 starts from 0
	    	//s2 ranges from 1 till len-2
	    	for(int i=1; i<4 && i<s.length()-2;i++)
	    	{
	    		//s3 starts from 2 till len-1
	    		for(int j=i+1; j<i+4 && j<s.length()-1;j++)
	    		{
	    			//s4 starts from 3 till len
	    			for(int k=j+1; k<j+4 && k<s.length();k++)
	    			{
	    				//construct strings
	    				String s1=s.substring(0,i);
	    				String s2=s.substring(i,j);
	    				String s3=s.substring(j,k);
	    				String s4=s.substring(k,s.length());
	    				
	    				//check if all the strings are valid
	    				//if yes return a possible IP Address
	    				if(valid(s1) && valid(s2) && valid(s3) && valid(s4))
	    				{
	    					res.add(s1+"."+s2+"."+s3+"."+s4);
	    				}
	    			}
	    		}
	    	}
	        return res;
	    }
	    public boolean valid(String str)
	    {
	    	if(str.length()>3 || str.length()==0|| (str.charAt(0)=='0' && str.length()>1) || Integer.parseInt(str)>255)
	    		return false;
	    	return true;
	    }
	    //naive solution or brute force
	    
	    public boolean validPalindrome(String str) {
			int i=0, j=str.length()-1;
			while(i<j)
			{
				if(str.charAt(i)!=str.charAt(j))
				{
					return false;
				}
				i++;
				j--;
			}
		
			return true;
		}
	   
	    /*---------------------------5. LONGEST PALINDROMIC SUBSTRING----------------------------*/
	    public String longestPalindrome(String s) {
	    	if(s.length()==1) return s;
	    	
	    	String longest = new String();
	    	int max=0;
	    	
	    	for(int i=0; i<s.length()-1; i++)
	    	{
	    			//construct a string with odd length
	    			String str = validPalindrome(s,i,i);
	    			//check if it's palindrome
	    				if(str.length()>max)
		    			{
		    				max=str.length();
		    				longest=str;
		    			}
	    			
	    			//construct a string with even length
	    			String str1=validPalindrome(s,i,i+1);
	    			//check if it's palindrome
    				if(str1.length()>max)
	    			{
	    				max=str1.length();
	    				longest=str1;
	    			}
	    	}
	    	
	    	return longest;
	    }
	    //start every string at one index and keep extending left and right to check if it's a palindrome, if yes
	    //return the string 
	    public String validPalindrome(String str, int left, int right) {
		while(left>=0 && right <str.length() && str.charAt(left)==str.charAt(right))
		{
			left--;//extend left
			right++;//extend right
		}
		return str.substring(left+1,right);
	}
	    
	    /*----------------------------17. LETTER COMBINATIONS OF A PHONE NUMBER----------------------------------*/
	    public List<String> letterCombinations(String digits) {
	        List<String> res = new ArrayList<String>();
	        
	        //store mobile nos and their digits
	        Map<String, String> mobile=new HashMap<String, String>();
	        mobile.put("1","");mobile.put("2","abc");mobile.put("3","def");
	        mobile.put("4","ghi");mobile.put("5","jkl");mobile.put("6","mno");
	        mobile.put("7","pqrs");mobile.put("8","tuv");mobile.put("9","wxyz");
	        
	        String[] array= new String[1];
	        array[0]="";
	        for(int i=0; i<digits.length();i++)
	        {
	            String digit1=String.valueOf(digits.charAt(i));
	            array =generateCrossProduct(array, mobile.get(digit1));  
	        }
	        if(array.length==1 && array[0]=="")	return res;
	        
	        
	        for(int j=0; j<array.length;j++) 
            {
                res.add(array[j]);
            }
	        
	        return res;
	    }
	    
	    public String[] generateCrossProduct(String [] array, String alpha)
	    {
	    		
	    		int size = array.length * alpha.length();
	    		String[] array1 = new String[size];
	    		int index=0;
	            for(int i=0; i<alpha.length();i++) 
	                {
	                    for(int j=0; j<array.length;j++) 
	                    {
	                        array1[index] = String.valueOf(array[j]+alpha.charAt(i));
	                        index++;
	                    }
	                }
	        return array1;
	    }
	    
	    /*49. ------------------GROUP ANAGRAM---------------------------*/
	    public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> array = new ArrayList<List<String>>();
	        Map<String, List<String>> groups = new HashMap<String, List<String>>();
	        
	        //sort the array containing strings
	        Arrays.sort(strs);
	        for(int i=0; i<strs.length; i++)
	        {
	        	//get the key for each group..a group of anagram have the same key when sorted
	            String key = getKey(strs[i]);
	            if(!groups.containsKey(key))
	            {
	            	//create a new group
	                List<String> group = new ArrayList<String>();
	                group.add(strs[i]);
	                groups.put(key, group);
	            }
	            else
	            {
	            	//add to the existing group
	            	List<String> group = groups.get(key);
	                group.add(strs[i]);
	                groups.replace(key, group);
	            }
	        }
	        //put all hashtable elements to the array
	        Iterator it = groups.entrySet().iterator();
	        while(it.hasNext())
	        {
	            Map.Entry pair = (Map.Entry)it.next();
	            List<String> group = (List<String>) pair.getValue();
	            array.add(group);
	        }
	        
	        return array;
	    }
	    //create a key for a group by sorting the elements
	    public String getKey(String str)
	    {
	    	char[] c=str.toCharArray();
	    	Arrays.sort(c);
	    	return String.valueOf(c);
	    }
	    
	    /*------------------151. REVERSE WORDS IN A STRING-----------------------*/
	    public String reverseWords(String s) {
	    	s =s.replaceAll("\\s+", " ").trim();
	    	
	        if(!s.contains(" ") || s.length()==0 ) return s;
	        
	        String snew=new String("");
	        s = reverse(s);
	        int i=0; int j=0;//using slow and fast pointers get a word from the reversed string
	        while(i<s.length() && j<s.length())
	        {
	           if(s.charAt(j)==' ')
	           {
	                String s1 = s.substring(i,j);
	                s1 = reverse(s1);
	                snew = snew+s1+s.charAt(j);
	                i=j+1;
	                
	           }
	           if(j==s.length()-1)
	           {
	        	   String s1 = s.substring(i,j+1);
	               s1 = reverse(s1);
	               snew = snew+s1;
	           }
	           j++;
	        }
	        
	        return snew;
	    }
	    /*-----------------------72. EDIT DISTANCE---------------------------*/
	    public int minDistance(String word1, String word2) {
	        int len1 = word1.length();
	        int len2 = word2.length();
	        int minD=0;
	        int min=0;
	        int[][] d=new int[len1+1][len2+1];
	        d[0][0]=0;
	        //initialize rows
	        for(int i=1; i<len1+1;i++)
	        {
	            d[i][0]=i;
	        }
	        //initialize columns
	        for(int j=1; j<len2+1;j++)
	        {
	            d[0][j]=j;
	        }
	        
	        for(int i=1; i<len1+1;i++)
	        {
	            for(int j=1; j<len2+1;j++)
	            {
	                if(word1.charAt(i-1)==word2.charAt(j-1))
	                {
	                	//diagnoal
	                    d[i][j]=d[i-1][j-1];
	                }
	                else
	                {
	                	min =0;
	                	//check the min from left, top, and diag
	                	//increment min by 1
	                	min = Math.min(d[i-1][j],d[i][j-1]);
	                	min = Math.min(min,d[i-1][j-1]);
	                    d[i][j] = min+1;
	                }
	            }
	        }
	        
	        minD=d[len1][len2];
	        
	        return minD;
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
		//System.out.println(obj.longestPalindrome("abaaaabaa"));
		//System.out.println(obj.countAndSay(3));
		//System.out.println(obj.lengthOfLastWord("a"));
		//System.out.println(obj.convert("ABCDE", 4));
		//System.out.println(obj.strStr("abxabcabcaby","abcaby"));
		System.out.println(obj.multiply1("43","69"));
		//System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
		//String s=new String("010010");
		//System.out.println(obj.restoreIpAddresses(s));
		//System.out.println(obj.longestPalindrome("abaaaabaa"));
		//System.out.println(obj.letterCombinations("234"));
		//String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
		//System.out.println(obj.groupAnagrams(strs));
		//System.out.println(obj.reverseWords("  a  b "));
		//System.out.println(obj.minDistance("sunday", "saturday"));
		
		
	}
}