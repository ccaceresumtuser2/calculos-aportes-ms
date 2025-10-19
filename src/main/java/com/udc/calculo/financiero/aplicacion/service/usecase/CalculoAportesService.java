package com.udc.calculo.financiero.aplicacion.service.usecase;

import org.springframework.stereotype.Service;

import com.udc.calculo.financiero.dominio.excepciones.CalculoAporteException;
import com.udc.calculo.financiero.dominio.excepciones.ValidationException;
import com.udc.calculo.financiero.dominio.portIn.CalculoAportesPortIn;
import com.udc.calculo.financiero.dominio.portOut.ICalculoAportesPortOut;
import com.udc.calculo.financiero.infraestructura.dto.rest.DataCalculoAporte;
import com.udc.calculo.financiero.infraestructura.constantes.Constantes;
import com.udc.calculo.financiero.infraestructura.dto.rest.CalculoAporteRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CalculoAportesService implements CalculoAportesPortIn {
	private final ICalculoAportesPortOut calculoAportesPortOut;
	
	public DataCalculoAporte getCalculoAporteEmpleado(CalculoAporteRequest request) throws Exception {		
		validacionEntradaDatos(request);
		if(request.getSalario()<Constantes.SALARIO_MINIMO) {
			throw new CalculoAporteException("Salario no debe ser inferior al Salario Minimo con valor de "+Constantes.SALARIO_MINIMO);
		}
		calculoAportesPortOut.setData(request.getSalario(),request.getTipo());
		double salud=calculoAportesPortOut.aportesParafiscalesSalud();
		double pension=calculoAportesPortOut.AportesParafiscalesPension();
		double arl=calculoAportesPortOut.arl();
		double totalParafiscales = calculoAportesPortOut.totalAporteParafiscales();
		DataCalculoAporte dataCalculoAporte = new DataCalculoAporte();
		dataCalculoAporte.setTotalSalud(salud);
		dataCalculoAporte.setTotalPension(pension);
		dataCalculoAporte.setTotalArl(arl);
		dataCalculoAporte.setTotalParafiscales(totalParafiscales);		
		return dataCalculoAporte;
	}
	
	private void validacionEntradaDatos(CalculoAporteRequest requestCalculoAporte) throws ValidationException {
		StringBuilder errores = new StringBuilder();
	    if (requestCalculoAporte.getSalario() < 0) {
	        errores.append(Constantes.MENSAJE_ERROR_SALARIO);
	    }
	    errores.append("");
	    if (requestCalculoAporte.getTipo() < 1 || requestCalculoAporte.getTipo() > 3) {
	        errores.append(Constantes.MENSAJE_ERROR_TIPO_ARL);
	    }

	    if (errores.length() > 0) {
	        throw new ValidationException(errores.toString().trim());
	    }
	}
}
