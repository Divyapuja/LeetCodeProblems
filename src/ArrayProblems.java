import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;


public class ArrayProblems {
	
	/*----------------283. MOVE ZEROES------------------------*/
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
	/*----------------169. Majority Element------------------------*/
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
	
	//Moore's Voting Algorithm
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
	
	/*----------------217. CONTAINS DUPLICATE------------------------*/
	public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
            for(int i=0;i<nums.length;i++)
            {
                if(hmap.get(nums[i]) !=null)
                {
                    if(hmap.get(nums[i])>0)
                    {
                    	//found a copy
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
	/*----------------217. CONTAINS DUPLICATE------------------------*/
	public static boolean containsDuplicate1(int[] nums) {
		 HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		 for(int i=0;i<nums.length;i++)
         {
			 if(hmap.containsKey(nums[i]))
			 {
				 //found a copy
				 return true;
			 }
			 else
			 {
				 hmap.put(nums[i], 1);
			 }
         }
		return false;
	}
	/*----------------217. CONTAINS DUPLICATE------------------------*/
	public boolean containsDuplicate2(int[] nums) {
    
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
	/*----------------217. CONTAINS DUPLICATE------------------------*/
	//without using an hashmap
	public boolean containsDuplicate3(int[] array) {
        int arraylength = array.length;
        if(arraylength <= 1) return false;
        Arrays.sort(array);
        for(int i = 0; i < arraylength - 1; i++)
        	//find duplicate
            if(array[i] == array[i + 1]) return true;
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
	//if index is the output required
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
	//if value is the output required
	public int[] twoSum2(int[] nums, int target)
	{
		int[] array = new int[2];
		Arrays.sort(nums);
		int low=0; int high=nums.length-1;
		while(low<high)
		{
			if(nums[low]+nums[high]<target)
			{
				low++;
			}
			else if(nums[low]+nums[high]>target)
			{
				high--;
			}
			else
			{
				array[0]=nums[low];
				array[1]=nums[high];
				break;
			}
		}
		return array;
	}
	/*-------------66. PLUS ONE----------------------------------*/
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
            	//add nos to a new array
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
	
	
	/*------------189. ROTATE ARRAY---------------------*/
	//eg: n=1,2,3,5,6,7 and k=3, nout=5,6,7,1,2,3,4
	public void rotate(int[] nums, int k) {

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
	
	/*---------------27. REMOVE ELEMENT-------------------------*/
	//remove element and print the remaining content of the array
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
	public int removeElement1(int[] nums, int val) {
	    int len = 0;
	    for(int num: nums) {
	        if(num != val) {
	            nums[len] = num;
	            len++;
	        }
	    }
	    return len;
	}
	
	/*---------------26. REMOVE DUPLICATES FROM SORTED ARRAY-------------------*/
	//input nums=[1,1,2] output=2
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
	public int removeDuplicates1(int[] nums) {

        int i = 1; //iterator thru array
        int j = 0; //current index
        for (; i<nums.length; i++) { 
            if (nums[i] != nums[j]) { //new number
                j++; //move current index
                nums[j] = nums[i]; //fill current index with new number
            } 
        }
    return j+1;
   }
	/*-----------------------228. SUMMARY RANGES------------------------------*/
	//given [0,1,2,4,5,7] return ["0->2", "4->5", "7"]
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
            //if diff is 1
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
	/*---------------------118. PASCAL TRIANGLE--------------------------------*/
	/*	[
		 [1],
		[1,1],
	   [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
      ]*/
	 public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
	        //initialize first row
	        if(numRows-1>0 ||numRows==1)
	        {
	            List<Integer> row = new ArrayList<Integer>();
	            row.add(1);
	            pascal.add(row);
	        }
	        //initialize second row
	        if(numRows-2>0 || numRows==2)
	        {
	            List<Integer> row = new ArrayList<Integer>();
	            row.add(1);
	            row.add(1);
	            pascal.add(row);
	        }
	        //find next rows
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
	    
	    public List<Integer> getRow1(int rowIndex) {
	    	Integer[] rowList = new Integer[rowIndex+1];
	    	
	    	
	        return Arrays.asList(rowList);
	    }
	    
	    /*-------------------219. CONTAINS DUPLICATE II-------------------------------*/
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
	    /*----------------88. MERGE SORTED ARRAYS-------------------------*/
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int indexA=m-1, indexB=n-1, mergedIndex=m+n-1;
	        
	        //compare elements of nums1 and nums2 until everything is exhausted
	        //if we insert in the beginning of nums1, we need to shift everything to the back
	        //hence better to insert element into the back of an array
	        while(indexA>=0 && indexB>=0)
	        {
	        	if(nums1[indexA]>=nums2[indexB])
	        	{
	        		nums1[mergedIndex]=nums1[indexA];
	        		indexA--;
	        		mergedIndex--;
	        	}
	        	else
	        	{
	        		nums1[mergedIndex]=nums2[indexB];
	        		indexB--;
	        		mergedIndex--;
	        	}
	        }
	        /*copy the remaining elements from b into place*/
	        while(indexB>=0)
	        {
	        	nums1[mergedIndex]=nums2[indexB];
	        	indexB--;
	        	mergedIndex--;
	        }
	        
	    }
	    /*---------62. UNIQUE PATHS------------------------*/
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
	    /*---------63. UNIQUE PATHS II------------------------*/
	    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    	
	    	int m=obstacleGrid.length;//row
	    	int n=obstacleGrid[0].length;
	    	int s[][]=new int[m][n];
	    	//initialize with
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
	    				//the first row is initialize with 1
	    				s[i][0]=s[i-1][0];
	    			}
	    			else if(i==0 && j>0)
	    			{
	    				//the first column is initialized with 1
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
	    /*-----------------------209. MINIMUM SIZE SUBARRAY SUM------------------------*/
	    //array [2,3,1,2,4,3] s=7  output=2 i.e., [4,3]
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
	    
	    /*-----------------------15. 3SUM-----------------------------*/
	    //S={-1, 0, 1, 2, -1, -4} solution set is (-1, 0, 1) and (-1, -1, 2)
	    //has a double loop O(n^2)
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
	    
	    /*-------------------73. SET MATRIX ZEROES------------------------------*/
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
	    /*-------------------73. SET MATRIX ZEROES------------------------------*/
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
	    /*-----35. SEARCH INSERT POSITION-----------------------------*/
	    //[1,3,5,6], 5->2
	    //[1,3,5,6], 2->1
	    public int searchInsert(int[] nums, int target) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        return binarySearch(nums, 0, nums.length - 1, target);
	    }

	    private int binarySearch(int[] nums, int start, int end, int target) {
	    	//key is here..if not found return start
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
	    //not a great solution
	 /*-----------------------------------MERGE SORT-------------------------------*/  
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
		 //iterate through the helper array; compare both left and right half, copying the smaller
		 //elements from two halves into the original array
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
		 //copy the rest of the left side of the helper array to the original array
		 //right side doesn't need to be copied since it's already there
		 while(i<=mid)
		 {
			 nums[k]=helper[i];
			 k++;
			 i++;
		 }
	 }
	 /*-------------------33. SEARCH IN ROTATED SORTED ARRAY---------------------------*/
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
				 //normal binary search
				 return rBinarySearch(low, mid-1, nums, target);
			 }
			 else
			 {
				 //search in a rotated array
				 return rBinarySearch(mid+1, high, nums, target);
			 }
		 }
		 //2nd array is sorted
		 if(nums[mid]<=nums[high])
		 {
			 if(target>=nums[mid]&& target<=nums[high])
			 {
				 //normal binary search in a sorted array
				 return rBinarySearch(mid+1, high, nums, target);
			 }
			 else
			 {
				 //search in a rotated array
				 return rBinarySearch(low, mid-1, nums, target);
			 }
		 }
		 
		 return -1;
	 }
	  
	 /*-------------------81. SEARCH IN ROTATATED SORTED ARRAY II---------------------------*/
	 //find duplicates
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
	 /*---------------------34. SEARCH FOR A RANGE----------------------------*/
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
	            //if target is found search across both the sides of the target, i.e., both left and right
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
	    /*--------------------74. SEARCH A 2D MATRIX------------------------*/
	    /*[
	     [1,   3,  5,  7],
	     [10, 11, 16, 20],
	     [23, 30, 34, 50]
	     ]*/
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
	    /*--------------------74. SEARCH A 2D MATRIX------------------------*/
	    //better solution
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
	    /*---------------------48. ROTATE IMAGE----------------------------*/
	    //i,j => cols-j, i //can be seen from symmetry of matrices
	    //keep substituting
	    //cols-j, i => cols-i, cols-j
	    //cols-i, cols-j => cols-(cols-j),cols-i => j, cols-i
	    //j, cols -i => cols -(cols-i), j => i,j rotation is complete
	    //M/2 since centre doesn't need to be rotated
	    public void rotate(int[][] matrix) {
	        for (int i = 0; i < (matrix.length+1)/2; i++) {
	            for (int j = 0; j < matrix.length/2; j++) {
	                int tmp = matrix[i][j];
	                matrix[i][j] = matrix[matrix.length-j-1][i];
	                matrix[matrix.length-j-1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
	                matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
	                matrix[j][matrix.length-i-1] = tmp;
	            }
	        }
	    }
	    /*-------------------18. 4Sum-------------------------------------*/
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	    	List<List<Integer>> foursumarray = new ArrayList<List<Integer>>();
	        int size=nums.length;
	        int first=0, second=0, third=0, fourth=0;//three pointers
	        Arrays.sort(nums);
	        while(first<size)
	        {
	        	//if(first > 0 && nums[first] == nums[first-1]) first++;//skip duplicates
	        	
	        	second = first+1;
	        	while(second<size)
	        	{
	        		int target1 = target-nums[second] - nums[first];
	        		//if(first < second && nums[second] == nums[second-1]) second++;//skip duplicates
	        		
	        		third = second+1; fourth=size-1;
		        	while(third<fourth)
		        	{
		        		if(nums[third]+nums[fourth] == target1)
		        		{
		        			if(!foursumarray.contains(Arrays.asList(nums[first],nums[second],nums[third], nums[fourth])))
		        			foursumarray.add(Arrays.asList(nums[first],nums[second],nums[third], nums[fourth]));
		        			//while(third<fourth && nums[third]==nums[third+1]) third++;
		        			//while(third<fourth && nums[third]==nums[fourth-1]) fourth--;
		        			third++; fourth--;
		        			
		        		}
		        		else if(nums[third]+nums[fourth] < target1)
		        		{
		        			third++;
		        		}
		        		else
		        		{
		        			fourth--;
		        		}
		        	}
		        	second++;
	        	}
	        	first++;
	        }
	        return foursumarray;
	    }
	    
	    /*----------------------78. SUBSETS-------------------------------*/
	    //using a DP technique
	    //num={1,2,3}
	    //output [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2]
	    public List<List<Integer>> subsets(int[] nums) {
			Arrays.sort(nums);
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> row = new ArrayList<Integer>();
	        res.add(row);
	        if(nums.length>0)
	        {
	        	int i=0;
	            while(i<nums.length)
	            {
	            	res = combineOutputs(res, nums[i]);
	            	i++;
	            }
	        }
	        return res;
	        
	    }
	    
	    public List<List<Integer>> combineOutputs(List<List<Integer>> res, int num)
	    {
	    	List<List<Integer>> res1= new ArrayList<List<Integer>>(); 
	    	for(int i=0; i<res.size(); i++)
	        {
	            List<Integer> row = new ArrayList<Integer>();
	            row = res.get(i);
	            res1.add(row);
	            //copy row to row1
	            List<Integer> row1 = new ArrayList<Integer>();
	            
	            for(int j=0; j<row.size();j++)
	            {
	            	row1.add(row.get(j));
	            }
	            //add num to new row1
	            row1.add(num);
	            //add row1 to res
	            res1.add(row1);
	        }
	    	return res1;
	    }
	 public static void main(String args[])
	 {
		ArrayProblems obj = new ArrayProblems();
		int[] nums={2,7,11,15};
		//obj.moveZeroes(nums);
		//System.out.println(obj.majorityElement2(nums));
		//System.out.println(obj.containsDuplicate2(nums));
		//System.out.println(obj.twoSum1(nums,9)[0]);
		//System.out.println(obj.twoSum1(nums,9)[1]);
		System.out.println(obj.twoSum2(nums,9)[0]);
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
		//int[] nums1={1,3,5,6};
		//System.out.println(obj.search1(nums1, 3));
		//System.out.println(obj.searchInsert(nums1,0));
		
		/*int[] nums={0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
		System.out.println(obj.searchRange(nums,4)[0]);
		System.out.println(obj.searchRange(nums,4)[1]);//10,13
*/	
		//int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		//System.out.println(obj.searchMatrix1(matrix, 2));
		//obj.rotate(matrix);
		//int[] nums={-3,-2,-1,0,0,1,2,3};
		//System.out.println(obj.fourSum(nums, 0));
//		[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	 }
	
}
