package com.bckndjsb.prj0001.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bckndjsb.prj0001.dto.GameMinDTO;
import com.bckndjsb.prj0001.entities.Game;
import com.bckndjsb.prj0001.repositories.GameRepository;

/** 
 * Este componente é o responsável pela logica do negócio (camada de serviço) e retorna um DTO
 * Retorna a lista (DTO) utilizando o repositorio e metodos herdados da propria JPA
 * Utilizei a anotação @Service para registrar o componente na aplicação automaticamente pelo framework
 * Utilizei a anotação @Autowired para injetar o componente do repositorio permitindo seu uso nesta classe.
 *  
 * @author Fabio Peres, fapdev77
 * 
 * @see services
 */
@Service
public class GameService {
	
	//Injetar o repositorio GameRepository para permitir acesso aos dados.
	@Autowired
	private GameRepository gameRepository;
	
	//Retorna a lista utilizando o repositorio e metodos herdados da propria JPA
	//Lembrnaod que um service deve retornar um DTO
	public List<GameMinDTO> findAll(){
		//Aqui eu pego a lista com todos os dados
		List<Game> games = gameRepository.findAll();
		//Aqui eu vou transformar a lista para um outro objeto com somente os campos que eu pretendo retornar
		List<GameMinDTO> gameMinDTO = games.stream().map(x -> new GameMinDTO(x)).toList();
		return gameMinDTO;
	}

}
