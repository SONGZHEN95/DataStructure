package com.Deque;

import com.queue.*;

public interface Deque {
	public int getSize(); //返回队列规模
	public boolean isEmpty();//判断队列是否为空
	public Object first() throws ExceptionQueueEmpty;//返回队首元素(但不删除)
	public Object last() throws ExceptionQueueEmpty;//返回队尾元素(但不删除)
	public void insertFirst(Object obj);//将新元素作为队首元素插入
	public void insertLast(Object obj);//将新元素作为队尾元素插入
	public Object removeFirst() throws ExceptionQueueEmpty;//删除队首元素
	public Object removeLast() throws ExceptionQueueEmpty;//删除队尾元素
	public void Traversal();//遍历
}
