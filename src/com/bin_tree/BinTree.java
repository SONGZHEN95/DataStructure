package com.bin_tree;

/*
 * 二叉树接口
 */
public interface BinTree {
	//返回树根
	public BinTreePosition getRoot();
	//判断是否数空
	public boolean isEmpty();
	//返回树的规模
	public int getSize();//即树根后代的数目
	//返回树(根)的高度
	public int getHeight();
	//前序遍历
	public Iterator elementsPreorder();
	//中序遍历
	public Iterator elementsInorder();
	//后序遍历
	public Iterator elementsPostorder();
	//层次遍历
	public Iterator elementsLevelorder();
}
