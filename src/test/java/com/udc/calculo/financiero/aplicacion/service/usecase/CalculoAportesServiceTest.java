package com.udc.calculo.financiero.aplicacion.service.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.udc.calculo.financiero.dominio.excepciones.CalculoAporteException;
import com.udc.calculo.financiero.dominio.portOut.ICalculoAportesPortOut;
import com.udc.calculo.financiero.infraestructura.dto.rest.DataCalculoAporte;
import com.udc.calculo.financiero.infraestructura.dto.rest.CalculoAporteRequest;

class CalculoAportesServiceTest {

	@Mock
    private ICalculoAportesPortOut calculoAportesPortOut;

    @InjectMocks
    private CalculoAportesService service;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Debe calcular correctamente los aportes con datos válidos")
    void testCalculoAportesOk() throws Exception {
        // Arrange
        CalculoAporteRequest request = new CalculoAporteRequest(3_000_000, 2);

        when(calculoAportesPortOut.aportesParafiscalesSalud()).thenReturn(120_000.0);
        when(calculoAportesPortOut.AportesParafiscalesPension()).thenReturn(120_000.0);
        when(calculoAportesPortOut.arl()).thenReturn(10_000.0);
        when(calculoAportesPortOut.totalAporteParafiscales()).thenReturn(250_000.0);

        // Act
        DataCalculoAporte result = service.getCalculoAporteEmpleado(request);

        // Assert
        assertEquals(120_000.0, result.getTotalSalud());
        assertEquals(120_000.0, result.getTotalPension());
        assertEquals(10_000, result.getTotalArl());
        assertEquals(250_000, result.getTotalParafiscales());
        verify(calculoAportesPortOut, times(1)).totalAporteParafiscales();
    }
//
    @Test
    @DisplayName("Debe lanzar excepción si salario es negativo")
    void testSalarioNegativo() {
        CalculoAporteRequest request = new CalculoAporteRequest(-500_000, 2);
        CalculoAporteException ex = assertThrows(
                CalculoAporteException.class,
                () -> service.getCalculoAporteEmpleado(request)
        );
        assertTrue(ex.getMessage().contains("salario negativo"));
        verifyNoInteractions(calculoAportesPortOut);
    }

    @Test
    @DisplayName("Debe lanzar excepción si tipo es inválido")
    void testTipoInvalido() {
        CalculoAporteRequest request = new CalculoAporteRequest(2_000_000, 9);
        CalculoAporteException ex = assertThrows(
                CalculoAporteException.class,
                () -> service.getCalculoAporteEmpleado(request)
        );
        assertTrue(ex.getMessage().contains("tipo inválido"));
        verifyNoInteractions(calculoAportesPortOut);
    }

    @Test
    @DisplayName("Debe lanzar excepción si salario negativo y tipo inválido simultáneamente")
    void testAmbosErrores() {
        CalculoAporteRequest request = new CalculoAporteRequest(-1000, 99);
        CalculoAporteException ex = assertThrows(
                CalculoAporteException.class,
                () -> service.getCalculoAporteEmpleado(request)
        );
        assertTrue(ex.getMessage().contains("*Error:salario negativo.*Error:tipo inválido (debe ser entre 1 y 3)."));
        
        verifyNoInteractions(calculoAportesPortOut);
    }
    
}
