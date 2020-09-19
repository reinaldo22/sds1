package com.dspesquisa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dspesquisa.model.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	

}
