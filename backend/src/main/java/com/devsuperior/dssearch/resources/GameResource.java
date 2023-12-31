package com.devsuperior.dssearch.resources;

import com.devsuperior.dssearch.dto.GameDTO;
import com.devsuperior.dssearch.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameResource {
    @Autowired
    private GameService gameService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<GameDTO>> findAll(){
        List<GameDTO> list = gameService.findAll();
        return ResponseEntity.ok().body(list);
    }

}
