package br.com.devnine.gestao_vagas.modules.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devnine.gestao_vagas.modules.company.dto.CreateJobInputDTO;
import br.com.devnine.gestao_vagas.modules.company.usecase.CreateJobUsecase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/job")
@AllArgsConstructor
public class JobController {
    private final CreateJobUsecase createJobUsecase;

    @PostMapping("")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobInputDTO input) {
        try {
            var result = this.createJobUsecase.execute(input);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
