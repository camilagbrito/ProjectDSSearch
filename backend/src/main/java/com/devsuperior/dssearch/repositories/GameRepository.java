package com.devsuperior.dssearch.repositories;

import com.devsuperior.dssearch.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}
