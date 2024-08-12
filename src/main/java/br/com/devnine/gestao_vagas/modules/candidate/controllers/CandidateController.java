package br.com.devnine.gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody CandidateEntity candidateEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateEntity);

    }

}
