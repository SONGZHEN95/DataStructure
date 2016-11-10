package com.tree;

/*
 * 迭代器接口
 */
public interface Iterator {
	boolean hasNext(); //检查迭代器中是否还有剩余元素
	Object getNext();//返回迭代器中的下一元素
}
