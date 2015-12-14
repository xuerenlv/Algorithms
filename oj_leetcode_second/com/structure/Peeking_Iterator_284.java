package com.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Peeking_Iterator_284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// 就是在原有的 iterator 上，实现一个 peek 方法
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	List<Integer> peek_con = new ArrayList<>();

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (peek_con.size() == 0) {
			if (iterator.hasNext())
				peek_con.add(iterator.next());
		}
		return peek_con.get(0);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int ne = 0;
		if (peek_con.size() != 0) {
			ne = peek_con.get(0);
			peek_con.remove(0);
			return ne;
		}

		if (iterator.hasNext())
			return iterator.next();

		return -1;
	}

	@Override
	public boolean hasNext() {
		if (peek_con.size() == 0 && !iterator.hasNext()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void remove() {
		if (peek_con.size() != 0) {
			peek_con.remove(0);
		} else {
			iterator.next();
		}
	}
}