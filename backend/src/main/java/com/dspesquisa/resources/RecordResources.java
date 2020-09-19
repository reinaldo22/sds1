package com.dspesquisa.resources;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordIsertDTO dto) {
		RecordDTO newDTO = recordService.insert(dto);

		return new ResponseEntity<RecordDTO>(newDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<Page<RecordDTO>> findAll(
			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {

		Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
		Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

		if (linesPerPage == 0) {
			linesPerPage = Integer.MAX_VALUE;
		}

		PageRequest pageRequest = PageRequest.of(page, linesPerPage);

		// (page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<RecordDTO> list = recordService.findByMoments(minDate, maxDate, pageRequest);

		return ResponseEntity.ok().body(list);
	}
}
