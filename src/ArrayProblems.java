import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;


public class ArrayProblems {
	
	public void moveZeroes(int[] nums) {
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
	public int majorityElement1(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length / 2];
	}
	public int majorityElement2(int[] nums) {
	    int majority = nums[0], t = 0;
	    for (int i : nums) {
	        if (i == majority) 
	            ++t;
	        else if (t > 0)
	            --t;
	        else {
	            majority = i;
	            t = 1;
	        }
	    }
	    return majority;
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
	public static boolean containsDuplicate2(int[] nums) {
		
		 HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		 for(int i=0;i<nums.length;i++)
         {
			 if(hmap.containsKey(nums[i]))
			 {
				 return true;
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
	
	//find if pair sums to 0
	public boolean twoSum(int[] nums)
	{
		Arrays.sort(nums);
		int low=0;
		int high = nums.length-1;
		
		while(low<high)
		{
			if(Math.abs(nums[low])<nums[high])
			{
				high--;
			}
			else if(Math.abs(nums[low])>nums[high])
			{
				low++;
			}
			else if(Math.abs(nums[low])==nums[high])
			{
				if(nums[low]+nums[high]==0)
				{
					return true;
				}
			}
			else
			{
				low++;
				high--;
			}
			
		}
		return false;
	}
	public int[] twoSum1(int[] nums, int target)
	{
		int [] array=new int[2];
		HashMap<Integer,Integer> lookup = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(lookup.containsKey(target-nums[i]))
			{
				array[0]=lookup.get(target-nums[i])+1;
				array[1]=i+1;
				return array;
			}
			lookup.put(nums[i], i);
		}
		return array;
	}
	public int[] plusOne(int[] digits) {
        if(digits.length>0)
        {
            int sum=0, carry=0;
            for(int i=digits.length-1; i>=0; i--)
            {
            	if(i==digits.length-1)
            	{
            		sum = carry+digits[i]+1;
            	}
            	else
            	{
            		sum = carry+digits[i];
            	}
                digits[i]=sum%10;
                carry = sum/10;
            }
            if(carry==0)
            {
                return digits;
            }
            else
            {
                int[] digits1=new int[digits.length+1];
                digits1[0]=carry;
                for(int i=0; i<digits.length-1; i++)
                {
                    digits1[i+1]=digits[i];
                }
                return digits1;
            }
        }
        
        return digits;
    }
	
	public void rotate(int[] nums, int k) {
        int index = 0;
        int distance = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++){
            int next = (index+k)%nums.length;
            int temp = nums[next];
            nums[next] = nums[cur];
            nums[cur] = temp;
            index = next;
            
            distance=(distance+k)%nums.length;
            if (distance == 0){
                index = (index+1)%nums.length;
                cur = index;
            }
            
            /*for(int j=0; j<nums.length;j++)
            {
            	System.out.print(nums[j]);
            }*/
            //System.out.println(", index="+index+", curr="+cur+", dist="+distance);
            
        }
        
    }
	//best solution for rotation
	public void rotate1(int[] nums, int k) {

	    if(nums == null || nums.length < 2){
	        return;
	    }

	    k = k % nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k-1);
	    reverse(nums, k, nums.length - 1);
	    

	}
	//reversing an array
	private void reverse(int[] nums, int i, int j){
	    int tmp = 0;       
	    while(i < j){
	        tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	        i++;
	        j--;
	    }
	}
	
	//remove elemenet and print the remaning content of the array
	public int removeElement(int[] nums, int val) {
        int lastIndex = nums.length - 1;

        for (int i = 0; i < lastIndex + 1; i++)
        {
            if (nums[i] == val)
            {
                nums[i] = nums[lastIndex];
                lastIndex--;
                i--;
            }
        }

        return lastIndex + 1;
    }
	public int removeDuplicates(int[] nums, int val) {
		
		
		return 0;
	}
	
	public int removeDuplicates(int[] nums) {
        int size=nums.length;
        int available =size;
        int i=0, j=1;
        while(i<size && j<size)
        {
            if(nums[i]==nums[j])
            {
                j++;
                available--;  
            }
            else
            {
                if(j-i>1)
                {
                    int temp=nums[i+1];
                    nums[i+1]=nums[j];
                    nums[j]=temp;
                }
                i++;
                j++;
            }
        }
        
        return available;
    }
	public List<String> summaryRanges(int[] nums) {
        List<String> summary=new ArrayList<String>();
        int size=nums.length;
        int i=0, j=1;
        int start=0;
        if(size ==1)
        {
        	summary.add(String.valueOf(nums[0]));
        	return summary;
        }
        if(size>1)
        {
        	start=nums[0];
        }
        while(i<size && j<size)
        {
            
            if(nums[j]-nums[i]==1)
            {
                if(j==size-1)
                {
                	summary.add(start+"->"+nums[j]);
                }
                i++;
                j++;
            }
            else
            {
            	if(start == nums[i])
            	{
            		summary.add(String.valueOf(start));
            	}
            	else
            	{
            		summary.add(start+"->"+nums[i]);
            	}
                start=nums[j];
                i=j;
                j++;	
            	
            	if(i==size-1)
                {
            		summary.add(String.valueOf(nums[i]));
                }
            }
        }
        
        
        return summary;
    }
	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
	        if(numRows-1>0 ||numRows==1)
	        {
	            List<Integer> row = new ArrayList<Integer>();
	            row.add(1);
	            pascal.add(row);
	        }
	        if(numRows-2>0 || numRows==2)
	        {
	            List<Integer> row = new ArrayList<Integer>();
	            row.add(1);
	            row.add(1);
	            pascal.add(row);
	        }
	        for(int i=2; i<numRows;i++)
	        {
	        	if(pascal.size()==i)
	        	{
	        		List<Integer> row = getNextRow(pascal.get(i-1));
	        		pascal.add(row);
	        	}
	        }
	        return pascal;
	    }
	    public List<Integer> getNextRow(List<Integer> row)
	    {
	    	int size=row.size();
	        List<Integer> next = new ArrayList<Integer>();
	        int i=0, j=1; 
	        next.add(row.get(0));
	        while(i<size && j<size)
	        {
	            if(j==size-1)
	            {
	            	next.add(row.get(i)+row.get(j));
	                next.add(row.get(j));
	            }
	            else
	            {
	                next.add(row.get(i)+row.get(j));
	            }
	            i++;
	            j++;
	        }
	        return next;
	    }
	    //row k of Pascal's Triangle:

	    //[C(k,0), C(k,1), ..., C(k, k-1), C(k, k)]

	    //and

	    //C[k,i] = C[k,i-1]*(k-i+1)/i

	    public List<Integer> getRow(int rowIndex) {
            Integer[] rowList = new Integer[rowIndex+1];
            rowList[0] = 1;
            for(int i=1; i<rowList.length;i++) {
                rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
            }
            return Arrays.asList(rowList);
        }
	    
	    public boolean containsNearbyDuplicate(int[] nums, int k) {
	    	int size = nums.length;
	    	Hashtable<Integer, Integer> store=new Hashtable<Integer, Integer>();  
	    	if(size>0)
	    	{
	    		for(int i=0; i<nums.length;i++)
	    		{
	    			if(store.containsKey(nums[i]))
	    			{
	    				//duplicate detected
	    				int j=store.get(nums[i]);
	    				if(i-j<=k)
	    				{
	    					return true;
	    				}
	    			}
	    				store.put(nums[i], i);
	    		}
	    	}
	    	return false;
	    }
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int i=m-1, j=n-1, k=1, l=m+n-1;;
	        
	        while(l>=0)
	        {
	        		if(i>=0 && j>=0)
	        		{
	        			if(nums1[i]>nums2[j])
		                {
		                    nums1[m+n-k]=nums1[i];
		                    k++;
		                    i--;
		                }
	        			else if(nums2[j]>nums1[i])
	        			{
		                    nums1[m+n-k]=nums2[j];
		                    k++;
		                    j--;
	        			}
	        			else
	        			{
	        				nums1[m+n-k]=nums2[j];
	        				k++;
	        				j--;
	        			}
	        		}
	        		else if(i>=0)
	        		{
	        			nums1[m+n-k]=nums1[i];
	        			k++;
	        			i--;
	        		}
	        		else if(j>=0)
	        		{
	        			nums1[m+n-k]=nums2[j];
	        			k++;
	        			j--;
	        		}
		             
	        	
	            l--;
	        }
	    }
	    public int uniquePaths(int m, int n) {
	        int [][] grid=new int[m][n];
	        for(int i=0;i<m;i++)
	        {
	        	for(int j=0;j<n;j++)
	        	{
	        		if(i==0||j==0)
	        			grid[i][j]=1;
	        		else
	        			grid[i][j]=grid[i-1][j]+grid[i][j-1];
	        	}
	        }
	        return grid[m-1][n-1];
	    }
	    
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    	
	    	int m=obstacleGrid.length;//row
	    	int n=obstacleGrid[0].length;
	    	int s[][]=new int[m][n];
	    	s[0][0]=obstacleGrid[0][0]==0? 1:0;
	    	for(int i=0;i<m;i++)
	    	{
	    		for(int j=0;j<n;j++)
	    		{
	    			if(obstacleGrid[i][j] == 1)
	    			{
	    				s[i][j]=0;
	    			}
	    			else if(i>0 && j==0)
	    			{
	    				s[i][0]=s[i-1][0];
	    			}
	    			else if(i==0 && j>0)
	    			{
	    					s[0][j]=s[0][j-1];
	    			}
	    			else if(i>0 & j>0)
	    			{	
	    					s[i][j]=s[i-1][j]+s[i][j-1];
	    			}
		    	}
	    	}
	    	
	    	
	    	return s[m-1][n-1];
	    }
	    public int minSubArrayLen(int s, int[] nums) {
	       int minLength = Integer.MAX_VALUE;
	       int left=0, right=0, slidingSum=0;
	       int size = nums.length;
	       
	       while(right<size)
	       {
	    	   if(slidingSum + nums[right] < s)
	    	   {
	    		   slidingSum += nums[right];
	    		   right++;
	    	   }
	    	   else
	    	   {
	    		   minLength = Math.min(minLength, right-left+1);
	    		   slidingSum -=nums[left];
	    		   left++;
	    	   }
	       }
	       
	       return minLength == Integer.MAX_VALUE? 0:minLength;
	    }
	    public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> threesumarray = new ArrayList<List<Integer>>();
	        int size=nums.length;
	        int low=0, mid=0, high=0;//three pointers
	        Arrays.sort(nums);
	        while(low<size)
	        {
	        	int target = 0-nums[low]; //reduce to twoSum problem
	        	if(low > 0 && nums[low] == nums[low-1]) low++;//skip duplicates
	        	
	        	mid = low+1; high=size-1;
		        	while(mid<high)
		        	{
		        		if(nums[mid]+nums[high] == target)
		        		{
		        			threesumarray.add(Arrays.asList(nums[low],nums[mid],nums[high]));
		        			while(mid<high && nums[mid]==nums[mid+1]) mid++;
		        			while(mid<high && nums[high]==nums[high-1]) high--;
		        			mid++; high--;
		        			
		        		}
		        		else if(nums[mid]+nums[high] < target)
		        		{
		        			mid++;
		        		}
		        		else
		        		{
		        			high--;
		        		}
		        	}
	        	low++;
	        }
	        return threesumarray;
	    }
	    public void setZeroes(int[][] matrix) {
	    	Hashtable<Integer,Integer> lookup=new Hashtable<Integer,Integer>();
	        int m=matrix.length;
	        int n=matrix[0].length;
	        int count =0;
	        for(int i=0; i<m; i++)
	        {
	            for(int j=0; j<n; j++)
	            {
	            	count++;
	                if(matrix[i][j]==0)
	                {
	                    lookup.put(count, 0);
	                }
	            }
	        }
	        count=0;
	        for(int i=0; i<m; i++)
	        {
	            for(int j=0; j<n; j++)
	            {
	            	count++;
	            	int tempi=i; int tempj=j;
	            	if(lookup.containsKey(count))
	            	{
		                if(lookup.get(count)==0)
		                {
		                    
		                    while(j+1<n)
		                    {
		                    	matrix[i][j+1]=0;
		                    	j++;
		                    }
		                    i=tempi; j=tempj;
		                    while(j-1>=0)
		                    {
		                    	matrix[i][j-1]=0;
		                    	j--;
		                    }
		                    i=tempi; j=tempj;
		                    while(i+1<m)
		                    {
		                    	matrix[i+1][j]=0;
		                    	i++;
		                    }
		                    i=tempi; j=tempj;
		                    while(i-1>=0)
		                    {
		                    	matrix[i-1][j]=0;
		                    	i--;
		                    }
		                }
	            	}
	            	i=tempi;
                    j=tempj;
	            }
	        }
	        
	    }
	    //put markers on first column and row
	    //check from next column and row
	    //put zeros accordingly
	    //if a zero is in 1st column or row convert row or column to zero 
	    public void setZeroes1(int[][] matrix) {
	        boolean fr = false,fc = false;
	        for(int i = 0; i < matrix.length; i++) {
	            for(int j = 0; j < matrix[0].length; j++) {
	                if(matrix[i][j] == 0) {
	                    if(i == 0) fr = true;
	                    if(j == 0) fc = true;
	                    matrix[0][j] = 0;
	                    matrix[i][0] = 0;
	                }
	            }
	        }
	        for(int i = 1; i < matrix.length; i++) {
	            for(int j = 1; j < matrix[0].length; j++) {
	                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        if(fr) {
	            for(int j = 0; j < matrix[0].length; j++) {
	                matrix[0][j] = 0;
	            }
	        }
	        if(fc) {
	            for(int i = 0; i < matrix.length; i++) {
	                matrix[i][0] = 0;
	            }
	        }
	    }
	    
	    public int searchInsert(int[] nums, int target) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }

	        return binarySearch(nums, 0, nums.length - 1, target);

	    }

	    private int binarySearch(int[] nums, int start, int end, int target) {
	        if(start > end){
	            return start;
	        }

	        int mid = (start + end) / 2;
	        if (nums[mid] == target) {
	            return mid;
	        } else if (nums[mid] > target) {
	            return binarySearch(nums, start, mid - 1, target);
	        } else {
	            return binarySearch(nums, mid + 1, end, target);
	        }
	    }
	    
	 public void sort(int []nums, int[] helper)
	 {
		 if(nums.length>0)
		 {
			 mergeSort(0, nums.length-1, nums, helper);
		 }
	 }
	 public void mergeSort(int low, int high, int [] nums, int[] helper)
	 {
		 if(low<high)
		 {
			 int mid = (low+high)/2;
			 //sort the left side
			 mergeSort(low, mid, nums, helper);
			 //sort the right side
			 mergeSort(mid+1, high, nums, helper);
			 //combine them both
			 mergeParts(low, mid, high, nums, helper);
		 }
	 }
	 public void mergeParts(int low, int mid, int high, int[] nums, int[] helper)
	 {
		 //copy both parts, i.e., low->middle, and middle+1->high to helper array
		 for(int i=low;i<=high;i++)
		 {
			 helper[i]=nums[i];
		 }
		 int i=low, j=mid+1, k=low;
		 while(i<=mid && j<=high)
		 {
			 if(helper[i]<=helper[j])
			 {
				 nums[k]=helper[i];
				 i++;
			 }
			 else
			 {
				 nums[k]=helper[j];
				 j++;
			 }
			 k++;
		 }
		 while(i<=mid)
		 {
			 nums[k]=helper[i];
			 k++;
			 i++;
		 }
	 }
	 
	 public int search(int[] nums, int target) {
	        
		 	int ret = rBinarySearch(0, nums.length-1, nums, target );
			return ret;
	    }
	    
	 public int rBinarySearch(int low, int high, int[] nums, int target)
	 {
		 if(low>high)
		 {
			 return -1;
		 }
		 
		 int mid = (low+high)/2;
		 if(target == nums[mid])
		 {
			 return mid;
		 }
		 //1st array is sorted
		 if(nums[low]<=nums[mid])
		 {
			 if(target>=nums[low] && target<=nums[mid])
			 {
				 return rBinarySearch(low, mid-1, nums, target);
			 }
			 else
			 {
				 return rBinarySearch(mid+1, high, nums, target);
			 }
		 }
		 //2nd array is sorted
		 if(nums[mid]<=nums[high])
		 {
			 if(target>=nums[mid]&& target<=nums[high])
			 {
				 return rBinarySearch(mid+1, high, nums, target);
			 }
			 else
			 {
				 return rBinarySearch(low, mid-1, nums, target);
			 }
		 }
		 
		 return -1;
	 }
	  
	 //allow duplicates in rotated array
	 public boolean search1(int[] nums, int target) {
	        
		 	boolean ret = rBinarySearch1(0, nums.length-1, nums, target );
			return ret;
	    }
	 public boolean rBinarySearch1(int low, int high, int[] nums, int target)
	 {
		 if(low>high)
		 {
			 return false;
		 }
		 
		 int mid = (low+high)/2;
		 if(target == nums[mid])
		 {
			 return true;
		 }
		 if(nums[low] == nums[mid])
		 {
			 for(int i=low;i<mid;i++)
			 {
				 if(target == nums[i])
				 {
					 return true;
				 }
			 }
		 }
		 if(nums[mid] == nums[high])
		 {
			 for(int i=mid+1;i<high;i++)
			 {
				 if(target == nums[i])
				 {
					 return true;
				 }
			 }
		 }
		 //1st array is sorted
		 if(nums[low]<=nums[mid])
		 {
			 if(target>=nums[low] && target<=nums[mid])
			 {
				 return rBinarySearch1(low, mid-1, nums, target);
			 }
			 else
			 {
				 return rBinarySearch1(mid+1, high, nums, target);
			 }
		 }
		 //2nd array is sorted
		 if(nums[mid]<=nums[high])
		 {
			 if(target>=nums[mid]&& target<=nums[high])
			 {
				 return rBinarySearch1(mid+1, high, nums, target);
			 }
			 else
			 {
				 return rBinarySearch1(low, mid-1, nums, target);
			 }
		 }
		 
		 return false;
	 }
	 public int[] searchRange(int[] nums, int target) {
	        
	        int[] range=new int[2];
	        range[0]=-1;
	        range[1]=-1;
	        
	        range = getSearchRange(0, nums.length-1, nums, target, range);
	        
	        
	        return range;
	    }
	    public int[] getSearchRange(int low, int high, int[] nums, int target, int[] range)
	    {
	        if(low>high) return range;
	        
	            int mid=(low+high)/2;
	            
	            if(nums[mid]==target)
	            {
	            	if(range[0]==-1 || mid<range[0])range[0]=mid;
	            	if(range[1]==-1 || mid>range[1])range[1]=mid;
	            	
	            	
	            	if(mid-1>=0)
	            	{
		                if(nums[mid-1]==target && mid-1<range[0])
		                {
		                    range[0] = mid-1;
		                }
	            	}
	            	if(mid+1<=high)
	            	{
		                if(nums[mid+1]==target && mid+1>range[1]) 
		                {
		                    range[1] = mid+1;
		                }
	            	}
	            	range = getSearchRange(low, mid-1, nums, target, range);
	            	range = getSearchRange(mid+1, high, nums, target, range);
	            	
	                return range;
	            }
	            else if(nums[mid]<target)
	            {
	            	return getSearchRange(mid+1, high, nums, target, range);
	                
	            }
	            else
	            {
	            	return getSearchRange(low, mid-1, nums, target, range);
	            }
	    }
	    public boolean searchMatrix(int[][] matrix, int target) {
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        int len=rows*cols;
	        
	        boolean res = false;
	        res = binarySearchMatrix(0, len-1, matrix, target);
	        
	        return res;
	    }
	    public boolean binarySearchMatrix(int low, int high, int[][] matrix, int target)
	    {
	        if(low> high) return false;
	        int mid=(low+high)/2;
	        int x = getRowValue(mid,matrix[0].length);
	        int y = getColValue(mid,matrix[0].length);
	        if(matrix[x][y]==target)
	        {
	            return true;
	        }
	        else if(matrix[x][y]<target)
	        {
	            return binarySearchMatrix(mid+1, high, matrix, target);
	        }
	        else
	        {
	            return binarySearchMatrix(low, mid-1, matrix, target);
	        }
	    }
	    public int getCellValue(int x, int y, int cols)
	    {
	        return x*cols+y;
	    }
	    public int getRowValue(int cellValue, int cols)
	    {
	        return cellValue/cols;
	    }
	    public int getColValue(int cellValue, int cols)
	    {
	        return cellValue%cols;
	    }
	    public boolean searchMatrix1(int[][] matrix, int target) {
	    	int row =0;
	    	int col =  matrix[0].length-1;
	    	
	    	while(row<matrix.length && col>=0)
	    	{
	    		if(matrix[row][col]==target)
	    		{
	    			return true;
	    		}
	    		else if(matrix[row][col]<target)
	    		{
	    			row++;
	    		}
	    		else
	    		{
	    			col--;
	    		}
	    	}
	    	return false;
	    }
	    public void rotate(int[][] matrix) {
	        int rows = matrix.length-1;
	        int cols = matrix[0].length-1;
	        
	        for(int i=0; i<=rows; i++)
	        {
	            for(int j=0; j<=cols; j++)
	            {
	                matrix[i][j]=matrix[i][j]*10+matrix[cols-j][i];
	            }
	        }
	        for(int i=0; i<=rows; i++)
	        {
	            for(int j=0; j<=cols; j++)
	            {
	                matrix[i][j]=matrix[i][j]%10;
	            }
	        }
	        
	    } 
	 public static void main(String args[])
	 {
		ArrayProblems obj = new ArrayProblems();
		//int[] nums={1,2,3,4,5,6,7};
		//obj.moveZeroes(nums);
		//System.out.println(obj.majorityElement(nums));
		//System.out.println(obj.containsDuplicate2(nums));
		//System.out.println(obj.twoSum1(nums,9)[0]);
		//System.out.println(obj.twoSum1(nums,9)[1]);
		//int[] digits={8,9,9};
		//System.out.println(obj.plusOne(digits)[0]);
		
		//obj.rotate1(nums, 3);
		/*for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]);
		}*/
		//System.out.println(obj.removeElement(nums, 3));
		//System.out.println(obj.summaryRanges(nums));
		//System.out.println(obj.generate(2));
		//System.out.println(obj.getRow(0));
		//System.out.println(obj.containsNearbyDuplicate(nums,1));
		/*obj.merge(nums1,3,nums2,4);
		for(int i=0;i<nums1.length;i++)
		{
			System.out.println(nums1[i]);
		}*/
		//System.out.println(obj.uniquePaths(1,2));
		
		//int[][] obstacleGrid=new int[1][2];
		
		//obstacleGrid[0][0]=1;
		//System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
		
		//int[] nums={0,0};
		//System.out.println(obj.threeSum(nums));
		
		/*int[][] matrix={{1,2,3},{4,5,5},{0,2,5}};
		obj.setZeroes1(matrix);
		for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
            	System.out.println(matrix[i][j]);
            }
        }*/
		//int[] nums1={1,3,1,1,1};
		//System.out.println(obj.search1(nums1, 3));
		//System.out.println(obj.searchInsert(nums1,2));
		
		/*int[] nums={0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
		System.out.println(obj.searchRange(nums,4)[0]);
		System.out.println(obj.searchRange(nums,4)[1]);//10,13
*/	
		int[][] matrix={{1,2},{3,4}};
		//System.out.println(obj.searchMatrix1(matrix, 2));
		obj.rotate(matrix);
		for(int i=0; i<matrix.length;i++)
		{
			for(int j=0; j<matrix[0].length;j++)
			{
				System.out.print(matrix[i][j]);
				System.out.println();
			}
		}
		
	 }
	
}
