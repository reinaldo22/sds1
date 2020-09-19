package com.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dspesquisa.dto.GameDTO;
import com.dspesquisa.model.Game;
import com.dspesquisa.services.GameServices;

@RestController
@RequestMapping(value = "/game")
public class GameResources {

	@Autowired
	private GameServices gameService;

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<GameDTO>> findAll() {

		List<GameDTO> list = gameService.findAll();

		return new ResponseEntity<List<GameDTO>>(list, HttpStatus.OK);
	}

}
