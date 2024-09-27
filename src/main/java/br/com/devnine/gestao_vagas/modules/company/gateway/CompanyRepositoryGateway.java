package br.com.devnine.gestao_vagas.modules.company.gateway;

import java.util.List;
import java.util.Optional;

import br.com.devnine.gestao_vagas.modules.company.entity.CompanyEntity;

public interface CompanyRepositoryGateway {
    List<CompanyEntity> findAll();

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);

    Optional<CompanyEntity> findByEmail(String email);

    Optional<CompanyEntity> findByUsername(String username);
}
