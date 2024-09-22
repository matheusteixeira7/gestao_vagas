package br.com.devnine.gestao_vagas.modules.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devnine.gestao_vagas.exceptions.UserfoundException;
import br.com.devnine.gestao_vagas.modules.company.dto.CreateCompanyInputDTO;
import br.com.devnine.gestao_vagas.modules.company.usecase.CreateCompanyUsecase;
import br.com.devnine.gestao_vagas.modules.company.usecase.FindAllCompaniesUsecase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private CreateCompanyUsecase createCompanyUsecase;
    private FindAllCompaniesUsecase findAllCompaniesUsecase;

    public CompanyController(
            CreateCompanyUsecase createCompanyUsecase,
            FindAllCompaniesUsecase findAllCompaniesUsecase) {
        this.createCompanyUsecase = createCompanyUsecase;
        this.findAllCompaniesUsecase = findAllCompaniesUsecase;
    }

    @PostMapping("")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CreateCompanyInputDTO input) {
        try {
            var result = this.createCompanyUsecase.execute(input);
            return ResponseEntity.ok(result);
        } catch (UserfoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<Object> findAllCompanies() {
        try {
            var result = this.findAllCompaniesUsecase.execute();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
