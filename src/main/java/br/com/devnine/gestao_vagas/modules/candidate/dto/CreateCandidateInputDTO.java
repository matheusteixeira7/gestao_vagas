package br.com.devnine.gestao_vagas.modules.candidate.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCandidateInputDTO {
    @NotBlank(message = "O username não pode ser vazio")
    private String username;

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @Email(message = "Deve ser um email válido")
    private String email;

    @Length(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
    private String password;

    @NotBlank(message = "A descrição não pode ser vazia")
    private String description;

    @NotBlank(message = "O currículo não pode ser vazio")
    private String curriculum;
}
