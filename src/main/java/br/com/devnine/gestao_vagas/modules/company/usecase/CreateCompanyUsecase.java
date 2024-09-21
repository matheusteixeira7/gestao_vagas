package br.com.devnine.gestao_vagas.modules.company.usecase;

import org.springframework.stereotype.Service;

import br.com.devnine.gestao_vagas.exceptions.UserfoundException;
import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;
import br.com.devnine.gestao_vagas.modules.company.repository.CompanyRepository;

@Service
public class CreateCompanyUsecase {
    private CompanyRepository companyRepository;

    public CreateCompanyUsecase(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent(company -> {
                    throw new UserfoundException();
                });

        return this.companyRepository.save(companyEntity);
    }
}
