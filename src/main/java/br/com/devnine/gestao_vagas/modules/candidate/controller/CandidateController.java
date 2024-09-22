package br.com.devnine.gestao_vagas.modules.candidate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devnine.gestao_vagas.modules.candidate.dto.CreateCandidateInputDTO;
import br.com.devnine.gestao_vagas.modules.candidate.usecase.CreateCandidateUsecase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/candidate")
@AllArgsConstructor
public class CandidateController {
    private CreateCandidateUsecase createCandidateUsecase;

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCandidateInputDTO input) {
        try {
            var result = this.createCandidateUsecase.execute(input);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
