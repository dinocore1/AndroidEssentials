package com.devsmart;

import java.util.Iterator;

public class PeekableIterator<T> implements Iterator<T> {

	private Iterator<T> mIterator;
	private T next;

	public PeekableIterator(Iterator<T> it) {
		mIterator = it;
		next = it.hasNext() ? it.next() : null;
	}
	
	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public T next() {
		T current = next;
		next = mIterator.hasNext() ? mIterator.next() : null;
		return current;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
		
	}
	
	public T peek() {
		return next;
	}

	
}
