package com.bckndjsb.prj0001.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bckndjsb.prj0001.dto.GameListDTO;
import com.bckndjsb.prj0001.entities.GameList;
import com.bckndjsb.prj0001.repositories.GameListRepository;

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
public class GameListService {
	
	//Injetar o repositorio GameRepository para permitir acesso aos dados.
	@Autowired
	private GameListRepository gameListRepository;
	
//	//Retorna o game requisitado pelo id
//	@Transactional(readOnly = true)
//	public GameDTO findById(Long id) {
//		//result recebe o game id encontrado
//		Game result = gameRepository.findById(id).get();
//		GameDTO gameDTO = new GameDTO(result);
//		return gameDTO;
//	}
	
	//Retorna a lista utilizando o repositorio e metodos herdados da propria JPA
	//Lembrnaod que um service deve retornar um DTO
	public List<GameListDTO> findAll(){
		//Aqui eu pego a lista com todos os dados
		List<GameList> games = gameListRepository.findAll();
		//Aqui eu vou transformar a lista para um outro objeto com somente os campos que eu pretendo retornar
		List<GameListDTO> gameListDTO = games.stream().map(x -> new GameListDTO(x)).toList();
		return gameListDTO;
	}

}
