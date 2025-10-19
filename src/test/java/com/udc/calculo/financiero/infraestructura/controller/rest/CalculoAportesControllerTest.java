package com.udc.calculo.financiero.infraestructura.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udc.calculo.financiero.aplicacion.service.usecase.CalculoAportesService;
import com.udc.calculo.financiero.infraestructura.dto.rest.CalculoAporteRequest;
import com.udc.calculo.financiero.infraestructura.dto.rest.DataCalculoAporte;
import org.springframework.http.MediaType;
@WebMvcTest(controllers = CalculoAportesController.class)
class CalculoAportesControllerTest {

	  @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private CalculoAportesService service;

	    @Test
	    @DisplayName("Escenario Api Rest Calculo Parafiscales Empleado OK 200")
	    void testCalculoAportes_OK_200() throws Exception {
	        // Mock del servicio
	        DataCalculoAporte mockResponse = new DataCalculoAporte();
	        mockResponse.setTotalSalud(120000.0);
	        mockResponse.setTotalPension(120000.0);
	        mockResponse.setTotalArl(6000.0);
	        mockResponse.setTotalParafiscales(246000.0);

	        when(service.getCalculoAporteEmpleado(any())).thenReturn(mockResponse);

	        // Ejecuta la petición simulada
	        mockMvc.perform(post("/api/calculo-aportes-parafiscales")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content("""
	                    {
	                      "salario": 3000000,
	                      "tipo": 1
	                    }
	                """))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("$.data.totalPension").value(120000))
	                .andExpect(jsonPath("$.data.totalSalud").value(120000))
	                .andExpect(jsonPath("$.data.totalArl").value(6000))
	                .andExpect(jsonPath("$.data.totalParafiscales").value(246000));
	    }
}
