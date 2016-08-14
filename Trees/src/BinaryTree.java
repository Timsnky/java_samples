
public class BinaryTree<T> extends BinaryTreeBasis<T> {
	
	public BinaryTree(){
		
	}
	
	public BinaryTree(T rootItem){
		super(rootItem);
	}
	
	public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
		root = new TreeNode<T>(rootItem, null, null);
		attachLeftSubTree(leftTree);
		attachRightSubTree(rightTree);
	}
	
	public void setRootItem(T newItem){
		if(root != null){
			root.setItem(newItem);
		}else{
			root = new TreeNode<T>(newItem, null, null);
		}
	}
	
	public void attachLeft(T newItem){
		if(!isEmpty() && root.getLeftChild() == null){
			root.setLeftChild(new TreeNode<T>(newItem, null, null));
		}
	}
	
	public void attachRight(T newItem){
		if(!isEmpty() && root.getRightChild() == null){
			root.setRightChild(new TreeNode<T>(newItem, null, null));
		}
	}
	
	public void attachLeftSubTree(BinaryTree<T> leftTree) throws TreeException{
		if(isEmpty()){
			throw new TreeException("TreeException: Empty tree");
		}else if(root.getLeftChild() != null){
			throw new TreeException("TreeException: Cannot overwrite left subtree");		
		}else{
			root.setLeftChild(leftTree.root);
			leftTree.makeEmpty();
		}
	}
	
	public void attachRightSubTree(BinaryTree<T> rightTree) throws TreeException{
		if(isEmpty()){
			throw new TreeException("TreeException: Empty tree");
		}else if(root.getRightChild() != null){
			throw new TreeException("TreeException: Cannot overwrite right subtree");		
		}else{
			root.setRightChild(rightTree.root);
			rightTree.makeEmpty();
		}
	}
	
	protected BinaryTree(TreeNode<T> rootNode){
		root = rootNode;
	}
	
	public BinaryTree<T> detachLeftSubTree() throws TreeException{
		if(isEmpty()){
			throw new TreeException("TreeException: Empty tree");
		}else{
			BinaryTree<T> leftTree;
			leftTree = new BinaryTree<T>(root.getLeftChild());
			root.setLeftChild(null);
			return leftTree;
		}
	}
	
	public BinaryTree<T> detachRightSubTree() throws TreeException{
		if(isEmpty()){
			throw new TreeException("TreeException: Empty tree");
		}else{
			BinaryTree<T> rightTree;
			rightTree = new BinaryTree<T>(root.getRightChild());
			root.setRightChild(null);
			return rightTree;
		}
	}
	
	

}
