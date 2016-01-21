
public class LinkedListProblems {
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

}
