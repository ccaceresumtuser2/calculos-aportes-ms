package com.udc.calculo.financiero.infraestructura.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CalculoAporteResponse extends GenericReponseDto{
	private DataCalculoAporte data;
}
