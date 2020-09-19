package com.dspesquisa.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dspesquisa.model.Game;
import com.dspesquisa.model.enums.Platform;

public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private Platform platform;
	
	public GameDTO() {
		super();
	}
	

	public GameDTO(Game entity) {
		 id = entity.getId();
		 title = entity.getTitle();
		 platform = entity.getPlatform();
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

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	
}
