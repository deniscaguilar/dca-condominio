package br.com.dca.condominio.model.repository;

import br.com.dca.condominio.model.entity.Apartamento;
import br.com.dca.condominio.model.entity.Torre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by denis on 13/01/16.
 */
@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    List<Apartamento> findByTorre(Torre torre);

}
