package com.bckndjsb.prj0001.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bckndjsb.prj0001.dto.GameDTO;
import com.bckndjsb.prj0001.dto.GameMinDTO;
import com.bckndjsb.prj0001.services.GameService;

/** 
 * Este componente é o responsável disponibiliza os end points de games da api para serem utilizadas.
 * Seguindo o conceito de camadas, devemos injetar o serviço que sera utilizado nesse componente
 * @RestController
 * Utilizei a anotação @RestController para registrar o componente na aplicação como um controlador
 * Utilizei a anotação @RequestMapping(value = "/games") para definir o end point na API que sera mapeado nesse controlador
 * Utilizei a anotação @Autowired para injetar o componente do service permitindo seu uso nesta classe.
 * Utilizei a anotação @GetMapping para definir a ação quando receber uma requisição do tipo GET
 *  
 * @author Fabio Peres, fapdev77
 * 
 * @see controllers
 */

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	@GetMapping(value = "/{id}")
	public GameDTO findByid(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}

}
