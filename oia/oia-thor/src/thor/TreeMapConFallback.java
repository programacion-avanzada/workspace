package thor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapConFallback<K, V> implements Map<K, V> {

	private Map<K, V> map = new TreeMap<K, V>();
	private Integer[] array;
	private boolean prepared;
	
	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public V get(Object key) {
		//log n
		if (map.containsKey(key))
			return this.map.get(key);

		// n
		if (!prepared) {
			prepare();
		}
		// log n
		int x = search(array, 0, array.length - 1, (Integer) key);
		if (x < 0)
			return null;

		// log n
		return map.get(array[x]);
		
	}

	private void prepare() {
		// n
		array = map.keySet().toArray(new Integer[map.size()]);
		prepared = true;
		
	}

	int search(Integer[] array, int start_idx, int end_idx, Integer search_val) {

		if (start_idx == end_idx)
			return array[start_idx] <= search_val ? start_idx : -1;

		int mid_idx = start_idx + (end_idx - start_idx) / 2;

		if (search_val < array[mid_idx])
			return search(array, start_idx, mid_idx, search_val);

		int ret = search(array, mid_idx + 1, end_idx, search_val);
		return ret == -1 ? mid_idx : ret;
	}
	

	@Override
	public V put(K key, V value) {
		prepared = false;
		return map.put(key, value);
	}

	@Override
	public V remove(Object key) {
		prepared = false;
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		prepared = false;
		map.putAll(m);
	}

	@Override
	public void clear() {
		prepared = false;
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return map.entrySet();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}

}
