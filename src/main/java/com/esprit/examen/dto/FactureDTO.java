package com.esprit.examen.dto;
import lombok.Data;

@Data
public class FactureDTO {
	private Long idFacture;
	private float montantRemise;
	private float montantFacture;
}
