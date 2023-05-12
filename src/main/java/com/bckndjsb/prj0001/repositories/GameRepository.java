package com.bckndjsb.prj0001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bckndjsb.prj0001.entities.Game;

/** 
 * Esta interface implementa os repositorio da base de Games utilizando a interface do JPA Repository
 * Este componente é o responsável pelo acesso aos dados (camada de acesso a dados) utilizando a entidade Game.
 *  
 * @author Fabio Peres, fapdev77
 * 
 * @see repositories
 */
public interface GameRepository extends JpaRepository<Game, Long> {

}
