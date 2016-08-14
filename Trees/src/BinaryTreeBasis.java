
public abstract class BinaryTreeBasis<T> {
	protected TreeNode<T> root;
	
	public BinaryTreeBasis(){
		root = null;
	}
	
	public BinaryTreeBasis(T rootItem){
		root = new TreeNode<T>(rootItem, null, null);
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	public T getRootItem() throws TreeException{
		if(root == null){
			throw new TreeException("TreeException: Empty tree");
		}else{
			return root.getItem();
		}
	}
	
	protected abstract void setRootItem(T newItem);
	
}

