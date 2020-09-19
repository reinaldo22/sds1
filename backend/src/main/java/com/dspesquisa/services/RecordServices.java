package com.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspesquisa.dto.RecordDTO;
import com.dspesquisa.dto.RecordIsertDTO;
import com.dspesquisa.model.Game;
import com.dspesquisa.model.Record;
import com.dspesquisa.repository.GameRepository;
import com.dspesquisa.repository.RecordRepository;

@Service
public class RecordServices {

	@Autowired
	private RecordRepository recordRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional
	public RecordDTO insert(RecordIsertDTO dto) {
		Record entity = new Record();

		entity.setAge(dto.getAge());
		entity.setName(dto.getName());
		entity.setMoment(Instant.now());

		Game game = gameRepository.getOne(dto.getGameId());

		entity.setGame(game);
		entity = recordRepository.save(entity);

		return new RecordDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {

		return recordRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}

}
