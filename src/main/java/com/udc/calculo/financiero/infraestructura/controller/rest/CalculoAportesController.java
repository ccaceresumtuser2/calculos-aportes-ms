package com.udc.calculo.financiero.infraestructura.controller.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udc.calculo.financiero.dominio.excepciones.AutorizacionException;
import com.udc.calculo.financiero.dominio.portIn.CalculoAportesPortIn;
import com.udc.calculo.financiero.infraestructura.dto.rest.CalculoAporteRequest;
import com.udc.calculo.financiero.infraestructura.dto.rest.CalculoAporteResponse;
import com.udc.calculo.financiero.infraestructura.dto.rest.DataCalculoAporte;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

//@SecurityRequirement(name = "bearerAuth") seguridad jwt bearer
@RestController
@RequestMapping("/api/calculo-aportes-parafiscales")
@AllArgsConstructor
@CrossOrigin
public class CalculoAportesController {
	private final CalculoAportesPortIn calculoAportesServicio;
      @Operation(
            summary = "Calcular aportes parafiscales de un empleado",
            description = "Recibe salario y tipo de ARL, devuelve el total de aportes de salud, pensión y riesgos laborales"
        )
        @ApiResponses({
        	@ApiResponse(responseCode = "200", description = "Solicitud exitosa"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor"),
            @ApiResponse(responseCode = "200", description = "Cálculo exitoso",
                content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = DataCalculoAporte.class),
                    examples = @ExampleObject(value = """
                    {
                        "status": "200 OK",
                        "message": "Solicitud Exitosa",
                        "data": {
                            "totalSalud": 120000.0,
                            "totalPension": 120000.0,
                            "totalArl": 6000.0,
                            "totalParafiscales": 246000.0
                        }
                    }
                    """))),
            @ApiResponse(responseCode = "400", description = "Error de validación",
                content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = """
                    {
                        "timestamp": "2025-10-19T14:25:41.236",
                        "error": "VALIDATION_ERROR",
                        "message": "salario: debe ser mayor que 0, tipo: debe estar entre 1 y 3",
                        "path": "/api/calculo-aportes-parafiscales",
                        "status": 400
                    }
                    """)))
        })
	 @PostMapping
	 public ResponseEntity<CalculoAporteResponse> crearUsuario(@Valid @RequestBody CalculoAporteRequest request) throws Exception{
//			 HttpServletRequest httpServletRequest) throws AutorizacionException,Exception {
//    	    String header = httpServletRequest.getHeader("Authorization");    	    //autorizacion bearer
//    	  	if (header == null || !header.startsWith("Bearer ")) {
//               throw new AutorizacionException("No se encuentra Autorizado para ejecutar el Servicio");
//            }
		 	DataCalculoAporte data = calculoAportesServicio.getCalculoAporteEmpleado(request);
		 	CalculoAporteResponse response = new CalculoAporteResponse();
		 	response.setStatus(HttpStatus.OK.toString());
		 	response.setMessage("Calculo Exitosa");
		 	response.setData(data);
	        return ResponseEntity.ok(response);
	 }
	
}
