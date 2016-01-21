import java.util.Arrays;
import java.util.HashMap;


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
}
