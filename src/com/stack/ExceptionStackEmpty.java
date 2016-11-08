package com.stack;

/*
 * 当试图对空栈应用pop或top方法时将抛出的异常
 */
public class ExceptionStackEmpty extends RuntimeException {
	public ExceptionStackEmpty(String arg0) {
		super(arg0);
	}
}

