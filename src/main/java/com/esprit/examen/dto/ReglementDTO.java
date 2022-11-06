package com.esprit.examen.dto;
import lombok.Data;

@Data
public class ReglementDTO {
	private Long idReglement;
	private float montantPaye;
	private float montantRestant;
	private Boolean payee;
}
