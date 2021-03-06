package br.com.dca.condominio.model.repository;

import br.com.dca.condominio.model.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by denis on 13/01/16.
 */
@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {
}
