package com.udc.calculo.financiero.dominio.excepciones;


/**
 *
 * @author caceresc
 */
public class AutorizacionException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>CalculoAporteException</code> without
     * detail message.
     */
    public AutorizacionException() {
    }

    /**
     * Constructs an instance of <code>CalculoAporteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AutorizacionException(String msg) {
        super(msg);
    }
}