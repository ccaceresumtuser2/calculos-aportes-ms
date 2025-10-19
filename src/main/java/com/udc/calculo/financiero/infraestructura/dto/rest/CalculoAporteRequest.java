package com.udc.calculo.financiero.infraestructura.dto.rest;

import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CalculoAporteRequest {
       // @Positive(message = "El salario debe ser mayor que cero")
	    @Schema(example = "3000000")
	    private double salario;
	   
	  // @NotBlank(message = "El tipo es obligatorio")
//	    @Min(value = 1, message = "El tipo debe ser entre 1 y 3")
//	    @Max(value = 3, message = "El tipo debe ser entre 1 y 3")
	    @Schema(example = "1")
	    private int tipo;
}
