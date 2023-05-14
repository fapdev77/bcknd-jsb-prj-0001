package com.bckndjsb.prj0001.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Classe auxiliar para fazer a ligação da tabela game com a gameList
 * 
 * Utilizei a anotação @Embeddable para encapsular as duas chaves game_id e list_id e permitir que possa injetar ela em outra classe com um id unico.
 * Utilizei a anotação @ManyToOne para definir o tipo de relacionamento do campo 
 * Utilizei a anotação @JoinColumn para definir o nome da coluna na tabela que relaciona ao id
 * 
 * @author Fabio Peres, fapdev77
 * 
 * @see entities
 */
@Embeddable
public class BelongingPK {
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	

}
