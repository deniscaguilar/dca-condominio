package br.com.dca.condominio.model.repository;

import br.com.dca.condominio.model.entity.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by denis on 04/01/16.
 */
@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {
}
