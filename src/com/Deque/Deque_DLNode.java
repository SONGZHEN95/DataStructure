package com.Deque;

import com.queue.ExceptionQueueEmpty;

public class Deque_DLNode implements Deque {
	
	protected DLNode header;
	protected DLNode trailer;
	protected int size;
	
	public Deque_DLNode() {
		header = new DLNode();
		trailer = new DLNode();
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}
	
	public int getSize(){
		return size;
	}

	public boolean isEmpty(){
		return (size==0) ? true : false;
	}
	
	//返回队首元素(但不删除)
	public Object first() throws ExceptionQueueEmpty{
		if(isEmpty())
			throw new ExceptionQueueEmpty("异常:双端队列空");
		return header.getNext().getElem();
	}
	
	//返回队尾元素(但不删除)
	public Object last() throws ExceptionQueueEmpty{
		if(isEmpty())
			throw new ExceptionQueueEmpty("异常:双端队列空");
		return trailer.getPrev().getElem();
	}
	
	//将新元素作为队首元素插入
	public void insertFirst(Object obj){
		DLNode second = header.getNext();
		DLNode first = new DLNode(obj,header,second);
		second.setPrev(first);
		header.setNext(first);
		size++;
	}
	
	//在队列后端插入新结点
	public void insertLast(Object obj){
		DLNode second = trailer.getPrev();
		DLNode first = new DLNode(obj,second,trailer);
		second.setNext(first);
		trailer.setPrev(first);
		size++;
	}
	
	//删除首节点
	public Object removeFirst() throws ExceptionQueueEmpty{
		if(isEmpty()) throw new ExceptionQueueEmpty("异常:双端队列空");
		DLNode first = header.getNext();
		DLNode second = first.getNext();
		Object obj = first.getElem();
		second.setPrev(header);
		header.setNext(second);
		size--;
		return(obj);
	}
	
	//删除末节点
	public Object removeLast() throws ExceptionQueueEmpty{
		if(isEmpty()) throw new ExceptionQueueEmpty("异常:双端队列空");
		DLNode first = trailer.getPrev();
		DLNode second = first.getPrev();
		Object obj = first.getElem();
		trailer.setPrev(second);
		second.setNext(trailer);
		size--;
		return(obj);
	}
	
	//遍历
	public void Traversal(){
		DLNode p = header.getNext();
		while(p!=trailer){
			System.out.print(p.getElem()+" ");
			p=p.getNext();
		}
		System.out.println(" ");
	}
	
}
