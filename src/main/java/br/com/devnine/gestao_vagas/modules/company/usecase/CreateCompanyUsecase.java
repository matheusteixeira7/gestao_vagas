package br.com.devnine.gestao_vagas.modules.company.usecase;

import org.springframework.stereotype.Service;

import br.com.devnine.gestao_vagas.exceptions.UserfoundException;
import br.com.devnine.gestao_vagas.modules.company.dto.CreateCompanyInputDTO;
import br.com.devnine.gestao_vagas.modules.company.dto.CreateCompanyOutputDTO;
import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;
import br.com.devnine.gestao_vagas.modules.company.repository.CompanyRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCompanyUsecase {
    private final CompanyRepository companyRepository;

    public CreateCompanyOutputDTO execute(CreateCompanyInputDTO input) {
        this.companyRepository
                .findByUsernameOrEmail(input.getUsername(), input.getEmail())
                .ifPresent(company -> {
                    throw new UserfoundException();
                });

        CompanyEntity company = CompanyEntity.builder()
                .description(input.getDescription())
                .email(input.getEmail())
                .name(input.getName())
                .username(input.getUsername())
                .password(input.getPassword())
                .website(input.getWebsite())
                .build();

        CompanyEntity savedCompany = this.companyRepository.save(company);

        return CreateCompanyOutputDTO.builder()
                .id(savedCompany.getId())
                .description(savedCompany.getDescription())
                .email(savedCompany.getEmail())
                .name(savedCompany.getName())
                .username(savedCompany.getUsername())
                .password(savedCompany.getPassword())
                .website(savedCompany.getWebsite())
                .createdAt(savedCompany.getCreatedAt())
                .build();
    }
}
