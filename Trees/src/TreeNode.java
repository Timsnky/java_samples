
class TreeNode<T> {
	private T item;  				//data item in the tree
	private TreeNode<T> leftChild;			//index to left child
	private TreeNode<T> rightChild;			//index to the right child
	
	public TreeNode(T newItem){
		item = newItem;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right){
		item = newItem;
		leftChild = left;
		rightChild = right;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
}

