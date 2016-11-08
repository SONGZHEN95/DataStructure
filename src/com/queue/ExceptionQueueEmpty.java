package com.queue;

public class ExceptionQueueEmpty extends RuntimeException {
	public ExceptionQueueEmpty(String message) {
		super(message);
	}
}
