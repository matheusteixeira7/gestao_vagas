package br.com.devnine.gestao_vagas.modules.company.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;
import br.com.devnine.gestao_vagas.modules.company.repository.CompanyRepository;

@Service
public class FindAllCompaniesUsecase {
    private final CompanyRepository companyRepository;

    public FindAllCompaniesUsecase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyEntity> execute() {
        return companyRepository.findAll();
    }
}
