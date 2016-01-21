package br.com.dca.condominio.model.repository;

import br.com.dca.condominio.model.entity.AreaComum;
import br.com.dca.condominio.model.entity.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by denis on 13/01/16.
 */
@Repository
public interface AreaComumRepository extends JpaRepository<AreaComum, Long> {

    List<AreaComum> findByCondominio(Condominio condominio);
}
