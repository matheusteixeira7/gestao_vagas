package br.com.devnine.gestao_vagas.modules.candidate.controllers;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @Pattern(regexp = "\\S+", message = "O username não pode conter espaços")
    private String username;

    @Email(message = "Deve ser um email válido")
    private String email;

    @Length(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
    private String password;
    private String description;
    private String curriculum;
}
