package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.dto.CargoDTO;
import br.com.meusindicato.sindicato.model.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo,Long> {

    List<Cargo> findByOrderByCargoDescricao();

    Page<Cargo> findAll(Specification<Cargo> spec, Pageable pageable);
}
