package com.udc.calculo.financiero.dominio.portIn;

import com.udc.calculo.financiero.dominio.excepciones.CalculoAporteException;
import com.udc.calculo.financiero.infraestructura.dto.rest.CalculoAporteRequest;
import com.udc.calculo.financiero.infraestructura.dto.rest.DataCalculoAporte;

public interface CalculoAportesPortIn {
	DataCalculoAporte getCalculoAporteEmpleado(CalculoAporteRequest requestCalculoAporte) throws Exception;
}