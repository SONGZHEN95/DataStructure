package com.sequence;

/*
 * 基于可扩充数组的向量实现
 */
public class Vector_ExtArray implements Vector {
	
	private int N= 8; //数组的容量,可不断增加
	private int n; //向量的实际规模
	private Object A[]; //对象数组
	
	public Vector_ExtArray() { //构造函数
		A = new Object[N];
		n = 0;
	}

	public int getSize() {	//获取向量规模
		return n;
	}

	public boolean isEmpty(){ //向量是否为空
		return (n==0)?true:false;
	}

	public Object getAtRank(int r) throws ExceptionBoundaryViolation { //返回秩为r处的元素
		if(r<0 || r>=n) throw new ExceptionBoundaryViolation("异常:秩越界");
		return A[r];
	}

	
	public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation { //将秩为r处的元素替换为obj
		if(r<0 || r>=n) throw new ExceptionBoundaryViolation("异常:秩越界");
		Object bak = A[r];
		A[r] = obj;
		return bak;
	}

	public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation { //插入obj,秩为r
		if(r<0 || r>n) throw new ExceptionBoundaryViolation("异常:秩越界");
		if(n>=N){ //空间溢出的处理
			N*=2;
			Object B[] = new Object[N]; //开辟一个容量加倍的数组
			for(int i=0;i<n;i++) B[i]=A[i]; //A[]中内容复制至B[];
			A=B; //用B替换A 原A会被自动回收
		}
		for(int i=n;i>r;i--) A[i]=A[i-1];
		A[r] = obj; //插入
		n++; //更新当前规模
		return obj;
	}

	
	public Object removeAtRank(int r) throws ExceptionBoundaryViolation { //删除秩为r的元素
		if(r<0 || r>=n) throw new ExceptionBoundaryViolation("异常:秩越界");
		Object bak = A[r];
		for(int i=r;i<n-1;i++) A[i]=A[i+1]; //后续元素顺次前移
		n--; //更新当前规模
		return bak;
	}
}
