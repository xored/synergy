package com.xored.emfjson;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Cache<K, V> {

	private final ConcurrentMap<K, V> cache = new ConcurrentHashMap<K, V>();

	private final Creator<K, V> creator;

	private boolean disabled;
	
	private boolean strictMode = true;

	public Cache(Creator<K, V> creator) {
		this.creator = creator;
	}

	public V get(K key) {

		// Don't use cache
		if (disabled) {
			return creator.create(key);
		}

		V value = cache.get(key);

		if (value == null) {
			V newValue = creator.create(key);

			if (newValue == null) {
				if (strictMode) {
					throw new IllegalStateException("Creator can't return null");
				} else {
					return null;
				}
			}

			value = cache.putIfAbsent(key, newValue);
			if (value == null) {
				value = newValue;
			}
		}
		return value;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void reset() {
		cache.clear();
	}

	public void setStrictMode(boolean strictMode) {
		this.strictMode = strictMode;
	}

	public boolean isStrictMode() {
		return strictMode;
	}

	public static interface Creator<K, V> {

		V create(K key);

	}
}

