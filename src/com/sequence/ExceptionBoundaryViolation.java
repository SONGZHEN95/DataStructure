package com.sequence;

public class ExceptionBoundaryViolation extends RuntimeException { //秩越界
	public ExceptionBoundaryViolation(String err){
		super(err);
	}
}
