package com.bckndjsb.prj0001.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bckndjsb.prj0001.entities.GameList;

/** 
 * Esta interface implementa os repositorio da base da lista de Games utilizando a interface do JPA Repository
 * Este componente é o responsável pelo acesso aos dados (camada de acesso a dados) utilizando a entidade GameList.
 *  
 * @author Fabio Peres, fapdev77
 * 
 * @see repositories
 */
public interface GameListRepository extends JpaRepository<GameList, Long> {

}
