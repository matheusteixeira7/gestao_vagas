package br.com.devnine.gestao_vagas.modules.candidate.usecase;

import org.springframework.stereotype.Service;

import br.com.devnine.gestao_vagas.exceptions.UserfoundException;
import br.com.devnine.gestao_vagas.modules.candidate.dto.CreateCandidateInputDTO;
import br.com.devnine.gestao_vagas.modules.candidate.dto.CreateCandidateOutputDTO;
import br.com.devnine.gestao_vagas.modules.candidate.entity.CandidateEntity;
import br.com.devnine.gestao_vagas.modules.candidate.repository.CandidateRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCandidateUsecase {
    private final CandidateRepository candidateRepository;

    public CreateCandidateOutputDTO execute(CreateCandidateInputDTO input) {
        this.candidateRepository
                .findByUsernameOrEmail(input.getUsername(), input.getEmail())
                .ifPresent(user -> {
                    throw new UserfoundException();
                });

        CandidateEntity candidate = CandidateEntity.builder()
                .username(input.getUsername())
                .name(input.getName())
                .email(input.getEmail())
                .password(input.getPassword())
                .description(input.getDescription())
                .curriculum(input.getCurriculum())
                .build();

        CandidateEntity savedCandidate = this.candidateRepository.save(candidate);

        return CreateCandidateOutputDTO.builder()
                .id(savedCandidate.getId())
                .name(savedCandidate.getName())
                .username(savedCandidate.getUsername())
                .email(savedCandidate.getEmail())
                .password(savedCandidate.getPassword())
                .description(savedCandidate.getDescription())
                .curriculum(savedCandidate.getCurriculum())
                .createdAt(savedCandidate.getCreatedAt())
                .build();
    }
}
