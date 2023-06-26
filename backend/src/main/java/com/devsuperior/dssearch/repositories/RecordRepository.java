package com.devsuperior.dssearch.repositories;

import com.devsuperior.dssearch.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
