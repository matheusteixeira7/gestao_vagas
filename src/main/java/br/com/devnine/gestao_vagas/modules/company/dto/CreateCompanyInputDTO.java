package br.com.devnine.gestao_vagas.modules.company.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCompanyInputDTO {
    @NotBlank(message = "A descrição não pode ser vazia")
    private String description;

    @Email(message = "Deve ser um email válido")
    private String email;

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @Pattern(regexp = "\\S+", message = "O username não pode conter espaços")
    private String username;

    @Length(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
    private String password;

    @Pattern(regexp = "^(http|https)://.*$", message = "O website deve começar com http:// ou https://")
    private String website;
}
