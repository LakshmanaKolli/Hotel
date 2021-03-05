package com.epam.hotel.exception;

public class HotelNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5691609565765256089L;

	public HotelNotFoundException(String msg) {
		super(msg);
	}
}
