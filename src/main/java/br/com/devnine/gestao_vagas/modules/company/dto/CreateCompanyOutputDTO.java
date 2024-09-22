package br.com.devnine.gestao_vagas.modules.company.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCompanyOutputDTO {
    private UUID id;
    private String description;
    private String email;
    private String name;
    private String username;
    private String password;
    private String website;
    private LocalDateTime createdAt;
}
