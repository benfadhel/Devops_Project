package com.esprit.examen.controllers;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esprit.examen.dto.ProduitDTO;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.services.IProduitService;

import io.swagger.annotations.Api;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;
	@Autowired
	private ModelMapper modelMapper;
	
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		List<Produit> list = produitService.retrieveAllProduits();
		return list;
	}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	/* Ajouter en produit tout en lui affectant la catégorie produit et le stock associés */
	// http://localhost:8089/SpringMVC/produit/add-produit/{idCategorieProduit}/{idStock}
	@PostMapping("/add-produit")
	@ResponseBody
	public Produit addProduit(@RequestBody ProduitDTO p) {
		Produit produit = modelMapper.map(p,Produit.class);
		return produitService.addProduit(produit);
	}


	// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	// http://localhost:8089/SpringMVC/produit/modify-produit/{idCategorieProduit}/{idStock}
	@PutMapping("/modify-produit")
	@ResponseBody
	public Produit modifyProduit(@RequestBody ProduitDTO p) {
		Produit produitS= modelMapper.map(p,  Produit.class);
	
		return produitService.updateProduit(produitS);
	}
	





}
