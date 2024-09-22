package br.com.devnine.gestao_vagas.modules.company.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobInputDTO {
    private String description;
    private String benefits;
    private String level;
    private UUID companyId;
}
