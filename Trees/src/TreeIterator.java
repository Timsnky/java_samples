import java.util.LinkedList;

public class TreeIterator<T> implements java.util.Iterator<T> {

	private BinaryTreeBasis<T> binTree;
	private TreeNode<T> currentNode;
	private LinkedList<TreeNode<T>> queue;
	
	public TreeIterator(BinaryTreeBasis<T> bTree){
		binTree = bTree;
		currentNode = null;
		queue = new LinkedList <TreeNode<T>>();
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !queue.isEmpty();
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		currentNode = queue.remove();
		return currentNode.getItem();
	}
	
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	public void setPreorder(){
		queue.clear();
		preorder(binTree.root);
	}
	
	public void setInorder(){
		queue.clear();
		inorder(binTree.root);
	}
	
	public void setPostorder(){
		queue.clear();
		postorder(binTree.root);
	}
	
	private void preorder(TreeNode<T> treeNode){
		if(treeNode != null){
			queue.add(treeNode);
			preorder(treeNode.getLeftChild());
			preorder(treeNode.getRightChild());
		}
	}
	
	private void inorder(TreeNode<T> treeNode){
		if(treeNode != null){
			inorder(treeNode.getLeftChild());
			queue.add(treeNode);
			inorder(treeNode.getRightChild());
		}
	}
	
	private void postorder(TreeNode<T> treeNode){
		if(treeNode != null){
			postorder(treeNode.getLeftChild());
			postorder(treeNode.getRightChild());
			queue.add(treeNode);
		}
	}
}
