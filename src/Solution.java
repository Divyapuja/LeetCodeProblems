import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
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
	
	public static void moveZeroes(int[] nums) {
		int j = 0;
	    for(int i = 0; i < nums.length; i++) {
	        if(nums[i] != 0) {
	            int temp = nums[j];
	            nums[j] = nums[i];
	            nums[i] = temp;
	            j++;
	        }
	    }
    }
	
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
	
	 public static int majorityElement(int[] nums) {
	     int elem=0;
	     int oldVal =0;
	     int newVal =0;
	     HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	     
	     for(int i=0;i<nums.length;i++)
         {
	    	 if(hmap.get(nums[i])!=null)
	    	 {
	    			 oldVal = hmap.get(nums[i]);
	    			 newVal = oldVal+1;
	    			 hmap.replace(nums[i], oldVal, newVal);
	    			  
	    			 if(newVal > nums.length/2)
	    			 {
	    				elem = nums[i];
	    				return elem;
	    			 }
	    	 }
	    	 else
	    	 {
	    		 hmap.put(nums[i], 1);
	    		 elem = nums[i];
	    	 }
         }
	     
	     return elem;
		 
	    }
	
	 public static boolean containsDuplicate(int[] nums) {
        
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
            for(int i=0;i<nums.length;i++)
            {
                if(hmap.get(nums[i]) !=null)
                {
                    if(hmap.get(nums[i])>0)
                    {
                        return true;
                    }
                    else
                    {
                    	int oldValue = hmap.get(nums[i]);
                    	hmap.replace(nums[i], oldValue, oldValue+1);
                    }
                }
                else
                {
                	hmap.put(nums[i], 1);
                }
            }
        
		return false;
    }
	public boolean containsDuplicate1(int[] nums) {
	    
		List<Integer> newObj= new ArrayList<Integer>();
		
	   for(int i=0; i<nums.length; i++)
	   {
		    newObj.add(nums[i]);
	   }
	   Set<Integer> hashSetList = new HashSet<Integer>(newObj);
	   if(hashSetList.size() != nums.length)
	   {
		   return true;
	   }
	   return false;
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
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
				if(root == null)
				{
					return null;
				}
				else if(p.val < root.val && q.val < root.val)
		 		{
		        return lowestCommonAncestor(root.left,p,q);
		        }
		        else if(p.val > root.val && q.val > root.val)
		        {
		        return lowestCommonAncestor(root.right,p,q);
		        }
		        else
		        {
		        return root;
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
	 public static ListNode reverseList(ListNode head) {
		    ListNode prev = null;
		 	ListNode temp = null;
		 	if(head == null)
		 	{
		 	    return null;
		 	}
		 	while(head.next!=null)
	    	{
	    		temp = head;
	    		head = head.next;
	    		temp.next = prev;
	    		prev=temp;
	        }
		 	head.next = prev;
		 	return head;
	    	
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
	 
	 public static ListNode deleteDuplicates(ListNode head) {

		 if(head == null)
		 {
			 return null;
		 }
		 ListNode origHead = head;
		 while(head.next != null)
		 {
			 	 if(head.val == head.next.val)
				 {
					 head.next = head.next.next;
				 }
				 else
				 {
					 head = head.next;
				 }
			 
			
			 //head = head.next;
		 }
		 return origHead;
	    }
	 public boolean isPowerOfThree(int n) {
		 double num = Math.log(n)/Math.log(3);
	        return Math.abs(num - Math.round(num)) <=10e-15;
	        
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
	 
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 
		 	ListNode tempOrig1 = l1;
		 	ListNode tempOrig2 = l2;
		 	if(l1 == null && l2!=null)
	        {
	            return l2;
	        }
	        else if(l1 != null && l2==null)
	        {
	            return l1;
	        }
	        else if(l1 == null && l2==null)
	        {
	        	
	        	return null;
	        }
	        else
	        {
	        	while(l1!=null)
	        	{
	        		if(l1.next != null && l2!=null)
	        		{
	        			if(l1.val <=l2.val && l2.val<=l1.next.val)
	        			{
	        				ListNode temp = new ListNode(l2.val);
	        				ListNode temp1 = l1.next;
	        				l1.next = temp;
	        				temp.next = temp1;
	        				l2 = l2.next;
	        			}
	        		}
	        		else
	        		{
	        			if(l2 !=null)
	        			{
		        			if(l1.val <l2.val)
		        			{
		        				l1.next = l2;
		        				return tempOrig1;
		        			}
	        			}
	        			else
	        			{
	        				return tempOrig1;
	        			}
	        			
	        		}
	        		l1=l1.next;
	        	}
	        	l1 = tempOrig1;
	        	while(l2!=null)
	        	{
	        		if(l2.next != null && l1!=null)
	        		{
	        			if(l2.val <=l1.val && l1.val<=l2.next.val)
	        			{
	        				ListNode temp = new ListNode(l1.val);
	        				ListNode temp1 = l2.next;
	        				l2.next = temp;
	        				temp.next = temp1;
	        				l1 = l1.next;
	        			}
	        		}
	        		else
	        		{
	        			if(l1!=null)
	        			{
		        			if(l2.val <l1.val)
		        			{
		        				l2.next = l1;
		        				return tempOrig2;
		        			}
	        			}
	        			else
	        			{
	        				return tempOrig2;
	        			}
	        			
	        		}
	        		l2=l2.next;
	        	}
	        }
	        
	        
	        return null;
	    } 
	 
	 public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		 	if (l1 == null) return l2;
		    if (l2 == null) return l1;
		    
		    ListNode head = l1.val < l2.val ? l1 : l2;
		    ListNode nonHead = l1.val < l2.val ? l2 : l1;

		    head.next = mergeTwoLists1(head.next, nonHead);

		    return head;
	 }
	 
	 public static boolean isPowerOfTwo(int n) {
		 double num = Math.log(n)/Math.log(2);
	        return Math.abs(num - Math.round(num)) <=10e-15;
	        
	    }
	 
	public static void main(String args[])
	{
		int[] nums={1,2,2,3};
		
		//moveZeroes(nums);
		//System.out.println(nums[2]);
		
		//String s="Anagram";
		//String t="nag1r1m";
		
		//Set<Integer> hashsetlist = new HashSet<Integer>(nums);
		
		//System.out.println(isAnagram1(s,t));
	
		//System.out.println(containsDuplicate(nums));
		
		//System.out.println(titleToNumber("ZZZ") );
		//System.out.println(majorityElement(nums));
		//System.out.println(hammingWeight(3));
		//System.out.println(romanToInt("MMMM"));
		
		/*ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(2);
		ListNode head4 = new ListNode(3);
		head.next = head1;
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		head4.next = null;
		
		
		ListNode newHead =deleteDuplicates(head); 
		for(ListNode p=newHead;p!=null;p=p.next)
		{
			System.out.println(p.val);
		}*/
		//System.out.println(climbStairs1(1));
		//System.out.println(isHappy(7));
		/*ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(5);
		ListNode head3 = new ListNode(7);
		head1.next=head2;
		head2.next=head3;
		head3.next=null;
		
		ListNode tail1 = new ListNode(1);
		ListNode tail2 = new ListNode(4);
		ListNode tail3 = new ListNode(6);
		tail1.next=tail2;
		tail2.next=tail3;
		tail3.next=null;
		
		
		ListNode newHead =mergeTwoLists1(head1,tail1); 
		for(ListNode p=newHead;p!=null;p=p.next)
		{
			System.out.println(p.val);
		}*/
		System.out.println(isPowerOfTwo(8));
	}
}
