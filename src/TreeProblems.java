import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TreeProblems {
	/*------------235. LOWEST COMMON ANCESTOR OF A BINARY SEARCH TREE----------------*/
/*		 _______6______
		/              \
     ___2__          ___8__
    /      \        /      \
    0      _4       7       9
          /  \
         3   5
*/	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
	/*-------------------104. MAXIMUM DEPTH OF BINARY TREE----------------------*/
	public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        else 
        {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if(leftDepth > rightDepth)
            {
                    return leftDepth+1;
            }
            else
            {
                	return rightDepth+1;
            }
        }
    }

/*-----------------------226. INVERT A BINARY TREE-------------------------------*/	
/*	 	     4                           4
	 	   /   \                       /   \
	 	  7     2          to         2     7
	 	 / \   / \                   / \   / \
	 	9   6 3   1                 1   3 6   9
*/	   
	public TreeNode invertTree(TreeNode root) {
        
        TreeNode temp = null;
        TreeNode left = null;
        TreeNode right = null;
        if(root == null)
        {
            return null;
        }
        else
        {
              root.left = invertTree(root.left);
              root.right = invertTree(root.right);
              
              //swap left and right nodes
              temp = root.left;
              root.left = root.right;
              root.right = temp;
              return root;
        }
    }
	/*-----------------100. SAME TREE-----------------------*/
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
				return true;
			}
			else if(p != null && q != null)
			{
					if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
    				{
    					if(p.val == q.val)
    					{
    						return true;
    					}
    				}
            }
		return false;
			
    }
	/*-----------110. BALANCED BINARY TREE------------------*/
	public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        else
        {
        	if(depth(root)!= -1)
        	{
        		return true;
        	}
        }
        return false;
    }
	
	public int depth(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            int diff = Math.abs(leftDepth - rightDepth);
            if(leftDepth == -1 || rightDepth == -1 || diff > 1)
            {
            	return -1;
            }
            else 
            {
            	return Math.max(leftDepth, rightDepth)+1;
            }
      }
	}
	
	/*-----------------101. SYMMETRIC TREE-----------------------------*/
/*	 	1							 1
	   / \							/ \
	  2   2		   to			   2   2
	 / \ / \						\   \
	3  4 4  3 						3    3
*/		public boolean isSymmetric(TreeNode root) 
		{
			if(root==null)
			{
				return true;
			}
			//pass one the left and right node
			return isSymmetric(root.left, root.right);
		}
		public boolean isSymmetric(TreeNode node1, TreeNode node2) {
		//if both the nodes are null then true
		if(node1 == null && node2 == null) return true;
		//if either is one is null then false
	    if(node1 == null || node2 == null) return false;

	    //check if values, left--right, and right---left are same 
	    return node1.val == node2.val
	           &&isSymmetric(node1.left, node2.right)
	           && isSymmetric(node1.right,node2.left);
		}
	
	
	/*-----------------112. PATH SUM----------------------------------------*/
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        {
            return false;
        }
        //if value reaches sum return true
        else if(root.val == sum && root.left == null & root.right == null )
        {
        	return true;
        }
        else
        {
        	//keep subtracting the sum across left or right path
        	return hasPathSum(root.left, sum -root.val) ||hasPathSum(root.right, sum -root.val);
        }
        
    }
	/*--------------------236. LOWEST COMMON ANCESTOR of A BINARY TREE-----*/
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null  || root==p || root==q)return root;
		
		TreeNode left = lowestCommonAncestor1(root.left, p, q);
	    TreeNode right = lowestCommonAncestor1(root.right, p, q);
	        
	    if(left!=null && right!=null)
        {
        	return root;
        }
        else if(left!=null && right==null)
        {
        	return left;
        }
        else if(left==null && right!=null)
        {
        	return right;
        }
        else if(left==null && right==null)
        {
        	return null;
        }
		return root;
	}
	//using an hashmap
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> lookup = new HashMap<TreeNode, TreeNode>();
		lookup.put(root,null);
		storeParentNodes(root,lookup);
		ArrayList<TreeNode> parents = new ArrayList<TreeNode>();
		while(p!=null)
		{
			parents.add(p);
			p=lookup.get(p);
		}
		while(q!=null)
		{
			if(parents.contains(q)) return q;
			q = lookup.get(q);
		}
		
		
		return null;
	}
	
	public TreeNode storeParentNodes(TreeNode root, Map<TreeNode, TreeNode> lookup)
	{
		if(root == null)
		{
			return null;
		}
		else
		{
			TreeNode left= storeParentNodes(root.left, lookup);
			if(left!=null)
			{
				lookup.put(left, root);
			}
			
			TreeNode right= storeParentNodes(root.right, lookup);
			if(right!=null)
			{
				lookup.put(right, root);
			}
			
		}
		return root;
	}
	/*-----------------------102. BINARY TREE LEVEL ORDER TRAVERSAL---------------------*/
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        //use hashmap to store values at a particular level
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        if(root!=null)
        {
        		List<Integer> row = new ArrayList<Integer>();    
            	row.add(root.val);
            	map.put(0, row);
                levelOrderTraversal(root.left, map, 1);
                levelOrderTraversal(root.right, map, 1);
        }
        
        Iterator itr = map.keySet().iterator();
        while(itr.hasNext())
        {
        	Integer key = (Integer)itr.next();
        	List<Integer> row = map.get(key);
        	arrays.add(row);
        }
        
        return arrays;
    }
    
    public int levelOrderTraversal(TreeNode root, Map<Integer,List<Integer>> map, int height)
    {
                if(root==null) return height;
                if(map.containsKey(height))
                {
                    List<Integer> row = map.get(height);
                    if(!row.contains(root.val))
                    {
                        row.add(root.val);
                        map.replace(height,row);
                    }
                }
                else
                {
                    List<Integer> row = new ArrayList<Integer>();    
                    row.add(root.val);
                    map.put(height, row);
                }
                levelOrderTraversal(root.left, map, height+1);
                levelOrderTraversal(root.right, map, height+1);
      return -1;          
    }
    
    /*-------------------------98. VALID BINARY SEARCH TREE-------------------------*/
    public boolean isValidBST(TreeNode root) {
    	//root, min, max
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
    	if(root == null)return true;
    	
    	if(min!=null && root.val<=min) return false;
    	if(max!=null && root.val>=max) return false;
			
    	return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    
	public static void main(String args[])
	{
		TreeNode root=new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = null;
		root.left.right = null;
		
		
		root.right = new TreeNode(15);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(20);
		
		
		TreeProblems obj = new TreeProblems();
		//System.out.println(obj.isSymmetric1(root));
		
		
		
		//System.out.println(obj.isSymmetric1(root1));
		//System.out.println(obj.hasPathSum(root,27));
		//System.out.println(obj.lowestCommonAncestor2(root,root.left.left.left,root.left).val);
		//System.out.println(obj.lowestCommonAncestor2(root, root.left.left.left, root.left.left.right).val);
		//System.out.println(obj.levelOrder(root));
		System.out.println(obj.isValidBST(root));
		
	}
	
	
}
