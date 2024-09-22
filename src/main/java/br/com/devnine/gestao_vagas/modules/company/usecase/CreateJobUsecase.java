package br.com.devnine.gestao_vagas.modules.company.usecase;

import org.springframework.stereotype.Service;

import br.com.devnine.gestao_vagas.modules.company.dto.CreateJobInputDTO;
import br.com.devnine.gestao_vagas.modules.company.dto.CreateJobOutputDTO;
import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;
import br.com.devnine.gestao_vagas.modules.company.entity.JobEntity;
import br.com.devnine.gestao_vagas.modules.company.repository.CompanyRepository;
import br.com.devnine.gestao_vagas.modules.company.repository.JobRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateJobUsecase {
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public CreateJobOutputDTO execute(CreateJobInputDTO input) {
        CompanyEntity companyEntity = this.companyRepository.findById(input.getCompanyId())
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));

        JobEntity jobEntity = JobEntity.builder()
                .description(input.getDescription())
                .benefits(input.getBenefits())
                .level(input.getLevel())
                .companyId(companyEntity.getId())
                .build();

        JobEntity savedJob = this.jobRepository.save(jobEntity);

        return CreateJobOutputDTO.builder()
                .id(savedJob.getId())
                .description(savedJob.getDescription())
                .benefits(savedJob.getBenefits())
                .level(savedJob.getLevel())
                .companyEntity(companyEntity)
                .createdAt(savedJob.getCreatedAt())
                .build();
    }
}
