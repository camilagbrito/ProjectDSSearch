package com.devsuperior.dssearch.services;

import com.devsuperior.dssearch.dto.RecordDTO;
import com.devsuperior.dssearch.dto.RecordInsertDTO;
import com.devsuperior.dssearch.entities.Game;
import com.devsuperior.dssearch.entities.Record;
import com.devsuperior.dssearch.repositories.GameRepository;
import com.devsuperior.dssearch.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
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

}
