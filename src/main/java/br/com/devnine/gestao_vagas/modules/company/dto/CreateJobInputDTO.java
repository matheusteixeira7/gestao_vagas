package br.com.devnine.gestao_vagas.modules.company.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobInputDTO {
    @NotBlank(message = "O título não pode ser vazio")
    private String description;

    @NotBlank(message = "A descrição não pode ser vazia")
    private String benefits;

    @NotBlank(message = "O nome não pode ser vazio")
    private String level;

    @NotBlank(message = "O username não pode ser vazio")
    private UUID companyId;
}
