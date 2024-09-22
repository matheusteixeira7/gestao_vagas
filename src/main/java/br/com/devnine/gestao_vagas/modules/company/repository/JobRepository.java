package br.com.devnine.gestao_vagas.modules.company.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devnine.gestao_vagas.modules.company.entity.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
