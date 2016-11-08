package com.linked_list;

import com.stack.*;

/*
 * 基于单链表实现栈结构
 */
public class Stack_List implements Stack {
	
	protected Node top; //指向栈顶元素
	protected int size; //栈中元素数目
	
	//构造方法(空栈)
	public Stack_List() {
		top = null;
		size = 0;
	}
	
	//查询当前栈规模
	public int getSize(){
		return size;
	}
	
	//判断是否栈空
	public boolean isEmpty(){
		return (top==null) ? true : false;
	}
	
	//压栈
	public void push(Object elem){
		Node v = new Node(elem,top); //创建一个新结点，将其作为首节点插入
		top = v; //更新首节点引用
		size++; //更新规模记录
	}
	
	//读取栈顶元素，但不弹出
	public Object top() throws ExceptionStackEmpty{
		if(isEmpty()){
			throw new ExceptionStackEmpty("意外:栈空");
		}
		return top.getElem();
	}
	
	//弹出栈顶
	public Object pop() throws ExceptionStackEmpty{
		if(isEmpty()){
			throw new ExceptionStackEmpty("意外:栈空");
		}
		Object temp = top.getElem();
		top = top.getNext(); //更新首节点引用
		size--; //更新规模记录
		return temp;
	}
	public void Traversal(Node s){ //遍历
		if(s!=null)
		{
			System.out.print(s.getElem()+" ");
			Traversal(s.getNext());
		}
	}
}
