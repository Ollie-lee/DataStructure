package com.imooc.leo;

public class LinkedList<E> {
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node() {
			this(null,null);
		}
		
		public Node(E e) {
			this(e, null);	
		}
		
		@Override
		public String toString() {
			return e.toString();
		}
		
		
	}

	private Node dummyHead;
	private int size;
	
	public LinkedList() {
		dummyHead = new Node();
		size = 0;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public int getSize() {
		return size;
	}

	public void add(int index, E e) {
		if(index < 0 || index >size)
			throw new IllegalArgumentException("invalid index");
		
		Node prev = dummyHead;
		Node node = new Node(e);
		for(int i = 0; i < index; i++) {
			prev = prev.next;
		}
		node.next = prev.next;
		prev.next = node;
		size++;
	}

	public boolean contain(E e) {
		Node cur = dummyHead.next;
		while(cur != null) {
			if(cur.e.equals(e))
				return true;
			cur = cur.next;
		}
		return false;
	}

	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("invalid index");
		Node prev = dummyHead;
		Node delNode = prev.next;
		for(int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = delNode.next;
		delNode.next = null;
		size--;
		return delNode.e;
	}
	
	public void set(int index, E e) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("invalid index");
		Node cur = dummyHead.next;
		for(int i = 0; i < index; i++)
			cur = cur.next;
		cur.e = e;
	}

	public E get(int index) {
		if(index < 0 || index >size)
			throw new IllegalArgumentException("invalid index");
		Node cur = dummyHead.next;
		for(int i = 0; i <index; i++)
			cur = cur.next;
		return cur.e;
	}

	public void addFirst(E e) {
		add(0, e);
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		Node cur = dummyHead.next;
		while(cur != null) {
			res.append(cur.e + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
}
