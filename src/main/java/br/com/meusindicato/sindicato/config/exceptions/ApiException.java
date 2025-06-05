package br.com.meusindicato.sindicato.config.exceptions;

public class ApiException extends RuntimeException{

	private static final long serialVersionUID = -409889946864421783L;

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(String message) {
		super(message);
	}
	
}
