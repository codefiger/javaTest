package com.figer.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimpleCacheBySynchroized {
	private static final Random RANDOM = new Random();
	private final Map<String, Object> cache = new HashMap<>();
	
	public void clearCache(){
		synchronized (cache) {
			cache.clear();
		}
	}
	
	public Object getCache(String cacheKey){
		Object obj = null;
		synchronized (cache) {
			 obj = cache.get(cacheKey);
			if (obj == null) {
				obj = load(cacheKey);
			}
		}
		return obj;
	}
	
	private Object load(String cacheKey){
		String object = "cache content" + RANDOM.nextInt(1000);
		cache.put(cacheKey, object);
		return object;
	}
	
	public static void main(String[] args) {
		SimpleCacheBySynchroized simpleCache = new SimpleCacheBySynchroized();
		System.err.println(simpleCache.getCache("figer"));
		System.err.println(simpleCache.getCache("figer"));
	}
}
