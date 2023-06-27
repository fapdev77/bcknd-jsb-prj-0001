package com.bckndjsb.prj0001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bckndjsb.prj0001.entities.GameList;

/** 
 * Esta interface implementa os repositorio da base da lista de Games utilizando a interface do JPA Repository
 * Este componente é o responsável pelo acesso aos dados (camada de acesso a dados) utilizando a entidade GameList.
 * Devemos utilizar a anotacao @Modifying sempre que se for alterar/deletar/inserir algum dado, somente para o select nao ha necessidade.
 * Utilizei a anotacao @Query para executar um sql personalizado
 * 
 * @author Fabio Peres, fapdev77
 * 
 * @see repositories
 */
public interface GameListRepository extends JpaRepository<GameList, Long> {
	
	@Modifying
	@Query(nativeQuery = true,
		value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}
