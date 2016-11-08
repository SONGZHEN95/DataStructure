package com.stack;

public class Stack_Array implements Stack {
	
	public static final int CAPACITY = 1024; //数组的默认容量
	protected int capacity; //数组的实际容量
	protected Object[] S; //对象数组
	protected int top = -1; //栈顶元素的位置
	
	//按默认容量创建栈对象
	public Stack_Array(int cap){
		capacity=cap;
		S = new Object[capacity];
	}
	
	//按指定容量创建栈对象
	public Stack_Array(){
		this(CAPACITY);
	}
	
	//获取当前栈规模
	public int getSize() {
		return (top+1);
	}
	
	//判断当前栈是否为空
	public boolean isEmpty() {
		return (top<0);
	}
	
	//返回栈顶元素
	public Object top() throws ExceptionStackEmpty {
		if(isEmpty()){
			throw new ExceptionStackEmpty("异常：栈空");
		}
		return S[top];
	}

	//入栈
	public void push(Object obj) throws ExceptionStackFull{
		if(getSize() == capacity){
			throw new ExceptionStackFull("异常：栈溢出");
		}
		S[++top]=obj;
	}

	//出栈
	public Object pop() throws ExceptionStackEmpty {
		Object elem;
		if(isEmpty()){
			throw new ExceptionStackEmpty("异常：栈空");
		}
		elem=S[top];
		S[top--]=null;
		return elem;
	}
	public void getStack(){
		System.out.print("当前栈：");
		for(int i=0;i<=top;i++){
			System.out.print(S[i]+"  ");
		}
		System.out.println("");
	}
}
