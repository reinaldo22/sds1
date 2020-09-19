package com.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspesquisa.dto.GameDTO;
import com.dspesquisa.model.Game;
import com.dspesquisa.repository.GameRepository;

@Service
public class GameServices {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameDTO> findAll(){
		List<Game>list = gameRepository.findAll();
		
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}
}
