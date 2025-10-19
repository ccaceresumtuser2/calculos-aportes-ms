package com.udc.calculo.financiero.dominio.excepciones;


/**
 *
 * @author caceresc
 */
public class ValidationException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>CalculoAporteException</code> without
     * detail message.
     */
    public ValidationException() {
    }

    /**
     * Constructs an instance of <code>CalculoAporteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ValidationException(String msg) {
        super(msg);
    }
}