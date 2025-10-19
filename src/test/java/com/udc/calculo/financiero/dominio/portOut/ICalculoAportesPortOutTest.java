package com.udc.calculo.financiero.dominio.portOut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.udc.calculo.financiero.dominio.excepciones.CalculoAporteException;
import com.udc.calculo.financiero.infraestructura.adapter.CalculoAportesAdapter;
import com.udc.calculo.financiero.infraestructura.constantes.Constantes;

class ICalculoAportesPortOutTest {
    @Test
    @DisplayName("Debe calcular salud correctamente")
    void testAporteSalud() {
        CalculoAportesAdapter adapter = new CalculoAportesAdapter(1_000_000, 1);
        double result = adapter.aportesParafiscalesSalud();
        assertEquals(40_000, result, "El aporte a salud debe ser 4% del salario");
    }

    @Test
    @DisplayName("Debe calcular pensión correctamente")
    void testAportePension() {
        CalculoAportesAdapter adapter = new CalculoAportesAdapter(1_000_000, 1);
        double result = adapter.AportesParafiscalesPension();
        assertEquals(40_000, result, "El aporte a pensión debe ser 4% del salario");
    }

    @Test
    @DisplayName("Debe calcular ARL tipo 1 correctamente")
    void testArlTipo1() throws CalculoAporteException {
        CalculoAportesAdapter adapter = new CalculoAportesAdapter(1_000_000, 1);
        double result = adapter.arl();
        assertEquals(Constantes.VALOR_ARL_TIPO_UNO, result);
    }

    @Test
    @DisplayName("Debe lanzar excepción si el tipo de ARL es inválido")
    void testArlInvalida() {
        CalculoAportesAdapter adapter = new CalculoAportesAdapter(1_000_000, 99);
        assertThrows(CalculoAporteException.class, adapter::arl, "Debe lanzar CalculoAporteException");
    }

    @Test
    @DisplayName("Debe calcular el total de aportes correctamente")
    void testTotalAportes() throws CalculoAporteException {
        CalculoAportesAdapter adapter = new CalculoAportesAdapter(1_000_000, 2);
        double expected = 40_000 + 40_000 + Constantes.VALOR_ARL_TIPO_DOS;
        double result = adapter.totalAporteParafiscales();
        assertEquals(expected, result);
    }

}
