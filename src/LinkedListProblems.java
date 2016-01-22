
public class LinkedListProblems {
	public  ListNode reverseList(ListNode head) {
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
	
	public ListNode deleteDuplicates(ListNode head) {

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
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 
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
 
	 public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		 	if (l1 == null) return l2;
		    if (l2 == null) return l1;
		    
		    ListNode head = l1.val < l2.val ? l1 : l2;
		    ListNode nonHead = l1.val < l2.val ? l2 : l1;
	
		    head.next = mergeTwoLists1(head.next, nonHead);
	
		    return head;
	 }
	 
	 public boolean isPalindrome(ListNode head) {
	        	if(head == null || head.next == null)
	        	{
	        		return true;
	        	}
	        	ListNode temp=head;
	        	int size=0;
	        	while(temp!=null)
	        	{
	        		temp=temp.next;
	        		size++;
	        	}
	        	int mid = size/2;
	        	
	        	/*if(size%2 == 0)
	        	{
	        		mid=mid-1;;
	        	}*/
	        	
	        	ListNode rHead=null;
		        temp = head;
		        int i=0;
		        while(temp!=null)
		        {
		        	if(i<mid)
		        	{
		        		rHead=temp;
		        	}
		        	temp=temp.next;
		        	i++;
		        }
		        
		        
		        rHead = reverseList(rHead);
		        
		        while(head!=null && rHead!=null)
		        {
		        	if(head.val != rHead.val)
		        	{
		        		return false;
		        	}
		        	head = head.next;
		        	rHead = rHead.next;
		        	
		        }
	        return true;
	 }
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA == null || headB == null){return null;}
	        
	        int sizeA = returnSize(headA);
	        int sizeB = returnSize(headB);
	        int min = Math.min(sizeA, sizeB);
	        
	        ListNode tempNodeA = headA;
	        ListNode tempNodeB = headB;
	        
	        
	        while(sizeA-- > min)
	        {
	        	if(tempNodeA!=null)
		        {
	        		tempNodeA = tempNodeA.next;
	        		
		        }
	        }
	        
	        while(sizeB-- > min)
	        {
	        	if(tempNodeB!=null)
	        	{
	        		tempNodeB = tempNodeB.next;
	        	}
	        }
	        while(tempNodeA!=null)
	        {
	        	if(tempNodeA == tempNodeB) return tempNodeA;
	        	tempNodeA = tempNodeA.next;
	        	tempNodeB = tempNodeB.next;
	        }
	         return null;
	    }
	 public int returnSize(ListNode head)
	 {
		 if(head == null){return 0;}
		 int size=0;
		 while(head!=null)
	     {
	            head = head.next;
	            size++;
	     }
		 
		 return size;
	 }
	 
	    public int returnLastElement(ListNode head)
	    {
	        if(head == null){return 0;}
	        while(head!=null)
	        {
	            if(head.next == null)
	            {
	                return head.val;
	            }
	            head = head.next;
	        }
	        
	        return 0;
	    }
	 
	    public boolean hasCycle(ListNode head) {
	    	if(head == null || head.next == null){return false;}
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        while(fast!=null && fast.next!=null)
	        {
	        	slow = slow.next;
	            fast = fast.next.next;
	        	if(slow == fast)
	            {
	                return true;
	            }
	        	
	        	
	        }
	        
	        return false;
	    }
	 public static void main(String args[])
	 {
		 	LinkedListProblems obj = new LinkedListProblems();	
		 
		 	ListNode head = new ListNode(1);
			ListNode head1 = new ListNode(2);
			ListNode head2 = new ListNode(3);
			ListNode head3 = new ListNode(-4);
			ListNode head4 = new ListNode(5);
			head.next = head1;
			head1.next=head2;
			head2.next=head3;
			head3.next=head4;
			head4.next = null;
			
			ListNode tail = new ListNode(12);
			tail.next = null;
			//tail1.next=head4;
			
			System.out.println(obj.hasCycle(head));
	 }
}
