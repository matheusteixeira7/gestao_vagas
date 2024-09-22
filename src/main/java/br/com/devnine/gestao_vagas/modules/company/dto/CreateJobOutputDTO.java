package br.com.devnine.gestao_vagas.modules.company.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateJobOutputDTO {
    private UUID id;
    private String description;
    private String benefits;
    private String level;
    private CompanyEntity companyEntity;
    private LocalDateTime createdAt;
}
