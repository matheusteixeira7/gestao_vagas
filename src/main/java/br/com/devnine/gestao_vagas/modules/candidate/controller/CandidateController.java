package br.com.devnine.gestao_vagas.modules.candidate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devnine.gestao_vagas.modules.candidate.domain.CandidateEntity;
import br.com.devnine.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.devnine.gestao_vagas.modules.candidate.usecase.CreateCandidateUsecase;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private CreateCandidateUsecase createCandidateUsecase;

    public CandidateController(CandidateRepository candidateRepository) {
        this.createCandidateUsecase = new CreateCandidateUsecase(candidateRepository);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUsecase.execute(candidateEntity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
