package com.example.examen.exception;


public class ObjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	    
		public ObjectNotFoundException() {
			// TODO Auto-generated constructor stub
		}
		
		public ObjectNotFoundException(String message) {
			// TODO Auto-generated constructor stub
			super(message);
		}
		public ObjectNotFoundException(String message, Throwable cause) {
			// TODO Auto-generated constructor stub
			super(message,cause);
		}
}
