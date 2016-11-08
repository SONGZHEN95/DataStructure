package com.queue;

/*
 * 借助定长数组实现队列
 */
public class Queue_Array implements Queue {
	
	public static final int CAPACITY = 1000; //数组的默认容量
	protected int capacity; //数组的实际容量
	protected Object[] Q;//对象数组
	protected int f = 0;//队首元素的位置
	protected int r = 0;//队尾元素的位置
	
	//按指定容量构造对象
	public Queue_Array(int cap){
		capacity = cap;
		Q = new Object[capacity];
	}
	
	//按默认容量构造空队列
	public Queue_Array(){
		this(CAPACITY);
	}
	
	//返回当前队列中元素数量
	public int getSize(){
		return (CAPACITY+r-f)%CAPACITY; //防止数组越界
	}
	
	//判断队列是否为空
	public boolean isEmpty(){
		return(f==r);
	}
	
	//入队
	public void enqueue(Object obj) throws ExceptionQueueFull{
		if(getSize()==CAPACITY-1) //控制队列实际大小 防止溢出
			throw new ExceptionQueueFull("Queue overflow");
		Q[r]=obj;
		r=(r+1)%CAPACITY; //防止数组越界
	}
	
	//出队
	public Object dequeue(){
		Object elem;
		if(isEmpty())
			throw new ExceptionQueueEmpty("意外:队列空");
		elem = Q[f];
		Q[f] = null;
		f=(f+1)%CAPACITY; //防止数组越界
		return elem;
	}
	
	public Object front() throws ExceptionQueueEmpty{
		if(isEmpty())
			throw new ExceptionQueueEmpty("意外:队列空");
		return Q[f];
	}
	
	public void Traversal(){
		for(int i=f;i<r;i++){
			System.out.print(Q[i]+" ");
		}
		System.out.println();
	}
	
}
