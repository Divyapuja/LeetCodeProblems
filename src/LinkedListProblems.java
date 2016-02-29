
public class LinkedListProblems {
	
	/*----------206. REVERSE LINKED LIST------------------------*/
	public  ListNode reverseList(ListNode head) {
		//create a prev node
	    ListNode prev = null;
	 	ListNode temp = null;
	 	if(head == null)
	 	{
	 	    return null;
	 	}
	 	//make all pointers toward prev node
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
	/*----------83. REMOVE DUPLICATES FROM SORTED LIST-------------------*/
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
	
		 /*-----------------------------234. PALINDROME LINKED LIST----------------------------*/
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
	        	
	        	//mid can also be found using slow and fast pointers 
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
		        
		        //get to the middle and then reverse the linked list
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
	 
	 /*-----------------160. INTERSECTION OF TWO LINKED LISTS--------------------------*/
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA == null || headB == null){return null;}
	        
	        int sizeA = returnSize(headA);
	        int sizeB = returnSize(headB);
	        int min = Math.min(sizeA, sizeB);
	        
	        ListNode tempNodeA = headA;
	        ListNode tempNodeB = headB;
	        
	        //find the min of thw two linkedList
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
	        //once the min is find, do the iteration to find the intersection
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
	    /*----------------141. LINKED LIST CYCLE----------------------*/
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
	    /*----------------------SORTING A LINKED LIST---------------------*/
	    public ListNode sortList(ListNode head)
	    {
	        if(head == null || head.next == null) return head;
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast.next!=null && fast.next.next!=null)
	        {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode slowNext = slow.next;
	        slow.next = null;
	        
	        //divide the list into two parts recursively
	        //start till mid
	        ListNode node1 = sortList(head);
	        //mid to till last
	        ListNode node2 = sortList(slowNext);
	        //start merging
	        return merge(node1, node2);
	    }
	    
	    /*---------------------------------21. MERGE TWO SORTED LISTS--------------------*/
	    public ListNode merge(ListNode node1, ListNode node2)
	    {
	    	//take a node head
	    	ListNode head = new ListNode(0);
	    	ListNode curr = head;
	    	while(node1 !=null && node2!=null)
	    	{
	    		//if node1 is less than node2 append it to curr
	    		if(node1.val < node2.val)
	    		{
	    			curr.next = node1;
	    			node1 = node1.next;
	    		}
	    		else
	    		{
	    			//if node2 is less than node1, append it to curr
	    			curr.next = node2;
	    			node2 = node2.next;
	    		}
	    		curr = curr.next;
	    	}
	    	//traverse node1 since node2 is completed
	    	if(node1 != null) curr.next = node1;
	    	//traverse node2 since node1 is completed
	        if(node2 != null) curr.next = node2;
	    	return head.next;
	    }
	    
	    public ListNode rotateRight(ListNode head, int k) {
	        
	        int length =0;
	        ListNode tempHead = head;
	        while(tempHead!=null)
	        {
	        	tempHead = tempHead.next;
	            length++;
	        }
	        int rSize = length+k;
	        
	        //connect head with tail
	        ListNode tempHead1=head;
	        ListNode tempHead2=head;
	        while(tempHead1!=null && tempHead1.next!=null)
	        {
	        	tempHead1 = tempHead1.next;
	        }
	        if(tempHead1!=null)
	        {
	        	tempHead1.next = tempHead2;
	        }
	        
	        for(int i=0; i<rSize-1;i++)
	        {
	        	tempHead2 = tempHead2.next;
	        }
	        ListNode tempHead3= tempHead2.next;
	        ListNode tempHead4= tempHead2.next;
	        for(int i=0; i<length-1;i++)
	        {
	        		tempHead3 = tempHead3.next;
	        }
	        if(tempHead3!=null)
	        {
	        	tempHead3.next = null;
	        }
	        
	        head=tempHead4;
	        
	        
	        return head;
	    }
	
		
	  
	    
	 public static void main(String args[])
	 {
		 	LinkedListProblems obj = new LinkedListProblems();	
		 
		 	ListNode head = new ListNode(1);
			ListNode head1 = new ListNode(2);
			ListNode head2 = new ListNode(3);
			ListNode head3 = new ListNode(4);
			ListNode head4 = new ListNode(5);
			head.next = head1;
			head1.next=head2;
			head2.next=null;
			head3.next=head4;
			head4.next = null;
			
			//head = obj.sortList(head);
			head = obj.rotateRight(head, 2);
			while(head!=null)
			{
				System.out.println(head.val);
				head=head.next;
			}
			//System.out.println(obj.sortList(head));
	 }
}
