package br.com.devnine.gestao_vagas.modules.company.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUsername(String username);

    Optional<CompanyEntity> findByEmail(String email);

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @NonNull
    List<CompanyEntity> findAll();
}
