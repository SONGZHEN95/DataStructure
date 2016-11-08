package com.stack;

/*
 * 当试图对满栈应用push()方法时，该异常将被抛出
 */
public class ExceptionStackFull extends RuntimeException {
	public ExceptionStackFull(String arg0) {
		super(arg0);
	}
}
