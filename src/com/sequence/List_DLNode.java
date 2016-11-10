package com.sequence;

import com.Deque.*;
public class List_DLNode implements List {
	
	protected int numElem; //列表的时间规模
	protected DLNode header,trailer;//哨兵：首节点+末节点

	public List_DLNode(){
		numElem = 0;
		header = new DLNode(null,null,null);
		trailer = new DLNode(null,header,null);
		header.setNext(trailer);
	}
	/*************************************辅助方法**********************************/
	//检查给定位置在列表中是否合法,若是，则将其转换为*DLNode
	protected DLNode checkPosition(Position p) throws ExceptionPositionInvalid{
		if(p==null)
			throw new ExceptionPositionInvalid("异常：传递给List_DLNode的位置是null");
		if(header==p)
			throw new ExceptionPositionInvalid("异常：头节点哨兵位置非法");
		if(trailer==p)
			throw new ExceptionPositionInvalid("异常：末节点哨兵位置非法");
		DLNode temp = (DLNode)p;
		return temp;
	}
	/*************************************ADT方法**********************************/
	public int getSize() {
		return numElem;
	}

	public boolean isEmpty() {
		return (numElem==0);
	}

	public Position first() throws ExceptionListEmpty{
		if(isEmpty())
			throw new ExceptionListEmpty("异常：列表空");
		return (Position)header.getNext();
	}

	public Position last() {
		if(isEmpty())
			throw new ExceptionListEmpty("异常：列表空");
		return (Position)trailer.getPrev();
	}

	public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode prev = v.getPrev();
		if(prev==header)
			throw new ExceptionBoundaryViolation("异常：企图越过列表前端");
		return (Position)prev;
	}

	public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode prev = v.getNext();
		if(prev==trailer)
			throw new ExceptionBoundaryViolation("异常：企图越过列表后端");
		return (Position)prev;
	}

	public Position insertFirst(Object e) {
		numElem++;
		DLNode newNode = new DLNode(e,header,header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		return (Position)newNode;
	}

	
	public Position insertLast(Object e) {
		numElem++;
		DLNode newNode = new DLNode(e,trailer.getPrev(),trailer);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		return (Position)newNode;
	}

	
	public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem++;
		DLNode newNode = new DLNode(e,v,v.getNext());
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		return (Position)newNode;
	}

	public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem++;
		DLNode newNode = new DLNode(e,v.getPrev(),v);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		return (Position)newNode;
	}

	
	public Object remove(Position p) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem--;
		DLNode vPrev = v.getPrev();
		DLNode vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		Object vElem = v.getElem();
		v.setPrev(null);
		v.setNext(null);
		return vElem;
	}

	
	public Object removeFirst() {
		return remove((Position)header.getNext());
	}

	
	public Object removeLast() {
		return remove((Position)trailer.getPrev());
	}

	
	public Object replace(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		Object oldElem = v.getElem();
		v.setElem(e);
		return oldElem;
	}

	
	public Iterator positions() {
		return new IteratorPosition(this);
	}


	public Iterator elements() {
		
		return new IteratorElement(this);
	}

}
