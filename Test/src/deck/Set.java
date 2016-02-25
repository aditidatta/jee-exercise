package deck;

public class Set<K, V>{
	private K key;
	private V value;
	
	public Set(K k, V v){
		key = k;
		value = v;
	}
	
	public K getKey(){
		return key;
	}
	
	public V getValue(){
		return value;
	}
}
