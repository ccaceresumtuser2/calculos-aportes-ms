package com.udc.calculo.financiero.infraestructura.adapter;

import org.springframework.stereotype.Component;

import com.udc.calculo.financiero.dominio.excepciones.CalculoAporteException;
import com.udc.calculo.financiero.dominio.portOut.ICalculoAportesPortOut;
import com.udc.calculo.financiero.infraestructura.constantes.Constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Component
@Setter
@Getter
public class CalculoAportesAdapter implements ICalculoAportesPortOut {
	/**
     * atributos de la clase
     */
    //salario del empleado
    private double salario;
    //tipo de arl
    private int tipoArl; 
    
    @Override
    public void setData(double salario,int tipoArl) {
    	this.salario = salario;
    	this.tipoArl = tipoArl;
    }
    /**
     * aportes salud del empleado dependiente
     * @return double 
     */
    @Override
	public double aportesParafiscalesSalud(){
        return calculoSaludOrPension();
    }
    /**
     * aportes pension del pleado dependiente
     * @return double 
     */
    @Override
	public double AportesParafiscalesPension(){
        return calculoSaludOrPension();
    }
    /**
     * Computo de salud o pension
     * @return double 
     */
    private double calculoSaludOrPension(){
       return salario*0.04;
    }
    /**
     * calculo de arl por tipo
     * 1-riego simple valor 6000
     * 2-riesgo moderado valor 10000
     * 3-riego grave valor 20000
     * @return 
     */
    @Override
	public double arl() throws CalculoAporteException{
    double valorArl=0;
    switch(tipoArl){
        case 1 -> valorArl=Constantes.VALOR_ARL_TIPO_UNO;
        case 2 -> valorArl=Constantes.VALOR_ARL_TIPO_DOS;
        case 3 -> valorArl=Constantes.VALOR_ARL_TIPO_TRES;
        default->throw new CalculoAporteException("Arl invalida");
    }//switch
        return valorArl;
    }//arl 
    /**
     * total aportes parafiscales empleado independiente
     * @return double
     */
    @Override
    public double totalAporteParafiscales() throws CalculoAporteException{
        return aportesParafiscalesSalud()+AportesParafiscalesPension()+arl();
    }    

}
