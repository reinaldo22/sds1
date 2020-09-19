package com.dspesquisa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dspesquisa.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

	

}
