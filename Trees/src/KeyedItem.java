
public abstract class KeyedItem<KT extends Comparable<? super KT>> {
	
	private KT searchKey;
	
	public KeyedItem(KT key){
		searchKey = key;
	}

	public KT getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(KT searchKey) {
		this.searchKey = searchKey;
	}

}
