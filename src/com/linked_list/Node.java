package com.linked_list;

/*
 * 单链表，可用于构造可变长度的栈和队列，可有效节约空间，提高效率
 */
public class Node implements Position {
	private Object element;//数据对象
	private Node next;//指向后继结点
	public Node(Object e,Node n) { //指定数据对象及后继结点
		element = e;
		next = n;
	}
	public Node(){ //指定数据对象、后继结点的应用都置空
		this(null,null);
	}
	public Object getElem(){ //返回存放于该位置的元素
		return element;
	}
	
	public Object setElem(Object e){ //将给定的新元素存放于此，并返回原数据对象
		Object oldElem = element;
		element = e;
		return oldElem;
	}
	
	public Node getNext(){ //返回后继结点
		return next;
	}
	
	public void setNext(Node newNext){ //修改当前节点的后继结点
		next = newNext;
	}
}
