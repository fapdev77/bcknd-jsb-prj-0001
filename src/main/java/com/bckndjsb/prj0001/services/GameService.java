package com.bckndjsb.prj0001.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bckndjsb.prj0001.dto.GameDTO;
import com.bckndjsb.prj0001.dto.GameMinDTO;
import com.bckndjsb.prj0001.entities.Game;
import com.bckndjsb.prj0001.projections.GameMinProjection;
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
	
	//Retorna o game requisitado pelo id
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		//result recebe o game id encontrado
		Game result = gameRepository.findById(id).get();
		GameDTO gameDTO = new GameDTO(result);
		return gameDTO;
	}
	
	//Retorna a lista utilizando o repositorio e metodos herdados da propria JPA
	//Lembrnaod que um service deve retornar um DTO
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		//Aqui eu pego a lista com todos os dados
		List<Game> games = gameRepository.findAll();
		//Aqui eu vou transformar a lista para um outro objeto com somente os campos que eu pretendo retornar
		List<GameMinDTO> gameMinDTO = games.stream().map(x -> new GameMinDTO(x)).toList();
		return gameMinDTO;
	}

	//Retorna a lista utilizando o repositorio e metodos herdados da propria JPA
	//Lembrnaod que um service deve retornar um DTO
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		//Aqui eu pego a lista com todos os dados
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		//Aqui eu vou transformar a lista para um outro objeto com somente os campos que eu pretendo retornar
		List<GameMinDTO> result = games.stream().map(x -> new GameMinDTO(x)).toList();
		return result;
	}

}
