package br.com.devnine.gestao_vagas.modules.candidate.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCandidateOutputDTO {
    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculum;
    private LocalDateTime createdAt;
}
