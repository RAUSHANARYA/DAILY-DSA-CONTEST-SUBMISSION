package array;


public class pathSumQ3 {
	
	class Node
	{
		int val;
		Node left;
		Node right;
		
		Node(int data)
		{
			this.val =data;
		}
	}
	
	
	    public boolean hasPathSum(Node root, int targetSum)
	     {
	        if(root==null) return false;
	        if(root.left==null && root.right==null) return targetSum==root.val;
	        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
