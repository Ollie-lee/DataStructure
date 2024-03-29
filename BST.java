package com.imooc.leo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
	private class Node{
		public E e;
		public Node left, right;
		
		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public void add(E e) {
		root = add(root, e);
	}
	
	private Node add(Node node, E e) {
		//递归函数,以node为根节点的二分搜索树中加入E, 并返回根节点
		if(node == null) {
			size++;
			return new Node(e);
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = add(node.left,e);
		}
		
		else if(e.compareTo(node.e)>0) {
			node.right = add(node.right,e);
		}
		return node;
	}

	public boolean contains(E e) {
		return contains(root, e);
	}
	
	private boolean contains(Node node, E e) {
		//递归函数, 查看以node为根的二叉树是否包含元素e
		if(node == null)
			return false;
		
		if(e.compareTo(node.e) == 0)
			return true;
		
		else if(e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		}
		
		else {
			return contains(node.right, e);
		}
	}

	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		//递归算法,前序遍历以node为根节点的树
		if(node == null)
			return;
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		inOrder(node.right);
		System.out.println(node.e);
	}

	public void preOrderNR() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(stack.isEmpty() == false) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)	
				stack.push(cur.left);
		}
	}
	
	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(q.isEmpty() == false) {
			Node cur = q.remove();
			System.out.println(cur.e);
			if(cur.left != null)
				q.add(cur.left);
			if(cur.right != null)
				q.add(cur.right);
			
		}
	}

	public E minimum() {
		if(isEmpty())
			throw new IllegalArgumentException("the tree is empty");
		
		return minimum(root).e;
	}
	
	private Node minimum(Node node) {
		if(node.left == null)
			return node;
		
		return minimum(node.left);
	}
	
	public E maximum() {
		if(isEmpty())
			throw new IllegalArgumentException("the tree is empty");
		
		return maximum(root).e;
	}
	
	private Node maximum(Node node) {
		if(node.right == null)
			return node;
		return maximum(node.right);
	}

	public E removeMin() {
		E ret = minimum();
		removeMin(root);
		return ret;
	}
	
	private Node removeMin(Node node) {
		if(node.left == null) {
			size--;
			return node.right;
		}
		
		node.left =  removeMin(node.left);
		return node;
	}
	
	public E removeMax() {
		E ret = maximum();
		removeMax(root);
		return ret;
	}
	
	private Node removeMax(Node node) {
		if(node.right == null) {
			size--;
			return node.left;
		}
		
		node.right = removeMax(node.right);
		return node;
	}

	public void remove(E e) {
		root = remove(root, e);
	}
	
	private Node remove(Node node, E e) {
		//删除以node为根节点的二分搜索树中的元素e
		//返回删除节点后新的二分搜索树的根
		if(node == null)
			return null;
		
		if(e.compareTo(node.e)<0) {
			node.left = remove(node.left, e);
			return node;
		}
		
		else if(e.compareTo(node.e)>0) {
			node.right = remove(node.right, e);
			return node;
		}
		
		else {
			//e = node.e
			if(node.right == null) {
				size--;
				return node.left;
			}
			
			else if(node.left == null) {
				size--;
				return node.right;
			}
			
			//待删除节点左右子树均不为空的情况
			//找到比待删除节点大的最小节点,用这个节点顶替待删除节点
			
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			return successor;
		}
		
		
			
	}
	
	
}
