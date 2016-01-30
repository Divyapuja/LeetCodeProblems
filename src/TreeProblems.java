import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
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
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> obj = new ArrayList<List<Integer>>();
        /*if(root == null){return }
        if(root != null)
        {
        	
        	
        }*/
       return obj;
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
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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
    }
	
	public static void main(String args[])
	{
		TreeNode root=new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		
		TreeProblems obj = new TreeProblems();
		//System.out.println(obj.isSymmetric1(root));
		
		
		
		TreeNode root1=new TreeNode(1);
		//TreeNode root1=new TreeNode(1);
		
		//System.out.println(obj.isSymmetric1(root1));
		//System.out.println(obj.hasPathSum(root,27));
		System.out.println(obj.lowestCommonAncestor1(root, root.left.left.left, root.left.left.right).val);
		System.out.println(obj.lowestCommonAncestor2(root, root.left.left.left, root.left.left.right).val);
		
	}
	
	
}
