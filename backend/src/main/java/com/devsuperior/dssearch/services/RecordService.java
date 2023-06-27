package com.devsuperior.dssearch.services;

import com.devsuperior.dssearch.dto.RecordDTO;
import com.devsuperior.dssearch.dto.RecordInsertDTO;
import com.devsuperior.dssearch.entities.Game;
import com.devsuperior.dssearch.entities.Record;
import com.devsuperior.dssearch.repositories.GameRepository;
import com.devsuperior.dssearch.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepository repository;

    @Autowired
    private GameRepository gameRepository;
    @Transactional
    public RecordDTO insert(RecordInsertDTO dto){
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());
        Game game = gameRepository.getOne(dto.getGameId());
        entity.setGame(game);

        entity = repository.save(entity);

        return new RecordDTO(entity);
    }
    @Transactional(readOnly = true)
    public Page<RecordDTO> findByMoment(Instant minDate, Instant maxDate, PageRequest pageRequest) {
        return repository.findByMoment(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
    }
}
