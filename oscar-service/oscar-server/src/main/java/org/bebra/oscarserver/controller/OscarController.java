package org.bebra.oscarserver.controller;

import org.bebra.oscarserver.service.OscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.bebra.soacommons.model.dto.PersonDto;

import java.util.List;


@RestController
@RequestMapping("/api/v1/oscar")
public class OscarController {

    private final OscarService oscarService;

    @Autowired
    public OscarController(OscarService oscarService) {
        this.oscarService = oscarService;
    }

    @GetMapping("/directors/get-loosers")
    public ResponseEntity<List<PersonDto>> getLoosers() {
        return ResponseEntity.ok(oscarService.getLoosers());
    }

    @PostMapping("/movies/reward-thriller")
    public ResponseEntity<Void> rewardThriller() {
        oscarService.rewardThriller();
        return ResponseEntity.ok().build();
    }
}
