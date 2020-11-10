package com.packtpub.wflydevelopment.chapter3.exception;


public class SeatBookedException extends Exception {
	private static final long serialVersionUID = -1887747245960350733L;

	public SeatBookedException() {
	}

	public SeatBookedException(String arg0) {
		super(arg0);
	}

	public SeatBookedException(Throwable arg0) {
		super(arg0);
	}

	public SeatBookedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SeatBookedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}