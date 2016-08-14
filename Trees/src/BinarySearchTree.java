//import SearchKeys.KeyedItem;

public class BinarySearchTree<T extends KeyedItem <KT>, 
			KT extends Comparable<? super KT>> extends BinaryTreeBasis<T>{

	
	public BinarySearchTree(){
		
	}
	
	public BinarySearchTree(T rootItem){
		super(rootItem);
	}
	
	@Override
	public void setRootItem(T newItem) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		
	}
	
	public void insert(T newItem){
		root = insertItem(root, newItem);
	}
	
	public T retrieve(KT searchKey){
		return retrieveItem(root, searchKey);
	}
	
	public void delete(KT searchKey) throws TreeException{
		root = deleteItem(root, searchKey);
	}
	
	public void delete(T item) throws TreeException{
		root = deleteItem( root, item.getSearchKey());
	}
	
	protected TreeNode<T> insertItem(TreeNode<T> tNode, T newItem){
		TreeNode<T> newSubtree;
		if( tNode == null){
			tNode = new TreeNode<T>(newItem, null, null);
			return tNode;
		}
		
		T nodeItem = tNode.getItem();
		
		if( newItem.getSearchKey().compareTo(nodeItem.getSearchKey()) < 0){
			newSubtree = insertItem( tNode.getLeftChild(), newItem);	
			tNode.setLeftChild(newSubtree);
			return tNode;
		}else{
			newSubtree = insertItem(tNode.getRightChild(), newItem);
			tNode.setRightChild(newSubtree);
			return tNode;			
		}
	}
	
	protected T retrieveItem( TreeNode<T> tNode, KT searchKey){
		T treeItem;
		
		if(tNode == null){
			treeItem = null;
		}else{
			T nodeItem = tNode.getItem();
			if(searchKey.compareTo(nodeItem.getSearchKey()) == 0){
				treeItem = tNode.getItem();
			}else if( searchKey.compareTo(nodeItem.getSearchKey()) < 0){
				treeItem = retrieveItem(tNode.getLeftChild(), searchKey);
			}else{
				treeItem = retrieveItem(tNode.getRightChild(), searchKey);
			}
		}
		return treeItem;
	}
	
	protected TreeNode<T> deleteItem( TreeNode<T> tNode, KT searchKey){
		TreeNode<T> newSubtree;
		
		if( tNode == null){
			throw new TreeException("TreeException: Item not found");
		}else{
			T nodeItem = tNode.getItem();
			if( searchKey.compareTo(nodeItem.getSearchKey()) == 0){
				tNode = deleteNode(tNode);
			}else if( searchKey.compareTo( nodeItem.getSearchKey()) < 0 ){
				newSubtree = deleteItem( tNode.getLeftChild(), searchKey);
				tNode.setLeftChild(newSubtree);
			}else{
				newSubtree = deleteItem( tNode.getRightChild(), searchKey);
				tNode.setRightChild(newSubtree);
			}
		}
		return tNode;
	}
	
	protected TreeNode<T> deleteNode( TreeNode<T> tNode){
		T replacementItem;
		
		if( (tNode.getLeftChild() == null) && (tNode.getRightChild() == null)){
			return null;
		}else if( tNode.getLeftChild() == null){
			return tNode.getRightChild();
		}else if( tNode.getRightChild() == null){
			return tNode.getLeftChild();
		}else{
			replacementItem = findLeftmost(tNode.getRightChild());
			tNode.setItem(replacementItem);
			tNode.setRightChild(deleteLeftmost(tNode.getRightChild()));
			return tNode;
		}
	}
	
	protected T findLeftmost(TreeNode<T> tNode){
		if( tNode.getLeftChild() == null){
			return tNode.getItem();
		}else{
			return findLeftmost(tNode.getLeftChild());
		}
	}
	
	protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode){
		if(tNode.getLeftChild() == null){
			return tNode.getRightChild();
		}else{
			tNode.setLeftChild(deleteLeftmost(tNode.getLeftChild()));
			return tNode;
		}
	}
	
}
