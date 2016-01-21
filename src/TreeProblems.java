
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
    					else{
    						return false;
    					}
    				}
    				else{
    					return false;
    				}
            }
            else
            {
                    return false;
            }
			
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
	
	
	public static void main(String args[])
	{
		TreeNode root=new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		
		TreeProblems obj = new TreeProblems();
		System.out.println(obj.isSymmetric1(root));
		
		TreeNode root1=new TreeNode(1);
		root1.left = null;
		root1.right = new TreeNode(2);
		
		System.out.println(obj.isSymmetric1(root1));
		
	}
	
	
}
