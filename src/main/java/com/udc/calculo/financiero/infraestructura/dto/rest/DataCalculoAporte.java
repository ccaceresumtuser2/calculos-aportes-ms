package com.udc.calculo.financiero.infraestructura.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DataCalculoAporte {
	private double totalSalud;
	private double totalPension;
	private double totalArl;
	private double totalParafiscales;
}
