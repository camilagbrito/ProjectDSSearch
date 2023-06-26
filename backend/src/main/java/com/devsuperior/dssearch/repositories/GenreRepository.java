package com.devsuperior.dssearch.repositories;

import com.devsuperior.dssearch.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
