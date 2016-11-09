package com.tree;

public class TreeLinkedList implements Tree{
	
	private Object element;//树根节点
	private TreeLinkedList parent,firstChild,nextSibling;//父亲、长子以及最大弟弟
	
	public TreeLinkedList(Object e,TreeLinkedList p,TreeLinkedList c,TreeLinkedList s) { //构造方法
		element = e;
		parent = p;
		firstChild = c;
		nextSibling = s;
	}
	
	public TreeLinkedList(){ //(单节点树)构造方法
		this(null,null,null,null);
	}
	
	//返回当前节点中存放的对象
	public Object getElem() { 
		return element;
	}
	//将对象Obj存入当前节点,并返回此前的内容
	public Object setElem(Object obj) {
		Object a = element;
		element = obj;
		return a;
	}

	//返回当前节点的父节点,对于根节点,则返回Null;
	public TreeLinkedList getParent() {
		return parent;
	}

	//返回当前节点长子,若没有孩子,则返回null
	public TreeLinkedList getFirstChild() {
		return firstChild;
	}

	//返回当前节点的最大弟弟,若没有弟弟,则返回Null
	public TreeLinkedList getNextSibling() {
		return nextSibling;
	}

	//返回当前节点后代元素数目,即以当前节点为根的子树的规模
	public int getSize() {
		int size = 1;
		TreeLinkedList subtree = firstChild;//从长子开始
		while(subtree!= null){ //依次
			size+=subtree.getSize();//累加
			subtree = subtree.getNextSibling(); //所有孩子的后代数目
		}
		return size;
	}

	//返回当前节点的高度
	public int getHeight() {
		int height = -1;
		TreeLinkedList subtree = firstChild;
		while(subtree!=null){
			height = Math.max(height, subtree.getHeight());//在所有孩子中取最大高度
			subtree = subtree.getNextSibling();
		}
		return height+1; //即可得到当前节点的高度
	}

	public int getDepth() {
		int depth = 0;
		TreeLinkedList p = parent;//从父亲开始
		while(p!=null){ //依次
			depth++;
			p = p.getParent();//访问各个真祖先
		}
		return depth;//真祖先的数目,即为当前节点的深度
	}
	
	//前序遍历
	public void PreorderTraversal(TreeLinkedList v){
		if(null!=v) System.out.println(v.getElem());
		for(TreeLinkedList u=v.getFirstChild();u!=null;u=u.getNextSibling()){
			PreorderTraversal(u); //前序遍历v的各棵子树
		}
	}
	
	//后序遍历
	public void PostorderTraversal(TreeLinkedList v){
		if(v!=null){
			for(TreeLinkedList u=v.getFirstChild();u!=null;u=u.getNextSibling()) //先访问孩子节点
				PostorderTraversal(u);
			System.out.println(v.getElem());//再访问V
		}
	}

}
