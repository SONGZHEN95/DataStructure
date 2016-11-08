package com.linked_list;

import com.queue.*;

/*
 * 基于单链表实现队列结构
 */
public class Queue_List implements Queue {
	
	protected Node head; //指向表首元素
	protected Node tail;//指向表尾元素
	protected int size;//队列中元素数目
	
	//构造空队列
	public Queue_List() { 
		head = null;
		tail = null;
		size = 0;
	}
	
	//获取队列规模
	public int getSize(){ 
		return size;
	}
	
	//判断队列是否为空
	public boolean isEmpty(){ 
		return (size==0) ? true : false;
	}
	
	//入队
	public void enqueue(Object obj){ 
		Node node = new Node(); //创建新结点,数据域为传入参数,next指向null
		node.setElem(obj);
		node.setNext(null);
		if(size==0) head = node; //如果队列为空,把该结点作为队首结点
		else tail.setNext(node); //否则作为队末结点,插入队尾
		tail = node;
		size++;
	}
	
	//出队
	public Object dequeue() throws ExceptionQueueEmpty{
		if(size == 0) throw new ExceptionQueueEmpty("异常:栈空");
		Object obj = head.getElem();
		head = head.getNext(); //队首指向第二个元素,如果head被赋为null,说明队列已空
		size--;
		if(size == 0) tail = null; //正常情况下,tail无需改变,当队列仅剩的元素被弹出,tail也应该为空——空队列head,tail均为空
		return obj;
	}
	
	//返回队首元素(但是不删除)
	public Object front() throws ExceptionQueueEmpty{ 
		if(isEmpty()) throw new ExceptionQueueEmpty("异常:队列空");
		return head.getElem();
	}
	
	//遍历
	public void Traversal(){
		Node p =head;
		while(p!=null){
			System.out.print(p.getElem()+" ");
			p=p.getNext();
		}
	}
	
	
}
