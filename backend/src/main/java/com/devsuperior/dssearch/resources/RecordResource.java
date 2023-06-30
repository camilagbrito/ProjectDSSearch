package com.devsuperior.dssearch.resources;

import java.time.Instant;

import com.devsuperior.dssearch.dto.RecordDTO;
import com.devsuperior.dssearch.dto.RecordInsertDTO;
import com.devsuperior.dssearch.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/records")
public class RecordResource {
    @Autowired
    private RecordService service;

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){
        RecordDTO newDTO = service.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction){

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if (linesPerPage == 0) {
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<RecordDTO> list = service.findByMoment(minDate, maxDate, pageRequest);
        return ResponseEntity.ok().body(list);
    }

}
