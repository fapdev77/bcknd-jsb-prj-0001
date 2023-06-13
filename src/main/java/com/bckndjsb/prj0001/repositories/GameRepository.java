package com.bckndjsb.prj0001.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bckndjsb.prj0001.entities.Game;
import com.bckndjsb.prj0001.projections.GameMinProjection;

/** 
 * Esta interface implementa os repositorio da base de Games utilizando a interface do JPA Repository
 * Este componente é o responsável pelo acesso aos dados (camada de acesso a dados) utilizando a entidade Game.
 * Utilizei a anotação @Query para fazer uma consulta SQL personalizada
 * 
 * @author Fabio Peres, fapdev77
 * 
 * @see repositories
 */
public interface GameRepository extends JpaRepository<Game, Long> {

	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
}
