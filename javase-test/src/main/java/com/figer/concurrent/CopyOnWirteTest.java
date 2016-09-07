package com.figer.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWirteTest {
	public static void main(String[] args) throws Exception{
		testCopyOnwriteArrayList();
	}
	
	private static void testCopyOnwriteArrayList() throws Exception{
		final ArrayList<Integer> list = new ArrayList<Integer>();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i < 1000;i++){
					list.add(i);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i < 1000;i++){
					list.add(i);
				}
			}
		});	
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("线程不安全的:" + list.size());
		
		System.out.println("========下面是CopyOnWriteArrayList的表演...");
		final CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<Integer>();
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i < 1000;i++){
					cowList.add(i);
				}
			}
		});
		
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i < 1000;i++){
					cowList.add(i);
				}
			}
		});	
		
		t4.start();
		t5.start();
		t4.join();
		t5.join();
		System.out.println(cowList.size());
	}
}

/**
 * copyonwrite hashMap 写入安全，读取非安全
 * 实现：写入加锁
 * @author figer
 *
 * @param <K>
 * @param <V>
 */
class MyCOWHashMap<K,V> implements Map<K, V>{
	private volatile Map<K, V> internalMap;
	
	public MyCOWHashMap() {
		this.internalMap = new HashMap<K, V>();
	}
	
	@Override
	public V put(K key, V value) {
		synchronized (this) {
			Map<K, V> hashMap = new HashMap<K, V>(internalMap);
			V returnVal = hashMap.put(key, value);
			internalMap = hashMap;
			return returnVal;
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
