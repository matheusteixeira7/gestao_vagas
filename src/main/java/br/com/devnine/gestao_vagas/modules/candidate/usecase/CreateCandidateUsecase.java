package br.com.devnine.gestao_vagas.modules.candidate.usecase;

import org.springframework.stereotype.Service;

import br.com.devnine.gestao_vagas.exceptions.UserfoundException;
import br.com.devnine.gestao_vagas.modules.candidate.domain.CandidateEntity;
import br.com.devnine.gestao_vagas.modules.candidate.repository.CandidateRepository;

@Service
public class CreateCandidateUsecase {
    private final CandidateRepository candidateRepository;

    public CreateCandidateUsecase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserfoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}
