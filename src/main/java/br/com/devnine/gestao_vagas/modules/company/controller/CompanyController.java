package br.com.devnine.gestao_vagas.modules.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devnine.gestao_vagas.exceptions.UserfoundException;
import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;
import br.com.devnine.gestao_vagas.modules.company.usecase.CreateCompanyUsecase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private CreateCompanyUsecase createCompanyUsecase;

    public CompanyController(CreateCompanyUsecase createCompanyUsecase) {
        this.createCompanyUsecase = createCompanyUsecase;
    }

    @PostMapping("")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.createCompanyUsecase.execute(companyEntity);
            return ResponseEntity.ok(result);
        } catch (UserfoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
