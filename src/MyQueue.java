import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class MyQueue {
	//List<Integer> stack=new ArrayList<Integer>();
    // Push element x to the back of queue.
	
	Stack<Integer> st1= new Stack<Integer>();
	Stack<Integer> st2= new Stack<Integer>();
	
    public void push(int x) {
    	st1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(st1.empty())
    	{
    		return;
    	}
        if(st2.isEmpty())
        {
        	//push all members from st1 to st2
        	while(st1.empty()!=true)
        	{
        		st2.push(st1.pop());
        	}
        	//remove the top member
        	if(st2.empty()!=true)
        	{
        		st2.pop();
        	}
        	//push all members from t2 to t1
        	while(st2.empty()!=true)
        	{
        		st1.push(st2.pop());
        	}
        }
    }

    // Get the front element.
    public int peek() {
    	if(st1.empty())
    	{
    		return 0;
    	}
    	int val=0;
        if(st2.isEmpty())
        {
        	//push all members from st1 to st2
        	while(st1.empty()!=true)
        	{
        		st2.push(st1.pop());
        	}
        	//remove the top member
        	if(st2.empty()!=true)
        	{
        		
        		val= st2.peek(); 
        	}
        	//push all members from t2 to t1
        	while(st2.empty()!=true)
        	{
        		st1.push(st2.pop());
        	}
        }
        return val;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(st1.isEmpty())
        {
        	return true;
        }
        return false;
    }
    
    public static void main(String args[])
    {
    	MyQueue obj=new MyQueue();
    	
    	obj.push(1);
    	obj.push(2);
    	obj.push(3);
    	
    	/*for(int i=0; i<obj.stack.size();i++)
    	{
    		System.out.println(obj.stack.get(i));
    	}
    	
    	obj.pop();
    	obj.pop();
    	
    	for(int i=0; i<obj.stack.size();i++)
    	{
    		System.out.println(obj.stack.get(i));
    	}*/
    	System.out.println(obj.peek());
    	
    	obj.pop();
    	for(int i=0; i<obj.st1.size();i++)
    	{
    		System.out.println(obj.st1.get(i));
    	}
    	System.out.println(obj.empty());
    	
    }
}
