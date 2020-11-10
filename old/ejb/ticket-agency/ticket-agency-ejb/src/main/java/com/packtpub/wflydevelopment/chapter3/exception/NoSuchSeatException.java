/**
 * 
 */
package com.packtpub.wflydevelopment.chapter3.exception;

/**
 * @author Evad
 *
 */

public class NoSuchSeatException extends Exception {
	private static final long serialVersionUID = -1887747245960350733L;

	public NoSuchSeatException() {
	}

	public NoSuchSeatException(String arg0) {
		super(arg0);
	}

	public NoSuchSeatException(Throwable arg0) {
		super(arg0);
	}

	public NoSuchSeatException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSuchSeatException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}