package com.dspesquisa.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dspesquisa.dto.RecordDTO;
import com.dspesquisa.dto.RecordIsertDTO;
import com.dspesquisa.services.RecordServices;

@RestController
@RequestMapping(value = "/records")
public class RecordResources {

	@Autowired
	private RecordServices recordService;

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordIsertDTO dto){
		RecordDTO newDTO = recordService.insert(dto);
		
		return new ResponseEntity<RecordDTO>(newDTO, HttpStatus.OK);
	}
}
