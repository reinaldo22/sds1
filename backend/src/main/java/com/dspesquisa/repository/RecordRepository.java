package com.dspesquisa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dspesquisa.model.Record;

public interface RecordRepository extends JpaRepository<Record, Long>{

	

}
