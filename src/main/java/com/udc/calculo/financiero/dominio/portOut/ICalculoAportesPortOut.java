package com.udc.calculo.financiero.dominio.portOut;

import com.udc.calculo.financiero.dominio.excepciones.CalculoAporteException;

public interface ICalculoAportesPortOut {

	/**
	 * aportes salud del empleado dependiente
	 * @return double 
	 */
	double aportesParafiscalesSalud() throws CalculoAporteException;

	/**
	 * aportes pension del pleado dependiente
	 * @return double 
	 */
	double AportesParafiscalesPension() throws CalculoAporteException;

	/**
	 * calculo de arl por tipo
	 * 1-riego simple valor 6000
	 * 2-riesgo moderado valor 10000
	 * 3-riego grave valor 20000
	 * @return 
	 */
	double arl() throws CalculoAporteException;//arl 

	/**
	 * total aportes parafiscales empleado independiente
	 * @return double
	 */
	double totalAporteParafiscales() throws CalculoAporteException;

	void setData(double salario, int tipoArl);

}