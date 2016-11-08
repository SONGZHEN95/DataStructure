package com.Deque;

import com.linked_list.Position;

/*
 * 基于位置接口实现双向链表节点类
 */
public class DLNode implements Position {
	
	private Object element;//数据对象
	private DLNode prev;//指向前驱结点
	private DLNode next;//指向后继结点
	
	//构造双向链表节点,按给定参数进行初始化
	public DLNode(Object e,DLNode p,DLNode n) {
		element = e;
		prev = p;
		next = n;
	}
	
	//构造双向链表节点,初始化为空
	public DLNode(){
		this(null,null,null);
	}
	
	//返回数据对象
	public Object getElem(){
		return element;
	}
	
	//设置数据对象,并返回原来的数据对象
	public Object setElem(Object e){
		Object temp = element;
		element = e;
		return temp;
	}
	
	//找到前驱位置
	public DLNode getPrev(){
		return prev;
	}
	
	//找到后继位置
	public DLNode getNext(){
		return next;
	}
	
	//设置后继位置
	public void setNext(DLNode newNext){
		next = newNext;
	}
	
	//设置前驱位置
	public void setPrev(DLNode newPrev){
		prev = newPrev;
	}
}
