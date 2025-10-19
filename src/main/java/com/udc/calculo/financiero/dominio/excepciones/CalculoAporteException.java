package com.udc.calculo.financiero.dominio.excepciones;


/**
 *
 * @author caceresc
 */
public class CalculoAporteException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>CalculoAporteException</code> without
     * detail message.
     */
    public CalculoAporteException() {
    }

    /**
     * Constructs an instance of <code>CalculoAporteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CalculoAporteException(String msg) {
        super(msg);
    }
}