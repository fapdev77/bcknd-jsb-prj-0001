package com.bckndjsb.prj0001.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Implementar o ORM da tabela Game 
 * Esta classe implementa os detalhes de um Jogo (Game) contendo todos os seus detalhes.
 * Aqui definimos todos os campos que existem na tabela game
 * 
 * Utilizei a anotação @Entity para configurar essa classe para que seja equivalente a uma tabela no banco de dados relacional;
 * Utilizei a anotação @Table para definir o nome da tabela no bando de dados que essa classe esta relacionada;
 * Utilizei a anotação @Id e @GeneratedValue para definir a chave primária da tabela e como auto incremental;
 * Utilizei a anotação @Column para definir um nome customizado game_year no bando de dados, pois a palavra year pode causar problemas no SQL por ser uma palavra reservada;
 * 
 * @author Fabio Peres, fapdev77
 * 
 * @see entities
 */
@Entity
@Table(name = "tb_game")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String platforms;
    private String imgUrl;
    private String shotDescription;
    private String longDescription;

    public Game() {
    }

    //este construtor recebe todos os parametros para criar o objeto ja com os valores
    public Game(Long id, String title, Integer year, String genre, String platforms, String imgUrl,
            String shotDescription, String longDescription) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.platforms = platforms;
        this.imgUrl = imgUrl;
        this.shotDescription = shotDescription;
        this.longDescription = longDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShotDescription() {
        return shotDescription;
    }

    public void setShotDescription(String shotDescription) {
        this.shotDescription = shotDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    //Definir equals e hashCode personalizado que permite podermos comparar os objetos e verificar se
    //dois games são os mesmos por exemplo.
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
    
}
