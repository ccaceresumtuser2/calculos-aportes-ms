package com.udc.calculo.financiero.infraestructura.configuracion;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * RFC 7807 – Problem Details for HTTP APIs

	📘 Es el estándar oficial de IETF para representar errores en APIs HTTP.
	Define una estructura JSON uniforme para todos los errores, conocida como "Problem Details".
	{
		  "type": "https://example.com/probs/invalid-input",
		  "title": "Invalid input data",
		  "status": 400,
		  "detail": "The field 'tipo' must be between 1 and 3",
		  "instance": "/api/calculo-aportes-parafiscales"
    }
    Campo		Tipo	Descripción
	type	    URI	    Tipo de problema (único y descriptivo, puede ser un enlace con más detalles)
	title	    String  Descripción breve y genérica del error
	status	    Integer	Código HTTP del error
	detail	    String	Mensaje detallado del error
	instance	String	Ruta o endpoint que causó el error

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private LocalDateTime timestamp;  // Cuándo ocurrió el error
    private String error;            // Código del error (por ejemplo, VALIDATION_ERROR o INTERNAL_ERROR)
    private String message;           // Descripción del error    
    private String path;              // Ruta del endpoint donde ocurrió el error
    private int status;
}