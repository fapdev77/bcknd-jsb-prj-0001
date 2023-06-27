package com.bckndjsb.prj0001.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bckndjsb.prj0001.dto.GameListDTO;
import com.bckndjsb.prj0001.entities.GameList;
import com.bckndjsb.prj0001.projections.GameMinProjection;
import com.bckndjsb.prj0001.repositories.GameListRepository;
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
public class GameListService {
	
	//Injetar o repositorio GameListRepository para permitir acesso aos dados.
	@Autowired
	private GameListRepository gameListRepository;
	
	//Injetar o repositorio GameRepository para permitir fazer a movimentacao da ordem dos jogos dentro da lista
	@Autowired
	private GameRepository gameRepository;
	
//	//Retorna o game requisitado pelo id
//	@Transactional(readOnly = true)
//	public GameDTO findById(Long id) {
//		//result recebe o game id encontrado
//		Game result = gameRepository.findById(id).get();
//		GameDTO gameDTO = new GameDTO(result);
//		return gameDTO;
//	}
	
	//Retorna a lista utilizando o repositorio e metodos herdados da propria JPA
	//Lembrando que um service deve retornar um DTO
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		//Aqui eu pego a lista com todos os dados
		List<GameList> games = gameListRepository.findAll();
		//Aqui eu vou transformar a lista para um outro objeto com somente os campos que eu pretendo retornar
		List<GameListDTO> gameListDTO = games.stream().map(x -> new GameListDTO(x)).toList();
		return gameListDTO;
	}
	
	//Metodo que controla a reordenacao da lista
	@Transactional
	public void move(Long listId,int sourceIndex, int destinationIndex) {
		//Objeto list vai contar a lista inicial
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		//Para fazer a reordenacao, primeiro removemos o item da lista para depois ser reinserido na nova posicao
		GameMinProjection obj = list.remove(sourceIndex);
		//Reinserir o objeto na nova posicao, o tipo lista ja faz a reordenacao automaticamente 
		list.add(destinationIndex, obj);
		
		//Agora que ja temos a nova lista em memoria, vamos salvar as mudancas no banco de dados
		//primeiro identificamos o menor e maior indice, so precisamos modificar o que esta dentro desse range
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		//Agora fazemos uma iteracao entre os valores min ate max para atualizar a lista no banco de dados
		for (int i = min; i <= max; i++) {
			//Executa o metodo que faz o update passando o id da lista, id do item e novo indice do item
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
		
	}

}
