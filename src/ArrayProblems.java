import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ArrayProblems {
	
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
}
