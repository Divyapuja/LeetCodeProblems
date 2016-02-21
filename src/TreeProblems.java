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
              temp = root.left;
              root.left = root.right;
              root.right = temp;
              return root;
        }
    }
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
	
	
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
        	return true;
        }
        else
        {
        	boolean mirror = false;
        	boolean value= false;
        			mirror= checkMirrorValidity(root.left, root.right);
        			value = checkValueValidity(root.left, root.right);
        			if(mirror && value)
        			{
        				return true;
        			}
       }
        return false;
    }
	public boolean checkMirrorValidity(TreeNode left, TreeNode right)
	{
		if(left == null && right == null)
		{
			return true;
		}
		else
		{
			boolean mirrorOpp = false; 
			boolean mirrorSame = false;
			
			if(left!= null && right !=null)
			{
				mirrorOpp=checkMirrorValidity(left.right, right.left);
				mirrorSame=	checkMirrorValidity(left.left, right.right);
			}
        	
        	if(mirrorOpp && mirrorSame)
        	{
	        			return true;
        	}
	  }
		return false;
	}
	public boolean checkValueValidity(TreeNode left, TreeNode right)
	{
		if(left == null && right == null)
		{
			return true;
		}
		else if(left!=null && right !=null)
		{
			if(left.val == right.val)
			{
				return true;
			}
		}
		else
		{
			boolean leftVal=false;
			boolean rightVal=false;
			if(left!=null && right!=null)
			{
					leftVal = checkValueValidity(left.left, right.left);
					rightVal = checkValueValidity(left.right, right.right);
				
			}
			if(leftVal && rightVal)
			{
				return true;
			}
		}
			
      return false;
	}
	
	public boolean isSymmetric1(TreeNode root) {
		if(root==null)
		{
			return true;
		}
		return isSymmetric1(root.left, root.right);
	}
	public boolean isSymmetric1(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null) return true;
	    if(node1 == null || node2 == null) return false;

	    return node1.val == node2.val
	           &&isSymmetric1(node1.left, node2.right)
	           && isSymmetric1(node1.right,node2.left);
	}
	
	
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        {
            return false;
        }
        else if(root.val == sum && root.left == null & root.right == null )
        {
        	return true;
        }
        else
        {
        	return hasPathSum(root.left, sum -root.val) ||hasPathSum(root.right, sum -root.val);
        }
        
    }
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
		{
			return null;
		}
        if(root == p)
        {
        	return p;
        }
        if(root == q)
        {
        	return q;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        
        if(left == null && right == null)
        {
        	return null;
        }
        if(left != null && right == null)
        {
        	return left;
        }
        if(right != null && left == null)
        {
        	return right;
        }
        return root;
    }
	/*public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        	while (!ancestors.contains(q))
        		q = parent.get(q);
        	return q;
    }*/
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
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>(); 
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
    public boolean isValidBST(TreeNode root) {
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
