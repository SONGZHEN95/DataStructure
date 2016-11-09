package com.sequence;

/*
 * 基于数组的向量实现
 */
public class Vector_Array implements Vector {

	private final int N = 1024; //数组的容量
	private int n; //向量的实际规模
	private Object[] A; //对象数组
	
	public Vector_Array(){ //构造函数
		A = new Object[N];
		n = 0;
	}
	
	public int getSize() { //返回向量中元素数目
		return n;
	}

	
	public boolean isEmpty() { //判断向量是否为空
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

	
	public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation { //在插入obj,作为秩为r的元素;返回该元素
		if(r<0 || r>=n) throw new ExceptionBoundaryViolation("异常:秩越界");
		if(n>=N) throw new ExceptionBoundaryViolation("异常:数组溢出");
		for(int i=n;i>r;i--)
			A[i] = A[i-1];  //后续元素依次后移
		A[r] = obj;
		n++; //更新当前规模
		return obj;
	}

	
	public Object removeAtRank(int r) throws ExceptionBoundaryViolation { //删除秩为r的元素
		if(r<0 || r>=n) throw new ExceptionBoundaryViolation("异常:秩越界");
		Object bak = A[r];
		for(int i=r;i<n;i++)
			A[i]=A[i+1];  //后续元素依次前移
		n--; //更新当前规模 
		return bak;
	}

}
