package com.bckndjsb.prj0001.dto;

import com.bckndjsb.prj0001.entities.Game;

public class GameMinDTO {
	    private Long id;
	    private String title;
	    private Integer year;
	    private String imgUrl;
	    private String shortDescription;

	    public GameMinDTO() {
		}
	    
	    //Instanciar um objeto GameMinDTO utilizando como base os dados do Objeto entidade Game
		public GameMinDTO(Game entity) {
			this.id = entity.getId();
			this.title = entity.getTitle();
			this.year = entity.getYear();
			this.imgUrl = entity.getImgUrl();
			this.shortDescription = entity.getshortDescription();
		}
		
		//Para o DTO não há necessidade de metodos setters nesse projeto
		public Long getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public Integer getYear() {
			return year;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public String getShortDescription() {
			return shortDescription;
		}


}
